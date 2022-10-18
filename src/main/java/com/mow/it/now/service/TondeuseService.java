package com.mow.it.now.service;

import com.mow.it.now.common.FichierDonnees;
import com.mow.it.now.exception.TondeuseException;

public interface TondeuseService {
	public String demarerTraitementTondeuse(FichierDonnees fichierDonnees) throws TondeuseException;
}
