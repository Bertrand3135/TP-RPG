package com.imie.rpg.controler;

import java.util.List;

import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.armure.Armure;
import com.imie.rpg.model.personnage.Barbare;
import com.imie.rpg.model.personnage.Personnage;
import com.imie.rpg.model.personnage.hero.IHero;
import com.imie.rpg.model.personnage.mob.IMob;

public class Jeu {
	
	private static final int NBHEROS	= 7;
	private static final int NBMOBS		= 5;
	
	private List<IPersonnage> personnages;
	private List<Arme> armes;
	private List<Armure> armures;
	
	public Jeu() {}
	
	public void nouvellePartie() {
		this.nouvellePartie(NBHEROS, NBMOBS);
	}
	public void nouvellePartie(int nbHeros, int nbMobs) {
		
	}
	
	public void lancerPartie() {
		
	}
	
	public void combat(IHero attaquant, IMob adversaire) {		
		if ( ((Personnage) attaquant).getPointsAction() > 0 ) {
			((Personnage) attaquant).equiper();
		}
		else
			return;
		
		while ( ((Personnage) attaquant).getPointsAction() > 0 ) {
			if ( ((Personnage) attaquant).getPointsAction() >= ((Personnage) attaquant).getArme().getPointsAction() ) {
				taper(attaquant, adversaire, ((Personnage) attaquant).getArme());
			}
			
			if ( attaquant instanceof Barbare
					&& ((Personnage) attaquant).getPointsAction() > 0
					&& ((Personnage) attaquant).getPointsAction() >= ((Barbare) attaquant).getArme2().getPointsAction())
			{
				taper(attaquant, adversaire, ((Barbare) attaquant).getArme2());
			}
		}
	}
	
	public boolean hasCombattants() {
		boolean result = false;
		int nbHerosRestants	= 0;
		int nbMobsRestants	= 0;
		
		for (IPersonnage perso : personnages) {
			if ( perso instanceof IHero )
				nbHerosRestants++;
			else if ( perso instanceof IMob )
				nbMobsRestants++;
		}
		
		if ( nbHerosRestants > 0 && nbMobsRestants > 0 )
			result = true;
		
		return result;
	}
	
	public void afficherVainqueur() {
		//Dernier restant en vie
		IPersonnage vainqueur = personnages.get(0);
		
		StringBuilder txt = new StringBuilder();
		
		txt.append("Le dernier survivant et grand vainqueur est un ");
		txt.append("… .\n");
		
		txt.append("Il est équipé d’une arme avec ").append(((Personnage) vainqueur).getArme().getValeurAttaque());
		txt.append(" points d’attaque, et d’une armure avec ").append(((Personnage) vainqueur).getArmure().getValeurDefense());
		txt.append(" points de défense. Il lui reste ");
		txt.append(((Personnage) vainqueur).getPointsDeVie()).append(" points de vie.");
		
		System.out.println(txt.toString());
	}
	
	private void taper (IHero attaquant, IMob adversaire, Arme arme) {
		int degats = arme.getValeurAttaque()
						- ((Personnage) adversaire).getArmure().getValeurDefense();
		if ( degats < 0 )
			degats = 0;
		
		((Personnage) adversaire).setPointsDeVie(
				((Personnage) adversaire).getPointsDeVie()
				- degats
				);
		
		((Personnage) attaquant).setPointsAction(
				((Personnage) attaquant).getPointsAction()
				- arme.getPointsAction()
				);
	}

}
