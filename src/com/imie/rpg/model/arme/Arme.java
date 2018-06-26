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
	
	private String nom;
	private int pointsAction;
	private int valeurAttaque;
	
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
