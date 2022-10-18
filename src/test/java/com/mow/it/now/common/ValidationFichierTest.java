package com.mow.it.now.common;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class ValidationFichierTest {

	@Test
	void valider_pelouse_test() {
		assertThat(ValidationFichier.validerPelouse("")).isFalse();
		assertThat(ValidationFichier.validerPelouse("1 2 3")).isFalse();
		assertThat(ValidationFichier.validerPelouse("123")).isFalse();
		assertThat(ValidationFichier.validerPelouse("1 2 ")).isFalse();
		assertThat(ValidationFichier.validerPelouse("1 2")).isTrue();
		assertThat(ValidationFichier.validerPelouse("1 N")).isFalse();
	}

	@Test
	void valider_tondeuse_test() {
		assertThat(ValidationFichier.validerTondeuse("")).isFalse();
		assertThat(ValidationFichier.validerTondeuse("1 2 3")).isFalse();
		assertThat(ValidationFichier.validerTondeuse("12N")).isFalse();
		assertThat(ValidationFichier.validerTondeuse("1 2 N")).isTrue();
		assertThat(ValidationFichier.validerTondeuse("1 2 S")).isTrue();
	}

	@Test
	void valider_instructions_test() {
		assertThat(ValidationFichier.validerInstructions("")).isFalse();
		assertThat(ValidationFichier.validerInstructions(" ")).isFalse();
		assertThat(ValidationFichier.validerInstructions("D G")).isFalse();
		assertThat(ValidationFichier.validerInstructions("GGAAAGADDAN")).isFalse();
		assertThat(ValidationFichier.validerInstructions("GGAAAG ADDAN")).isFalse();
		assertThat(ValidationFichier.validerInstructions("DGA")).isTrue();
		assertThat(ValidationFichier.validerInstructions("GGAAAGADDA")).isTrue();
	}

}
