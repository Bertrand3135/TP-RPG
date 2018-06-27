/**
 * 
 */
package com.imie.rpg.model.personnage.mob;

import java.util.List;

import com.imie.rpg.model.Butin;
import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.armure.Armure;
import com.imie.rpg.model.personnage.Magicien;

/**
 * @author florian
 *
 */
public class MagicienMob extends Magicien implements IMob {
	
	private static final String TYPE = "magicien mob";

	/**
	 * 
	 */
	public MagicienMob() {
		super();
		super.setType("Magicien Mob");
	}
	
	public MagicienMob(int pointsDeVie, int pointsAction, Arme arme, Armure armure, List<Butin> butins) {
		super(pointsDeVie, pointsAction, arme, armure);
		super.setType(TYPE);
	}
	
	public MagicienMob(String nom, int pointsDeVie, int pointsAction, Arme arme, Armure armure, List<Butin> butins) {
		super(nom, pointsDeVie, pointsAction, arme, armure);
		super.setType(TYPE);
	}


	@Override
	public List<Butin> lacherButin() {
		return super.getButins();
	}




}
