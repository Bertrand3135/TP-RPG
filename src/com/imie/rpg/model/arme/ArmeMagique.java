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
		super(POINTSACTION, VALEURATTAQUE);
	}
	
	public ArmeMagique(String nom) {
		super(nom, POINTSACTION, VALEURATTAQUE);
	}
	
	public ArmeMagique(int attaque) {
		super(POINTSACTION, attaque);
	}
	
	public ArmeMagique(int pa, int attaque) {
		super(pa, attaque);
	}
	
	public ArmeMagique(String nom, int pa, int attaque) {
		super(nom, pa, attaque);
	}
	
}
