/**
 * 
 */
package com.imie.rpg.model.arme;

/**
 * @author florian
 *
 */
public class ArmeMagique extends Arme {
	
	private static final int POINTSACTION	= 8;
	private static final int VALEURATTAQUE	= 10;
	
	public ArmeMagique() {
		super.setPointsAction(POINTSACTION);
		super.setValeurAttaque(VALEURATTAQUE);
	}
	
	public ArmeMagique(String nom) {
		this();
		
		super.setNom(nom);
	}
	
}
