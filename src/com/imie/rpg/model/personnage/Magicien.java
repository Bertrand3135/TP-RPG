/**
 * 
 */
package com.imie.rpg.model.personnage;

import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.arme.ArmeMagique;
import com.imie.rpg.model.arme.ArmeMixte;
import com.imie.rpg.model.arme.ArmePhysique;
import com.imie.rpg.model.armure.ArmurePhysique;

/**
 * @author florian
 *
 */
public abstract class Magicien extends Personnage {
	
	private static final int POINTSDEVIE	= 50;
	private static final int POINTSACTION	= 20;
	
	public Magicien () {
		super.setPointsDeVie(POINTSDEVIE);
		super.setPointsAction(POINTSACTION);
		this.setArme(new ArmeMagique());
		super.setArmure(new ArmurePhysique());
		super.setButins(null);
	}
	
	public void setArme(Arme arme) {
		if (arme instanceof ArmeMagique){
			super.setArme(arme);
		} else {
			System.out.println("Merci de choisir une arme  magique");
		}
	}
	

}
