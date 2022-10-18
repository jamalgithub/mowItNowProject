package com.mow.it.now.common;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class ParamettresTest {

	@Test
	void test() {
		assertThat(Paramettres.ERREUR_DONNEES_INCORRECTES).isEqualTo("données incorrectes");
		assertThat(Paramettres.ERREUR_DONNEES_INCORRECTES).isNotEqualTo("fichier inexistant");
	}

}
