/**
 * 
 */
package com.imie.rpg.model.personnage.hero;

import java.util.List;

import com.imie.rpg.model.Butin;
import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.personnage.Magicien;

/**
 * @author
 *
 */
public class MagicienHero extends Magicien implements IHero {

	/**
	 * 
	 */
	public MagicienHero() {
		super();
		super.setType("Magicien Héro");
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
