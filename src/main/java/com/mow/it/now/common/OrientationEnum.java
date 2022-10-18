package com.mow.it.now.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Orientation selon la notation cardinale anglaise (N,E,W,S)
 * @author jamal
 *
 */
@Getter
@AllArgsConstructor
public enum OrientationEnum {
	NORTH('N', "Nord"), EAST('E', "est"), WEST('W', "ouest"), SOUTH('S', "sud");

	private char code;
	private String libelle;

}