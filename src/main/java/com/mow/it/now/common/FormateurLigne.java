package com.mow.it.now.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mow.it.now.entites.Coordonnees;
import com.mow.it.now.entites.Pelouse;
import com.mow.it.now.entites.Position;
import com.mow.it.now.entites.Tondeuse;

/**
 * 
 * permettre de formatter les lignes de fichier
 *
 */
public class FormateurLigne {

	private FormateurLigne() {
		throw new IllegalStateException("Cette class ne peut pas être instancié");
	}

	/**
	 * formatter ligneTondeuse en objet tondeuse
	 * 
	 * @param ligneTondeuse ligne de la position de la tondeuse (ex : 2 3 G)
	 * @return l'objet tondeuse
	 */
	public static Tondeuse formateurLigneTondeuse(String ligneTondeuse) {
		String[] tabTondeuse = ligneTondeuse.split(StringUtils.SPACE);
		Coordonnees coordonnees = new Coordonnees(Integer.valueOf(tabTondeuse[0]), Integer.valueOf(tabTondeuse[1]));
		OrientationEnum orientation = getOrientation(tabTondeuse[2].charAt(0));
		Position position = new Position(coordonnees, orientation);

		return new Tondeuse(position);
	}

	/**
	 * formatter lignePelouse en objet Pelouse
	 * 
	 * @param lignePelouse ligne de la pelouse (ex : 2 3)
	 * @return l'objet pelouse
	 */
	public static Pelouse formateurLignePelouse(String lignePelouse) {
		String[] tabPelouse = lignePelouse.split(StringUtils.SPACE);
		return new Pelouse(new Coordonnees(Integer.valueOf(tabPelouse[0]), Integer.valueOf(tabPelouse[1])));
	}

	/**
	 * formatter la ligne d'instruction en liste d'enum Instruction
	 * 
	 * @param ligneInstruction suite d'instruction (ex : GDAGD)
	 * @return une liste d'enum InstrctionTondeuse
	 */
	public static List<InstructionEnum> formateurLigneInstruction(String ligneInstruction) {
		List<InstructionEnum> instructions = new ArrayList<>();

		for (char instruction : ligneInstruction.toCharArray()) {
			instructions.add(getInstruction(instruction));
		}

		return instructions;
	}

	/**
	 * récuperer un objet Orientation correspondant au caractère de l'orientation
	 * 
	 * @param cOrientation : caractère de l'orientation (E, W, N, S)
	 * @return l'enum correspondant à l'orientation
	 */
	public static OrientationEnum getOrientation(char cOrientation) {

		for (OrientationEnum orientation : OrientationEnum.values()) {

			if (orientation.getCode() == cOrientation) {
				return orientation;
			}

		}

		return null;
	}

	/**
	 * récuperer un objet Instruction correspondant au caractère d'instrction
	 * 
	 * @param cInstruction caractère de l'instruction (A, G, D)
	 * @return l'enum correspondant à l'instruction
	 */
	public static InstructionEnum getInstruction(char cInstruction) {

		for (InstructionEnum instruction : InstructionEnum.values()) {

			if (instruction.getCode() == cInstruction) {
				return instruction;
			}

		}

		return null;
	}
}