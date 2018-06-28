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
		super(POINTSACTION, VALEURATTAQUE);
	}
	
	public ArmePhysique(String nom) {
		super(nom, POINTSACTION, VALEURATTAQUE);
	}
	
	public ArmePhysique(int attaque) {
		super(POINTSACTION, attaque);
	}
	
	public ArmePhysique(int pa, int attaque) {
		super(pa, attaque);
	}
	
	public ArmePhysique(String nom, int pa, int attaque) {
		super(nom, pa, attaque);
	}

}
