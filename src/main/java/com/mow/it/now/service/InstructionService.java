package com.mow.it.now.service;

import com.mow.it.now.common.InstructionEnum;
import com.mow.it.now.entites.Coordonnees;
import com.mow.it.now.entites.Position;
import com.mow.it.now.exception.TondeuseException;

public interface InstructionService {

	public void demarerTraitementInstruction(Position position, InstructionEnum instruction, Coordonnees coordonnesMax)
			throws TondeuseException;

}
