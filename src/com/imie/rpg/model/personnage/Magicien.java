/**
 * 
 */
package com.imie.rpg.model.personnage;

import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.arme.ArmeMagique;
import com.imie.rpg.model.armure.Armure;
import com.imie.rpg.model.armure.ArmureMagique;

/**
 * @author florian
 *
 */
public abstract class Magicien extends Personnage {
	
	private static final int POINTSDEVIE	= 50;
	private static final int POINTSACTION	= 20;
	
	private static final String ERRORARME	= "Merci de choisir une arme magique";
	private static final String ERRORARMURE = "Merci de choisir une armure magique";
	
	public Magicien () {
		super("", POINTSDEVIE, POINTSACTION, new ArmureMagique(), new ArmeMagique());
	}
	
	public Magicien(int pointsDeVie, int pointsAction, Arme arme, Armure armure) {
		super("", pointsDeVie, pointsAction);
		this.setArme(arme);
		this.setArmure(armure);
	}
	
	public Magicien(String nom, int pointsDeVie, int pointsAction, Arme arme, Armure armure) {
		super(nom, pointsDeVie, pointsAction);
		this.setArme(arme);
		this.setArmure(armure);
	}
	
	@Override
	public void setArme(Arme arme) {
		if ( this.isArmeEquipable(arme) )
			super.setArme(arme);
	}
	
	@Override
	public void setArmure(Armure armure) {
		if ( this.isArmureEquipable(armure) )
			super.setArmure(armure);
	}
	
	@Override
	public boolean isArmeEquipable(Arme arme) {
		boolean result = false;
		
		if ( arme instanceof ArmeMagique ){
			result = true;
		} else {
			System.out.println(ERRORARME);
		}
		
		return result;
	}
	
	@Override
	public boolean isArmureEquipable(Armure armure) {
		boolean result = false;
		
		if ( armure instanceof ArmureMagique ){
			result = true;
		} else {
			System.out.println(ERRORARMURE);
		}
		
		return result;
	}
	

}
