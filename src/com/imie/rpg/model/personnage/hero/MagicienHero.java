/**
 * 
 */
package com.imie.rpg.model.personnage.hero;

import java.util.List;

import com.imie.rpg.model.Butin;
import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.armure.Armure;
import com.imie.rpg.model.personnage.Magicien;

/**
 * @author
 *
 */
public class MagicienHero extends Magicien implements IHero {
	
	private static final String TYPE = "magicien héro";

	/**
	 * 
	 */
	public MagicienHero() {
		super();
		super.setType(TYPE);
	}
	
	public MagicienHero(int pointsDeVie, int pointsAction, Arme arme, Armure armure, List<Butin> butins) {
		super.setType(TYPE);
		super.setPointsAction(pointsAction);
		super.setPointsDeVie(pointsDeVie);
		super.setArme(arme);
		super.setArmure(armure);
		super.setButins(butins);
	}

	/* (non-Javadoc)
	 * @see com.imie.rpg.model.personnage.hero.IHero#ramasserButin(java.util.List)
	 */
	@Override
	public void ramasserButin(List<Butin> butins) {
		// TODO Auto-generated method stub

	}

	@Override
	public void equiperButin() {
		// TODO Auto-generated method stub
		
	}


}
