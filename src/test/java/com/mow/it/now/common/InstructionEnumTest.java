package com.mow.it.now.common;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class InstructionEnumTest {

	@Test
	void test() {
		assertThat(InstructionEnum.AVANCER.getCode()).isEqualTo('A');
		assertThat(InstructionEnum.AVANCER.getCode()).isNotEqualTo('D');
	}

}
