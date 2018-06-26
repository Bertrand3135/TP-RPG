/**
 * 
 */
package com.imie.rpg.model.arme;

/**
 * @author florian
 *
 */
public class ArmePhysique extends Arme {
	
	private static final int POINTSACTION	= 4;
	private static final int VALEURATTAQUE	= 7;
	
	public ArmePhysique() {
		super.setPointsAction(POINTSACTION);
		super.setValeurAttaque(VALEURATTAQUE);
	}
	
	public ArmePhysique(String nom) {
		this();
		
		super.setNom(nom);
	}

}
