package com.mow.it.now.entites;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import com.mow.it.now.common.OrientationEnum;

class TondeuseTest {

	@Test
	void test() {
		Tondeuse t1 = new Tondeuse(new Position(new Coordonnees(1, 2), OrientationEnum.EAST));
		Tondeuse t2 = new Tondeuse(new Position(new Coordonnees(1, 2), OrientationEnum.EAST));
		Tondeuse t3 = new Tondeuse(new Position(new Coordonnees(1, 2), OrientationEnum.NORTH));
		
		assertThat(t1).isEqualTo(t2);
		assertThat(t1).isNotEqualTo(t3);
	}

}
