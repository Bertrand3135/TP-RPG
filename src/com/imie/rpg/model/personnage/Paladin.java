/**
 * 
 */
package com.imie.rpg.model.personnage;

import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.arme.ArmeMixte;
import com.imie.rpg.model.arme.ArmeMagique;
import com.imie.rpg.model.armure.Armure;
import com.imie.rpg.model.armure.ArmureMagique;
import com.imie.rpg.model.armure.ArmureMixte;
import com.imie.rpg.model.armure.ArmurePhysique;

/**
 * @author florian
 *
 */
public abstract class Paladin extends Personnage {
	
	private static final int POINTSDEVIE	= 120;
	private static final int POINTSACTION	= 10;
	
	private static final String ERRORARME	= "Merci de choisir soit une arme mixte ou magique";
	private static final String ERRORARMURE = "Merci de choisir soit une armure mixte ou magique";
	
	public Paladin () {
		super("", POINTSDEVIE, POINTSACTION, new ArmureMagique(), new ArmeMixte());
	}
	
	public Paladin(String nom, int pointsDeVie, int pointsAction, Arme arme, Armure armure) {
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
		
		if ( arme instanceof ArmeMagique || arme instanceof ArmeMixte ){
			result = true;
		} else {
			System.out.println(ERRORARME);
		}
		
		return result;
	}
	
	@Override
	public boolean isArmureEquipable(Armure armure) {
		boolean result = false;
		
		if ( armure instanceof ArmureMagique || armure instanceof ArmureMixte ){
			result = true;
		} else {
			System.out.println(ERRORARMURE);
		}
		
		return result;
	}

}
