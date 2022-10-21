package com.mow.it.now;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import com.mow.it.now.service.FichierService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MowItNowProjectApplication implements CommandLineRunner {

	@Autowired
	private FichierService fichierService;
	@Value("${application.input.source}")
	private Resource resourceFile;

	public static void main(String[] args) {
		SpringApplication.run(MowItNowProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		File fichier = this.resourceFile.getFile();
		List<String> resultats = this.fichierService.demarerTraitementFichier(fichier);
		log.info("{}", resultats.stream().collect(Collectors.joining(" ")));
	}

}
