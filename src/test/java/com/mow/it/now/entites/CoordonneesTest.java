package com.mow.it.now.entites;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CoordonneesTest {

	@Test
	void test() {
		Coordonnees c1 = new Coordonnees(1, 2);
		Coordonnees c2 = new Coordonnees(1, 2);
		assertThat(c1).isEqualTo(c2);
		c2 = new Coordonnees(1, 3);
		assertThat(c1).isNotEqualTo(c2);
	}

}
