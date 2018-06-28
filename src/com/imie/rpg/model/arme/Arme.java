/**
 * 
 */
package com.imie.rpg.model.arme;

import com.imie.rpg.model.Butin;

/**
 * @author florian
 *
 */
public abstract class Arme extends Butin {
	
	private static final String NOMPARDEFAUT	= "jefaispasmal";
	private static final int PAPARDEFAUT		= 10;
	private static final int ATTAQUEPARDEFAUT	= 1;
	
	private String nom;
	private int pointsAction;
	private int valeurAttaque;
	
	public Arme() {
		this(NOMPARDEFAUT, PAPARDEFAUT, ATTAQUEPARDEFAUT);
	}
	
	public Arme(String nom) {
		this(nom, PAPARDEFAUT, ATTAQUEPARDEFAUT);
	}
	
	public Arme(int pa, int attaque) {
		this(NOMPARDEFAUT, pa, attaque);
	}
	
	public Arme(String nom, int pa, int attaque) {
		this.setNom(nom);
		this.setPointsAction(pa);
		this.setValeurAttaque(attaque);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getPointsAction() {
		return pointsAction;
	}
	public void setPointsAction(int pointsAction) {
		this.pointsAction = pointsAction;
	}
	
	public int getValeurAttaque() {
		return valeurAttaque;
	}
	public void setValeurAttaque(int valeurAttaque) {
		this.valeurAttaque = valeurAttaque;
	}

}
