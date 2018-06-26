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
	
	private String nom;
	private int valeurDefense;
	
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
