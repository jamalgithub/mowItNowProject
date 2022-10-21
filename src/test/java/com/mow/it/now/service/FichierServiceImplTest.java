package com.mow.it.now.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mow.it.now.common.Paramettres;
import com.mow.it.now.exception.TondeuseException;

@ExtendWith(MockitoExtension.class)
class FichierServiceImplTest {

	private final String TEST_CHEMIN_FICHIER = "src/test/resources/";

	@Mock
	private TondeuseService tondeuseService;
	@InjectMocks
	private FichierServiceImpl fichierService;

	@Test
	void demarerTraitementFichier_test_fichier_inexistant() throws TondeuseException, IOException {
		// given
		File file = new File(TEST_CHEMIN_FICHIER + "aaaaaa.txt");

		// when
		TondeuseException thrown = Assertions.assertThrows(TondeuseException.class, () -> {
			this.fichierService.demarerTraitementFichier(file);
		});

		// then
		assertThat(thrown.getMessage()).isEqualTo(Paramettres.ERREUR_FICHIER_INEXISTANT);
	}

	@ParameterizedTest
	@ValueSource(strings = { "fichier_vide.txt", "fichier_deux_lignes.txt", "fichier_ligne_manquante.txt",
			"fichier_donnees_incorrectes.txt" })
	void demarerTraitementFichier_test_fichier_erreur_ligne(String fileName) throws TondeuseException, IOException {
		// given
		File file = new File(TEST_CHEMIN_FICHIER + fileName);

		// when
		TondeuseException thrown = Assertions.assertThrows(TondeuseException.class, () -> {
			this.fichierService.demarerTraitementFichier(file);
		});

		// then
		assertThat(thrown.getMessage()).isEqualTo(Paramettres.ERREUR_DONNEES_INCORRECTES);
	}

}
