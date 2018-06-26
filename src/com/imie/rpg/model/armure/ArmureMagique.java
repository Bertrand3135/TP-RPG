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
		super.setValeurDefense(VALEURDEFENSE);
	}
	
	public ArmureMagique(String nom) {
		this();
		
		super.setNom(nom);
	}
	
}
