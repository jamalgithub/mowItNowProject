package com.mow.it.now.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mow.it.now.common.FichierDonnees;
import com.mow.it.now.common.FormateurLigne;
import com.mow.it.now.common.InstructionEnum;
import com.mow.it.now.common.OrientationEnum;
import com.mow.it.now.entites.Coordonnees;
import com.mow.it.now.entites.Pelouse;
import com.mow.it.now.entites.Position;
import com.mow.it.now.entites.Tondeuse;
import com.mow.it.now.exception.TondeuseException;

@ExtendWith(MockitoExtension.class)
class TondeuseServiceImplTest {

	@Mock
	private InstructionService instructionService;
	@InjectMocks
	private TondeuseServiceImpl tondeuseService;

	@Test
	void demarerTraitementTondeuse_test() throws TondeuseException {
		// given
		Pelouse p = new Pelouse(new Coordonnees(5, 5));
		Tondeuse t = new Tondeuse(new Position(new Coordonnees(1, 2), OrientationEnum.NORTH));
		List<InstructionEnum> instructions = FormateurLigne.formateurLigneInstruction("A");
		FichierDonnees fichierDonnees = new FichierDonnees(p, t, instructions);

		// when
		doAnswer(invocation -> {
	        Position position = invocation.getArgument(0);
	        position.getCoordonnees().setY(3);
			return null;
		}).when(this.instructionService).demarerTraitementInstruction(any(Position.class),
				any(InstructionEnum.class), any(Coordonnees.class));

		this.tondeuseService.demarerTraitementTondeuse(fichierDonnees);
		
		// then
		assertThat(fichierDonnees.getTondeuse().getPosition().getCoordonnees()).isEqualTo(new Coordonnees(1, 3));
	}

}
