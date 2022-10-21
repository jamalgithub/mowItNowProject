package com.mow.it.now;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mow.it.now.service.FichierService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MowItNowProjectApplicationTests {

	@Autowired
	private FichierService fichierService;

	@Test
	void contextLoads() {
		Assertions.assertThat(this.fichierService).isNotNull();
	}
}
