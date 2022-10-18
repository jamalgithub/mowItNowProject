package com.mow.it.now.common;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mow.it.now.entites.Coordonnees;
import com.mow.it.now.entites.Pelouse;
import com.mow.it.now.entites.Position;
import com.mow.it.now.entites.Tondeuse;

class FichierDonneesTest {

	@Test
	void test() {
		Pelouse p1 = new Pelouse(new Coordonnees(5, 5));
		Tondeuse t1 = new Tondeuse(new Position(new Coordonnees(2, 2), OrientationEnum.NORTH));
		List<InstructionEnum> instructions1 = FormateurLigne.formateurLigneInstruction("GAGAGAGAA");
		List<InstructionEnum> instructions2 = FormateurLigne.formateurLigneInstruction("GAGAGAGAA");
		List<InstructionEnum> instructions3 = FormateurLigne.formateurLigneInstruction("GAGAGAGA");
		FichierDonnees f1 = new FichierDonnees(p1, t1, instructions1);
		FichierDonnees f2 = new FichierDonnees(p1, t1, instructions2);
		FichierDonnees f3 = new FichierDonnees(p1, t1, instructions3);

		assertThat(f1).isEqualTo(f2);
		assertThat(f1).isNotEqualTo(f3);
	}

}
