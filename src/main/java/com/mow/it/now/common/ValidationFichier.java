package com.mow.it.now.common;

/**
 * 
 * permet de valider les lignes du fichier
 *
 */
public class ValidationFichier {

	private ValidationFichier() {
		throw new IllegalStateException("Cette class ne peut pas être instancié");
	}

	/**
	 * valider la position de la pelouse sous forme de 2 chiffres séparés par un espace
	 * 
	 * @param pelouse
	 * @return true si la ligne des positions est correcte, false sinon
	 */
	public static boolean validerPelouse(String pelouse) {
		return pelouse.matches("(\\d+) (\\d+)");
	}

	/**
	 * valider la position de la tondeuse et son orientation sous la forme de 2 chiffres et une lettre,
	 * séparés par un espace
	 * 
	 * @param tondeuse
	 * @return true si la ligne de tondeuse est correcte, false sinon
	 */
	public static boolean validerTondeuse(String tondeuse) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(OrientationEnum.NORTH.getCode()).append("|").append(OrientationEnum.SOUTH.getCode())
				.append("|").append(OrientationEnum.EAST.getCode()).append("|").append(OrientationEnum.WEST.getCode());
		return tondeuse.matches("(\\d+) (\\d+) (" + stringBuilder.toString() + ")");
	}

	/**
	 * valider la ligne des instructions sous forme d'une suite de caractères(G, D, A) sans espaces
	 * 
	 * @param instructions
	 * @return true si la ligne des instructions est correcte, false sinon
	 */
	public static boolean validerInstructions(String instructions) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(InstructionEnum.AVANCER.getCode()).append("|").append(InstructionEnum.DROITE.getCode())
				.append("|").append(InstructionEnum.GAUCHE.getCode());

		return instructions.matches("(" + stringBuilder.toString() + ")+");
	}
}
