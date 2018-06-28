/**
 * 
 */
package com.imie.rpg.model.armure;

/**
 * @author florian
 *
 */
public class ArmureMagique extends Armure {
	
	private static final int VALEURDEFENSE	= 10;
	
	public ArmureMagique() {
		super(VALEURDEFENSE);
	}
	
	public ArmureMagique(String nom) {
		super(nom, VALEURDEFENSE);
	}
	
	public ArmureMagique(int valeurDefense) {
		super(valeurDefense);
	}
	
	public ArmureMagique(String nom, int valeurDefense) {
		super(nom, valeurDefense);
	}
	
}
