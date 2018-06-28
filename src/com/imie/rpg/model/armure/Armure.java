/**
 * 
 */
package com.imie.rpg.model.armure;

import com.imie.rpg.model.Butin;

/**
 * @author florian
 *
 */
public abstract class Armure extends Butin {
	
	private static final String NOMPARDEFAUT	= "jaipastrouvedenom";
	private static final int DEFENSEPARDEFAUT	= 1;
	
	private String nom;
	private int valeurDefense;
	
	public Armure() {
		this(DEFENSEPARDEFAUT);
	}
	
	public Armure(int valeurDefense) {
		this(NOMPARDEFAUT, valeurDefense);
	}
	
	public Armure(String nom) {
		this(nom, DEFENSEPARDEFAUT);
	}
	
	public Armure(String nom, int valeurDefense) {
		this.setNom(nom);
		this.setValeurDefense(valeurDefense);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getValeurDefense() {
		return valeurDefense;
	}
	public void setValeurDefense(int valeurDefense) {
		this.valeurDefense = valeurDefense;
	}

}
