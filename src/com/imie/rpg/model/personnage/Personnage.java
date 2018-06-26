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
		this.pointsAction = pointsAction;
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
	public void equiper(Armure armure, Arme arme) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see com.imie.rpg.controler.IPersonnage#equiper(java.util.List)
	 */
	@Override
	public void equiper(List<Butin> butins) {
		// TODO Auto-generated method stub
		
	}
}
