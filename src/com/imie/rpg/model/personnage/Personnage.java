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
	
	private int pointsDeVie;
	private int pointsAction;
	private Armure armure;
	private Arme arme;
	private List<Butin> butins;
	private String type;
	
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
	public List<Butin> getButins() {
		return butins;
	}
	/**
	 * @param butins the butins to set
	 */
	public void setButins(List<Butin> butins) {
		this.butins = butins;
	}
	
	public void equiper() {
			this.setPointsAction(this.getPointsAction()-1);
	}
	/* (non-Javadoc)
	 * @see com.imie.rpg.controler.IPersonnage#hasButin()
	 */
	@Override
	public boolean hasButin() {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.imie.rpg.controler.IPersonnage#equiper(com.imie.rpg.model.armure.Armure, com.imie.rpg.model.arme.Arme)
	 */
	
	@Override
	public boolean hasPDV() {
		boolean result = false;
		if (this.getPointsDeVie()>0) {
			result=true;
		}
		return result;
	}
	@Override
	public boolean hasPA() {
		boolean result = false;
		if (this.getPointsAction()>0) {
			result=true;
		}
		return result;
	}
	
	public boolean hasPA(int pointAction) {
		boolean result = false;
		if (this.getPointsAction()>= pointAction) {
			result=true;
		}
		return result;
	}
	
	public String getType() {
		return this.type;
	}
	
	protected void  setType(String type) {
		this.type=type;
	}
	
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
