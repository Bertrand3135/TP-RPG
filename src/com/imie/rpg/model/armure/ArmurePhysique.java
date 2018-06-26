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
		super.setValeurDefense(VALEURDEFENSE);
	}
	
	public ArmurePhysique(String nom) {
		this();
		
		super.setNom(nom);
	}

}
