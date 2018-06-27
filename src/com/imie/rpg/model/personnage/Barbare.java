/**
 * 
 */
package com.imie.rpg.model.personnage;

import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.arme.ArmePhysique;
import com.imie.rpg.model.armure.Armure;
import com.imie.rpg.model.armure.ArmurePhysique;

/**
 * @author florian
 *
 */
public abstract class Barbare extends Personnage {
	
	private static final int POINTSDEVIE	= 80;
	private static final int POINTSACTION	= 15;
	
	private static final String ERRORARME	= "Merci de choisir une arme physique";
	private static final String ERRORARMURE = "Merci de choisir une armure physique";
	
	private Arme arme2;
	
	public Barbare () {
		super("", POINTSDEVIE, POINTSACTION, new ArmurePhysique(), new ArmePhysique());
		this.setArme2(new ArmePhysique());
	}
	
	public Barbare(String nom, int pointsDeVie, int pointsAction, Arme arme, Arme arme2, Armure armure) {
		super(nom, pointsDeVie, pointsAction);
		this.setArme(arme);
		this.setArme2(arme2);
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
	
	public Arme getArme2() {
		return arme2;
	}
	public void setArme2(Arme arme) {
		if ( this.isArmeEquipable(arme) )
			this.arme2 = arme;
	}
	
	@Override
	public boolean isArmeEquipable(Arme arme) {
		boolean result = false;
		
		if ( arme instanceof ArmePhysique ){
			result = true;
		} else {
			System.out.println(ERRORARME);
		}
		
		return result;
	}
	
	@Override
	public boolean isArmureEquipable(Armure armure) {
		boolean result = false;
		
		if ( armure instanceof ArmurePhysique ){
			result = true;
		} else {
			System.out.println(ERRORARMURE);
		}
		
		return result;
	}

}
