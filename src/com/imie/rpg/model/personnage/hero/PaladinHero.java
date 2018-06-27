/**
 * 
 */
package com.imie.rpg.model.personnage.hero;

import java.util.List;

import com.imie.rpg.model.Butin;
import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.personnage.Paladin;

/**
 * @author florian
 *
 */
public class PaladinHero extends Paladin implements IHero {

	/**
	 * 
	 */
	public PaladinHero() {
		super();
		super.setType("Paladin Héro");
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
