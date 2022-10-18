package com.mow.it.now.service;

import java.util.function.BiPredicate;

import org.springframework.stereotype.Service;

import com.mow.it.now.common.InstructionEnum;
import com.mow.it.now.common.OrientationEnum;
import com.mow.it.now.common.Paramettres;
import com.mow.it.now.entites.Coordonnees;
import com.mow.it.now.entites.Position;
import com.mow.it.now.exception.TondeuseException;

@Service
public class InstructionServiceImpl implements InstructionService {

	/**
	 * executer une instruction (A, D ou G)
	 * 
	 * @param position
	 * @param instruction
	 * @param coordonnesMax
	 * @throws TondeuseException
	 */
	public void demarerTraitementInstruction(Position position, InstructionEnum instruction, Coordonnees coordonnesMax)
			throws TondeuseException {

		switch (instruction) {
			case AVANCER:
				position.setCoordonnees(this.avancerTondeuse(position, coordonnesMax));
				break;

			case DROITE:
				position.setOrientation(this.pivoterDroite(position.getOrientation()));
				break;

			case GAUCHE:
				position.setOrientation(this.pivoterGauche(position.getOrientation()));
				break;

			default:
				throw new TondeuseException(Paramettres.INSTRUCTION_INCORRECTE);
		}

	}

	/**
	 * faire avancer la tondeuse, si les nouvelles coordonnées sont en dehors de la pelouse, on garde la
	 * derniere position
	 * 
	 * @param position      position initiale de la tondeuse
	 * @param coordonnesMax position maximal de la pelouse (coin superieur droit)
	 * @return coordonnees nouvelles coordonnees de la tondeuse
	 * @throws TondeuseException
	 */
	private Coordonnees avancerTondeuse(Position position, Coordonnees coordonnesMax) throws TondeuseException {
		Coordonnees coordonneesSuivantes = null;
		int x, y;

		switch (position.getOrientation()) {
			case NORTH:
				x = position.getCoordonnees().getX();
				y = position.getCoordonnees().getY() + 1;
				break;

			case EAST:
				x = position.getCoordonnees().getX() + 1;
				y = position.getCoordonnees().getY();
				break;

			case SOUTH:
				x = position.getCoordonnees().getX();
				y = position.getCoordonnees().getY() - 1;
				break;

			case WEST:
				x = position.getCoordonnees().getX() - 1;
				y = position.getCoordonnees().getY();
				break;

			default:
				throw new TondeuseException(Paramettres.POSITION_INCORRECTE);
		}

		coordonneesSuivantes = new Coordonnees(x, y);

		if (this.isTondeuseDehorsPelouse(coordonneesSuivantes, coordonnesMax)) {
			return coordonneesSuivantes;
		} else {
			return position.getCoordonnees();
		}

	}

	/**
	 * pivoter la tondeuse à droite
	 * 
	 * @param orientation orientation initiale de la tondeuse
	 * @return nouvelle orientation
	 * @throws TondeuseException
	 */
	private OrientationEnum pivoterDroite(OrientationEnum orientation) throws TondeuseException {
		OrientationEnum orientationSuivante = null;

		switch (orientation) {
			case NORTH:
				orientationSuivante = OrientationEnum.EAST;
				break;

			case EAST:
				orientationSuivante = OrientationEnum.SOUTH;
				break;

			case SOUTH:
				orientationSuivante = OrientationEnum.WEST;
				break;

			case WEST:
				orientationSuivante = OrientationEnum.NORTH;
				break;

			default:
				throw new TondeuseException(Paramettres.ORIENTATION_INCORRECTE);
		}

		return orientationSuivante;
	}

	/**
	 * pivoter la tondeuse à gauche
	 * 
	 * @param orientation orientation initale de la tondeuse
	 * @return nouvelle orientation
	 * @throws TondeuseException
	 */
	private OrientationEnum pivoterGauche(OrientationEnum orientation) throws TondeuseException {
		OrientationEnum orientationSuivante = null;

		switch (orientation) {
			case NORTH:
				orientationSuivante = OrientationEnum.WEST;
				break;

			case EAST:
				orientationSuivante = OrientationEnum.NORTH;
				break;

			case SOUTH:
				orientationSuivante = OrientationEnum.EAST;
				break;

			case WEST:
				orientationSuivante = OrientationEnum.SOUTH;
				break;

			default:
				throw new TondeuseException(Paramettres.ORIENTATION_INCORRECTE);
		}

		return orientationSuivante;
	}

	/**
	 * vérifier si la tondeuse est est à l'interieur de la pelouse
	 * 
	 * @param tCoordonnees coordonnées de la tondeuse
	 * @param pCoordonnees coordonnées de la pelouse
	 * @return true si les coordonnées de la tondeuse sont à l'intérieur de la pelouse, false sinon
	 */
	private boolean isTondeuseDehorsPelouse(Coordonnees tCoordonnees, Coordonnees pCoordonnees) {
		BiPredicate<Coordonnees, Coordonnees> coordonneesPositives = (tCoord, pCoord) -> tCoord.getX() >= 0
				&& tCoord.getY() >= 0 && pCoord.getX() >= 0 && pCoord.getY() >= 0;
		BiPredicate<Coordonnees, Coordonnees> tondeuseInterieurPelouse = (tCoord,
				pCoord) -> (tCoord.getX() <= pCoord.getX() && tCoord.getY() <= pCoord.getY());

		return coordonneesPositives.and(tondeuseInterieurPelouse).test(tCoordonnees, pCoordonnees);
	}
}