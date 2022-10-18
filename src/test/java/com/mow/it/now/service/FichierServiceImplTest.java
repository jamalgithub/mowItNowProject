package com.mow.it.now.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mow.it.now.common.FichierDonnees;
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

	@Test
	void demarerTraitementFichier_test_fichier_erreur_zero_ligne() throws TondeuseException, IOException {
		// given
		File file = new File(TEST_CHEMIN_FICHIER + "fichier_vide.txt");

		// when
		TondeuseException thrown = Assertions.assertThrows(TondeuseException.class, () -> {
			this.fichierService.demarerTraitementFichier(file);
		});

		// then
		assertThat(thrown.getMessage()).isEqualTo(Paramettres.ERREUR_DONNEES_INCORRECTES);
	}

	@Test
	void demarerTraitementFichier_test_fichier_erreur_deux_lignes() throws TondeuseException, IOException {
		// given
		File file = new File(TEST_CHEMIN_FICHIER + "fichier_deux_lignes.txt");

		// when
		TondeuseException thrown = Assertions.assertThrows(TondeuseException.class, () -> {
			this.fichierService.demarerTraitementFichier(file);
		});

		// then
		assertThat(thrown.getMessage()).isEqualTo(Paramettres.ERREUR_DONNEES_INCORRECTES);
	}

	@Test
	void demarerTraitementFichier_test_fichier_erreur_ligne_manquante() throws TondeuseException, IOException {
		// given
		File file = new File(TEST_CHEMIN_FICHIER + "fichier_ligne_manquante.txt");

		// when
		TondeuseException thrown = Assertions.assertThrows(TondeuseException.class, () -> {
			this.fichierService.demarerTraitementFichier(file);
		});

		// then
		assertThat(thrown.getMessage()).isEqualTo(Paramettres.ERREUR_DONNEES_INCORRECTES);
	}

	@Test
	void demarerTraitementFichier_test_fichier_donnees_incorrectes() throws TondeuseException, IOException {
		// given
		File file = new File(TEST_CHEMIN_FICHIER + "fichier_donnees_incorrectes.txt");

		// when
		TondeuseException thrown = Assertions.assertThrows(TondeuseException.class, () -> {
			this.fichierService.demarerTraitementFichier(file);
		});

		// then
		assertThat(thrown.getMessage()).isEqualTo(Paramettres.ERREUR_DONNEES_INCORRECTES);
	}

	@Test
	void demarerTraitementFichier_test_fichier_donnees_correctes() throws TondeuseException, IOException {
		// given
		File file = new File(TEST_CHEMIN_FICHIER + "fichier_donnees_correctes.txt");

		// when
		when(this.tondeuseService.demarerTraitementTondeuse(any(FichierDonnees.class))).thenReturn("1 3 N")
				.thenReturn("5 1 E");
		List<String> res = this.fichierService.demarerTraitementFichier(file);

		// then
		assertThat(res.size()).isEqualTo(2);
		assertThat(res.contains("1 3 N")).isTrue();
		assertThat(res.contains("5 1 E")).isTrue();
	}

}
