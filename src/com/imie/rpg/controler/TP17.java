/**
 * 
 */
package com.imie.rpg.controler;

import com.imie.rpg.model.personnage.mob.MagicienMob;
import com.imie.rpg.model.personnage.hero.PaladinHero;

/**
 * @author florian
 *
 */
public class TP17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Jeu jeuUn = new Jeu();
		
		MagicienMob vilain = new MagicienMob();
		PaladinHero gentil = new PaladinHero();
		gentil.getArme().setNom(("massue"));
		gentil.getArmure().setNom("magique");
		System.out.println(gentil.toString());
		
		//jeuUn.combat(gentil, vilain);
		
		//System.out.println("Gentil\nPDV : " + gentil.getPointsDeVie());
		//System.out.println("Vilain\nPDV : " + vilain.getPointsDeVie());

	}
	

}
