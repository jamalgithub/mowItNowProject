package com.mow.it.now.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.mow.it.now.exception.TondeuseException;

public interface FichierService {
	public List<String> demarerTraitementFichier(File fichier) throws TondeuseException, IOException;
}
