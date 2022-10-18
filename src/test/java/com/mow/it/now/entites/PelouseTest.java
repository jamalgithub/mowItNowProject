package com.mow.it.now.entites;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class PelouseTest {

	@Test
	void test() {
		Pelouse p1 = new Pelouse(new Coordonnees(1, 2));
		Pelouse p2 = new Pelouse(new Coordonnees(1, 2));
		assertThat(p1).isEqualTo(p2);
		p2 = new Pelouse(new Coordonnees(1, 3));
		assertThat(p1).isNotEqualTo(p2);
	}

}
