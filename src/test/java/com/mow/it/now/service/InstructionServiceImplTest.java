package com.mow.it.now.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.mow.it.now.common.InstructionEnum;
import com.mow.it.now.common.OrientationEnum;
import com.mow.it.now.entites.Coordonnees;
import com.mow.it.now.entites.Position;
import com.mow.it.now.exception.TondeuseException;

class InstructionServiceImplTest {
	
	@Test
	void demarerTraitementInstruction_test_reculer() throws TondeuseException {
		// given
		InstructionServiceImpl instructionService = new InstructionServiceImpl();
		Position p = new Position(new Coordonnees(1, 2), OrientationEnum.NORTH);
		Coordonnees cMax = new Coordonnees(5, 5);

		// when
		instructionService.demarerTraitementInstruction(p, InstructionEnum.RECULER, cMax);

		// then
		assertThat(p.getCoordonnees()).isEqualTo(new Coordonnees(1, 1));
	}

	@Test
	void demarerTraitementInstruction_test_avancer() throws TondeuseException {
		// given
		InstructionServiceImpl instructionService = new InstructionServiceImpl();
		Position p = new Position(new Coordonnees(1, 2), OrientationEnum.NORTH);
		Coordonnees cMax = new Coordonnees(5, 5);

		// when
		instructionService.demarerTraitementInstruction(p, InstructionEnum.AVANCER, cMax);

		// then
		assertThat(p.getCoordonnees()).isEqualTo(new Coordonnees(1, 3));
	}

	@Test
	void demarerTraitementInstruction_test_pivoterDroite() throws TondeuseException {
		// given
		InstructionServiceImpl instructionService = new InstructionServiceImpl();
		Position p = new Position(new Coordonnees(1, 2), OrientationEnum.NORTH);
		Coordonnees cMax = new Coordonnees(5, 5);

		// when
		instructionService.demarerTraitementInstruction(p, InstructionEnum.DROITE, cMax);

		// then
		assertThat(p.getCoordonnees()).isEqualTo(new Coordonnees(1, 2));
		assertThat(p.getOrientation()).isEqualTo(OrientationEnum.EAST);
	}
	
	@Test
	void demarerTraitementInstruction_test_pivoterGauche() throws TondeuseException {
		// given
		InstructionServiceImpl instructionService = new InstructionServiceImpl();
		Position p = new Position(new Coordonnees(1, 2), OrientationEnum.NORTH);
		Coordonnees cMax = new Coordonnees(5, 5);

		// when
		instructionService.demarerTraitementInstruction(p, InstructionEnum.GAUCHE, cMax);

		// then
		assertThat(p.getCoordonnees()).isEqualTo(new Coordonnees(1, 2));
		assertThat(p.getOrientation()).isEqualTo(OrientationEnum.WEST);
	}

}
