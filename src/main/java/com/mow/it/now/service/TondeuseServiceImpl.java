package com.mow.it.now.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mow.it.now.common.InstructionEnum;
import com.mow.it.now.common.FichierDonnees;
import com.mow.it.now.exception.TondeuseException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TondeuseServiceImpl implements TondeuseService {

	@Autowired
	private InstructionService instructionService;

	/**
	 * demarer le traitement de la tondeuse
	 * 
	 * @param fichierDonnees l'objet contenant les informations de parse du fichier
	 * @return la position de la tondeuse
	 * @throws TondeuseException
	 */
	public String demarerTraitementTondeuse(FichierDonnees fichierDonnees) throws TondeuseException {

		for (InstructionEnum instruction : fichierDonnees.getInstructions()) {
			instructionService.demarerTraitementInstruction(fichierDonnees.getTondeuse().getPosition(), instruction,
					fichierDonnees.getPelouse().getPositionMax());
		}

		log.info("{}", fichierDonnees.getTondeuse().getPosition());

		return fichierDonnees.getTondeuse().getPosition().toString();
	}

}