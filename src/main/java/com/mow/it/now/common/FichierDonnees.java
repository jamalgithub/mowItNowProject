package com.mow.it.now.common;

import java.util.List;

import com.mow.it.now.entites.Pelouse;
import com.mow.it.now.entites.Tondeuse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichierDonnees {
	
	private Pelouse pelouse;
	private Tondeuse tondeuse;
	private List<InstructionEnum> instructions;
}
