package com.mow.it.now.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mow.it.now.common.FichierDonnees;
import com.mow.it.now.common.FormateurLigne;
import com.mow.it.now.common.Paramettres;
import com.mow.it.now.common.ValidationFichier;
import com.mow.it.now.exception.TondeuseException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FichierServiceImpl implements FichierService {

	@Autowired
	private TondeuseService tondeuseService;

	/**
	 * lecture et traitement des lignes de fichier
	 * 
	 * @param fichier
	 * @throws TondeuseException
	 * @throws IOException
	 * @return Liste des positions des tondeuses
	 */
	public List<String> demarerTraitementFichier(File fichier) throws TondeuseException, IOException {

		if (!fichier.isFile()) {
			throw new TondeuseException(Paramettres.ERREUR_FICHIER_INEXISTANT);
		} else {
			FichierDonnees fichierDonnees = new FichierDonnees();
			Scanner scanner = new Scanner(fichier);
			List<String> positions = new ArrayList<>();

			try {
				this.traiterPremiereLigne(scanner, fichierDonnees);
				positions = this.traiterLignesRestantes(scanner, fichierDonnees);
				return positions;
			} finally {
				scanner.close();
			}

		}

	}

	/**
	 * traiter la premiere ligne du fichier
	 * 
	 * @param scanner
	 * @param fichierDonnees l'objet contenant les informations de parse du fichier
	 * @throws TondeuseException
	 */
	private void traiterPremiereLigne(Scanner scanner, FichierDonnees fichierDonnees) throws TondeuseException {

		if (scanner.hasNext()) {
			String lignePelouse = scanner.nextLine();

			if (!ValidationFichier.validerPelouse(lignePelouse)) {
				throw new TondeuseException(Paramettres.ERREUR_DONNEES_INCORRECTES);
			}

			fichierDonnees.setPelouse(FormateurLigne.formateurLignePelouse(lignePelouse));
		} else {
			throw new TondeuseException(Paramettres.ERREUR_DONNEES_INCORRECTES);
		}

	}

	/**
	 * traiter les lignes restantes du fichier
	 * 
	 * @param scanner
	 * @param fichierDonnees l'objet contenant les informations de parse du fichier
	 * @return Liste des positions des tondeuses
	 * @throws TondeuseException
	 */
	private List<String> traiterLignesRestantes(Scanner scanner, FichierDonnees fichierDonnees)
			throws TondeuseException {
		List<String> positions = new ArrayList<>();
		int i = 0;

		while (scanner.hasNext()) {
			String ligneTondeuse = scanner.nextLine();

			if (!ValidationFichier.validerTondeuse(ligneTondeuse)) {
				throw new TondeuseException(Paramettres.ERREUR_DONNEES_INCORRECTES);
			}

			fichierDonnees.setTondeuse(FormateurLigne.formateurLigneTondeuse(ligneTondeuse));

			if (scanner.hasNext()) {
				String ligneInstructions = scanner.nextLine();

				if (!ValidationFichier.validerInstructions(ligneInstructions)) {
					throw new TondeuseException(Paramettres.ERREUR_DONNEES_INCORRECTES);
				}

				fichierDonnees.setInstructions(FormateurLigne.formateurLigneInstruction(ligneInstructions));
				String positionFinal = this.tondeuseService.demarerTraitementTondeuse(fichierDonnees);
				log.info("La position de la tondeuse {} après mouvement : {}", ++i, positionFinal);
				positions.add(positionFinal);

			} else {
				throw new TondeuseException(Paramettres.ERREUR_DONNEES_INCORRECTES);
			}

		}

		return positions;
	}

}
