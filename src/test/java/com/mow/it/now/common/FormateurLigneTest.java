package com.mow.it.now.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.mow.it.now.entites.Coordonnees;
import com.mow.it.now.entites.Pelouse;

class FormateurLigneTest {

	@Test
	void formateurLignePelouse_test() {
		assertThat(FormateurLigne.formateurLignePelouse("10 15")).isEqualTo(new Pelouse(new Coordonnees(10, 15)));
	}

	@Test
	void formateurLigneTondeuse_test() {
		assertThat(FormateurLigne.formateurLigneTondeuse("10 15 N").getPosition().getCoordonnees())
				.isEqualTo(new Coordonnees(10, 15));
		assertThat(FormateurLigne.formateurLigneTondeuse("10 15 N").getPosition().getOrientation())
				.isEqualTo(OrientationEnum.NORTH);
	}

	@Test
	void formateurLigneInstruction_test() {
		assertThat(FormateurLigne.formateurLigneInstruction("DGAD")).hasSize(4);
		assertThat(FormateurLigne.formateurLigneInstruction("DAD")).contains(InstructionEnum.DROITE);
		assertThat(FormateurLigne.formateurLigneInstruction("DAD")).doesNotContain(InstructionEnum.GAUCHE);
	}

	@Test
	void getOrientation_test() {
		assertThat(FormateurLigne.getOrientation('E')).isEqualTo(OrientationEnum.EAST);
		assertThat(FormateurLigne.getOrientation('N')).isEqualTo(OrientationEnum.NORTH);
		assertThat(FormateurLigne.getOrientation('S')).isEqualTo(OrientationEnum.SOUTH);
		assertThat(FormateurLigne.getOrientation('W')).isEqualTo(OrientationEnum.WEST);
		assertThat(FormateurLigne.getOrientation('a')).isNull();
	}

	@Test
	void getInstruction_test() {
		assertThat(FormateurLigne.getInstruction('A')).isEqualTo(InstructionEnum.AVANCER);
		assertThat(FormateurLigne.getInstruction('D')).isEqualTo(InstructionEnum.DROITE);
		assertThat(FormateurLigne.getInstruction('G')).isEqualTo(InstructionEnum.GAUCHE);
		assertThat(FormateurLigne.getInstruction(' ')).isNull();
	}

}
