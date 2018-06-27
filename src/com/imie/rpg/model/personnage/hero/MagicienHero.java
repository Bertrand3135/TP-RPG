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
		super(pointsDeVie, pointsAction, arme, armure);
		super.setType(TYPE);
	}
	
	public MagicienHero(String nom, int pointsDeVie, int pointsAction, Arme arme, Armure armure, List<Butin> butins) {
		super(nom, pointsDeVie, pointsAction, arme, armure);
		super.setType(TYPE);
	}


	@Override
	public void ramasserButin(List<Butin> butins) {
		super.getButins().addAll(butins);
	}

	@Override
	public void equiperButin() {
		// TODO Auto-generated method stub
		
	}


}
