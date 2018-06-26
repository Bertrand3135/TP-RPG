/**
 * 
 */
package com.imie.rpg.controler;

import com.imie.rpg.model.personnage.mob.BarbareMob;
import com.imie.rpg.model.personnage.mob.IMob;
import com.imie.rpg.model.personnage.Barbare;
import com.imie.rpg.model.personnage.Personnage;
import com.imie.rpg.model.personnage.hero.IHero;

/**
 * @author florian
 *
 */
public class TP17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPersonnage perso = new BarbareMob();
		
		if ( perso instanceof IHero )
			System.out.println("OUIIIIIII");
		else
			System.out.println("MEEEEEEEEEEEERDE !");
	}

}
