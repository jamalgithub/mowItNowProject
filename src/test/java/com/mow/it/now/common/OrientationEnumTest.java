package com.mow.it.now.common;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class OrientationEnumTest {

	@Test
	void test() {
		assertThat(OrientationEnum.EAST.getCode()).isEqualTo('E');
		assertThat(OrientationEnum.EAST.getCode()).isNotEqualTo('N');
	}

}
