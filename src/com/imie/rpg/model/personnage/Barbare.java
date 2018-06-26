/**
 * 
 */
package com.imie.rpg.model.personnage;

import java.util.List;

import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.arme.ArmeMagique;
import com.imie.rpg.model.arme.ArmeMixte;
import com.imie.rpg.model.arme.ArmePhysique;
import com.imie.rpg.model.armure.ArmurePhysique;

/**
 * @author florian
 *
 */
public abstract class Barbare extends Personnage {
	
	private static final int POINTSDEVIE	= 80;
	private static final int POINTSACTION	= 15;
	
	private ArmePhysique arme2;
	
	public Barbare () {
		super.setPointsDeVie(POINTSDEVIE);
		super.setPointsAction(POINTSACTION);
		this.setArme(new ArmePhysique());
		this.setArme2(new ArmePhysique());
		super.setArmure(new ArmurePhysique());
		super.setButins(null);
	}
	
	public void setArme(Arme arme) {
		if ((arme instanceof ArmePhysique)){
			super.setArme(arme);
		} else {
			System.out.println("Merci de choisir une arme physique");
		}
	}
	
	public ArmePhysique getArme2() {
		return arme2;
	}
	public void setArme2(ArmePhysique arme) {
			this.arme2 = arme;
	}
	
	

}
