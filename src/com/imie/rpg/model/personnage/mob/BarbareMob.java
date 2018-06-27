/**
 * 
 */
package com.imie.rpg.model.personnage.mob;

import java.util.List;

import com.imie.rpg.model.Butin;
import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.armure.Armure;
import com.imie.rpg.model.personnage.Barbare;

/**
 * @author florian
 *
 */
public class BarbareMob extends Barbare implements IMob {
	
	private static final String TYPE = "barbare mob";

	/**
	 * 
	 */
	public BarbareMob() {
		super();
		super.setType(TYPE);
	}
	
	public BarbareMob(int pointsDeVie, int pointsAction, Arme arme, Arme arme2, Armure armure) {
		super("", pointsDeVie, pointsAction, arme, arme2, armure);
		super.setType(TYPE);
	}
	
	public BarbareMob(String nom, int pointsDeVie, int pointsAction, Arme arme, Arme arme2, Armure armure) {
		super(nom, pointsDeVie, pointsAction, arme, arme2, armure);
		super.setType(TYPE);
	}


	@Override
	public List<Butin> lacherButin() {
		return super.getButins();
	}


}
