package com.mow.it.now.entites;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import com.mow.it.now.common.OrientationEnum;

class PositionTest {

	@Test
	void test() {
		Position p1 = new Position(new Coordonnees(5, 5), OrientationEnum.NORTH);
		Position p2 = new Position(new Coordonnees(5, 5), OrientationEnum.NORTH);
		Position p3 = new Position(new Coordonnees(5, 5), OrientationEnum.SOUTH);

		assertThat(p1).isEqualTo(p2);
		assertThat(p1).isNotEqualTo(p3);
	}

}
