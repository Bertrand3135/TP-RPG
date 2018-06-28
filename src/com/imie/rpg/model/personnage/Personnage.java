/**
 * 
 */
package com.imie.rpg.model.personnage;

import java.util.List;

import com.imie.rpg.controler.IPersonnage;
import com.imie.rpg.model.Butin;
import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.armure.Armure;

/**
 * @author florian
 *
 */
public abstract class Personnage implements IPersonnage {
	
	private static final String NOMPARDEFAUT	= "Personne";
	private static final int PDVPARDEFAUT		= 10;
	private static final int PAPARDEFAUT		= 5;
	
	private static final String MSGNESTPASEQUIPE	= "Le %s n’a pas pu s’équiper.";
	private static final String MSGESTEQUIPE		= "Le %s a équipé son %s.";
	
	private String nom;
	private int pointsDeVie;
	private int pointsAction;
	private Armure armure;
	private Arme arme;
	private List<Butin> butins;
	private String type;
	
	public Personnage() {
		this(NOMPARDEFAUT, PDVPARDEFAUT, PAPARDEFAUT);
	}
	
	public Personnage(int pointDeVie, int pointsAction) {
		this(NOMPARDEFAUT, pointDeVie, pointsAction, null, null);
	}
	
	public Personnage(String nom, int pointDeVie, int pointsAction) {
		this(nom, pointDeVie, pointsAction, null, null);
	}
	
	public Personnage(String nom, int pointsDeVie, int pointsAction, Armure armure, Arme arme) {
		this(nom, pointsDeVie, pointsAction, armure, arme, null, "");		
	}
	
	public Personnage(String nom, int pointsDeVie, int pointsAction, Armure armure, Arme arme, List<Butin> butins, String type) {
		super();
		this.setNom(nom);
		this.setPointsDeVie(pointsDeVie);
		this.setPointsAction(pointsAction);
		this.setArmure(armure);
		this.setArme(arme);
		this.butins = butins;
		this.type = type;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if ( nom.isEmpty() )
			this.nom = NOMPARDEFAUT;
		else
			this.nom = nom;
	}

	/**
	 * @return the pointsDeVie
	 */
	public int getPointsDeVie() {
		return pointsDeVie;
	}
	/**
	 * @param pointsDeVie the pointsDeVie to set
	 */
	public void setPointsDeVie(int pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
	}
	
	/**
	 * @return the pointsAction
	 */
	public int getPointsAction() {
		return pointsAction;
	}
	/**
	 * @param pointsAction the pointsAction to set
	 */
	public void setPointsAction(int pointsAction) {
		if (pointsAction<0) {
			this.pointsAction=0;
		}
		else {
			this.pointsAction = pointsAction;
		}
	}
	
	/**
	 * @return the armure
	 */
	public Armure getArmure() {
		return armure;
	}
	/**
	 * @param armure the armure to set
	 */
	public void setArmure(Armure armure) {
		this.armure = armure;
	}
	
	/**
	 * @return the arme
	 */
	public Arme getArme() {
		return arme;
	}
	/**
	 * @param arme the arme to set
	 */
	public void setArme(Arme arme) {
		this.arme = arme;
	}
	
	/**
	 * @return the butins
	 */
	protected List<Butin> getButins() {
		return butins;
	}
	/**
	 * @param butins the butins to set
	 */
	protected void setButins(List<Butin> butins) {
		this.butins = butins;
	}
	
	@Override
	public void equiper() {
		if ( this.hasPA() ) {
			this.setPointsAction(this.getPointsAction()-1);
			System.out.println( String.format(MSGESTEQUIPE, this.getType(), this.getArme().getNom()) );
		}
		else {
			System.out.println( String.format(MSGNESTPASEQUIPE, this.getType()) );
			return;
		}
	}

	@Override
	public boolean hasButin() {
		return ! butins.isEmpty();
	}
	
	@Override
	public boolean hasPDV() {
		return this.getPointsDeVie() > 0;
	}
	
	@Override
	public boolean hasPA() {
		return this.getPointsAction() > 0;
	}
	
	public boolean hasPA(int pointAction) {
		return this.getPointsAction() >= pointAction;
	}
	
	@Override
	public String getType() {
		return this.type;
	}
	
	protected void  setType(String type) {
		this.type=type;
	}
	
	@Override
	public String toString() {
		StringBuilder txt = new StringBuilder();
		txt.append("Le combattant est un ").append(this.getType()).append(".\n");
		txt.append("Il est équipé d’une arme de type ").append(this.getArme().getNom());
		txt.append(" avec ").append(this.getArme().getValeurAttaque()); 
		txt.append(" points d’attaque,\net d’une armure ").append(this.getArmure().getNom());
		txt.append(" avec ").append(this.getArmure().getValeurDefense());
		txt.append(" points de défense.\nIl lui reste ").append(this.getPointsDeVie()).append(" points de vie et ");
		txt.append(this.getPointsAction()).append(" points d'action.");
		return txt.toString();
	}

}
