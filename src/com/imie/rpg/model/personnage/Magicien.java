/**
 * 
 */
package com.imie.rpg.model.personnage;

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
		super.setArme(new ArmePhysique());
		super.setArmure(new ArmurePhysique());
		super.setButins(null);
	}
}
