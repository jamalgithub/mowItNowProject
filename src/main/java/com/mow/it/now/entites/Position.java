package com.mow.it.now.entites;

import com.mow.it.now.common.OrientationEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Position de la tondeuse est représentée par ses coordonnées et son orientation
 * 
 * @author jamal
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {

	private Coordonnees coordonnees;
	private OrientationEnum orientation;

	@Override
	public String toString() {
		return coordonnees.getX() + " " + coordonnees.getY() + " " + orientation.getCode();
	}
}