/**
 * 
 */
package com.imie.rpg.model.armure;

/**
 * @author florian
 *
 */
public class ArmurePhysique extends Armure {
	
	private static final int VALEURDEFENSE	= 7;
	
	public ArmurePhysique() {
		super(VALEURDEFENSE);
	}
	
	public ArmurePhysique(String nom) {
		super(nom);
	}
	
	public ArmurePhysique(int valeurDefense) {
		super(valeurDefense);
	}
	
	public ArmurePhysique(String nom, int valeurDefense) {
		super(nom, valeurDefense);
	}

}
