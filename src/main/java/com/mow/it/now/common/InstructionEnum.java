package com.mow.it.now.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Instruction à donner à la tondeuse pour explorer la pelouse
 * @author jamal
 *
 */
@Getter
@AllArgsConstructor
public enum InstructionEnum {
	DROITE('D', "Pivoter à droite 90°"), GAUCHE('G', "Pivoter à gauche 90°"), AVANCER('A', "Avancer une case dans la direction");

	private char code;
	private String libelle;

}