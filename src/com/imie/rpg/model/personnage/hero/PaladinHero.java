/**
 * 
 */
package com.imie.rpg.model.personnage.hero;

import java.util.List;

import com.imie.rpg.model.Butin;
import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.armure.Armure;
import com.imie.rpg.model.personnage.Paladin;

/**
 * @author florian
 *
 */
public class PaladinHero extends Paladin implements IHero {
	
	private static final String TYPE = "paladin héro";

	/**
	 * 
	 */
	public PaladinHero() {
		super();
		super.setType(TYPE);
	}
	
	public PaladinHero(int pointsDeVie, int pointsAction, Arme arme, Armure armure, List<Butin> butins) {
		super("", pointsDeVie, pointsAction, arme, armure);
		super.setType(TYPE);
	}
	
	public PaladinHero(String nom, int pointsDeVie, int pointsAction, Arme arme, Armure armure, List<Butin> butins) {
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
