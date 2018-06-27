package com.imie.rpg.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.arme.ArmeMagique;
import com.imie.rpg.model.arme.ArmeMixte;
import com.imie.rpg.model.arme.ArmePhysique;
import com.imie.rpg.model.armure.Armure;
import com.imie.rpg.model.armure.ArmureMagique;
import com.imie.rpg.model.armure.ArmureMixte;
import com.imie.rpg.model.armure.ArmurePhysique;
import com.imie.rpg.model.personnage.Barbare;
import com.imie.rpg.model.personnage.Personnage;
import com.imie.rpg.model.personnage.hero.IHero;
import com.imie.rpg.model.personnage.hero.MagicienHero;
import com.imie.rpg.model.personnage.hero.PaladinHero;
import com.imie.rpg.model.personnage.mob.BarbareMob;
import com.imie.rpg.model.personnage.mob.IMob;
import com.imie.rpg.model.personnage.mob.MagicienMob;

public class Jeu {
	
	private static final int NBHEROS	= 7;
	private static final int NBMOBS		= 5;
	
	private static final int NBTYPEHEROS	= 2;
	private static final int NBTYPEMOBS		= 2;
	
	private static Random rand = new Random();
	
	private List<IPersonnage> personnages;
	private List<Arme> armes;
	private List<Armure> armures;
	
	public Jeu() {}
	
	public void nouvellePartie() {
		this.nouvellePartie(NBHEROS, NBMOBS);
	}
	public void nouvellePartie(int nbHeros, int nbMobs) {
		while ( nbHeros > 0 || nbMobs > 0 ) {
			if ( nbHeros > 0 ) {
				switch( rand.nextInt(NBTYPEHEROS) % NBTYPEHEROS ) {
					case 0:
						personnages.add(new MagicienHero());
						break;
					case 1:
						personnages.add(new PaladinHero());
						break;
				}
				nbHeros--;
			}
			
			if ( nbMobs > 0 ) {
				switch( rand.nextInt(NBTYPEMOBS) % NBTYPEMOBS ) {
				case 0:
					personnages.add(new MagicienMob());
					break;
				case 1:
					personnages.add(new BarbareMob());
					break;
			}
				nbMobs--;
			}
		}
	}
	
	public void lancerPartie() {
		
		while( hasCombattants() ) {
			List<Personnage> heros	= subListePersonnages(true);
			List<Personnage> mobs	= subListePersonnages(false);
			
			for ( int idHero=0, idMob=0; idHero < heros.size() || idMob < mobs.size(); idHero++, idMob++) {
				Personnage hero, mob;
				
				if ( idHero >= mobs.size() ) {
					hero	= heros.get(idHero);
					mob		= mobs.get( rand.nextInt(mobs.size()) % mobs.size() );
				}				
				else if ( idMob >= heros.size() ) {
					hero	= heros.get( rand.nextInt(heros.size()) % heros.size() );
					mob		= mobs.get(idMob);
				}
				else {
					hero	= heros.get(idHero);
					mob		= mobs.get(idMob);
				}
				
				combat(hero, mob);
				if ( ! mob.hasPDV() ) {
					((IHero) hero).ramasserButin( ((IMob) mob).lacherButin() );
					mobs.remove(mob);
				}
				
				combat(mob, hero);
				if ( ! hero.hasPDV() )
					heros.remove(hero);
			}
		}
		
	}
	
	public void combat(Personnage attaquant, Personnage adversaire) {		
		try {
			attaquant.equiper();
		}
		catch (Exception e) {
			System.out.println(String.format("Le %s n’a pas pu s’équiper.", attaquant.getType()));
			e.printStackTrace();
			return;
		}
		
		while ( attaquant.hasPA( attaquant.getArme().getPointsAction() )
				&& adversaire.hasPDV() )
		{
			taper(attaquant, adversaire, attaquant.getArme());
			
			if ( attaquant instanceof Barbare
					&& attaquant.getPointsAction() >= ((Barbare) attaquant).getArme2().getPointsAction()
					&& adversaire.hasPDV() )
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
	
	private void taper (Personnage attaquant, Personnage adversaire, Arme arme) {
		adversaire.setPointsDeVie( adversaire.getPointsDeVie()
				- calculerDegats(attaquant.getArme(), adversaire.getArmure()) );
		
		attaquant.setPointsAction( attaquant.getPointsAction() - arme.getPointsAction() );
	}
	
	private int calculerDegats(Arme armeAttaquant, Armure armureDefenseur) {
		int degats = 0;

		if ( armeAttaquant instanceof ArmeMixte ) {
			degats = calculerDegats(((ArmeMixte) armeAttaquant).getArmeMagique(), armureDefenseur)
					+ calculerDegats(((ArmeMixte) armeAttaquant).getArmePhysique(), armureDefenseur);
		}		
		else {
			if ( armureDefenseur instanceof ArmureMixte ) {
				degats = calculerDegats(armeAttaquant, ((ArmureMixte) armureDefenseur).getArmureMagique())
						+ calculerDegats(armeAttaquant, ((ArmureMixte) armureDefenseur).getArmurePhysique());
			}
			else if ( armureDefenseur instanceof ArmureMagique ) {
				if ( armeAttaquant instanceof ArmePhysique )
					degats = armeAttaquant.getValeurAttaque();
				else if ( armeAttaquant instanceof ArmeMagique )
					degats = armeAttaquant.getValeurAttaque()
					- armureDefenseur.getValeurDefense();
			}
			else if ( armureDefenseur instanceof ArmurePhysique ) {
				if ( armeAttaquant instanceof ArmePhysique )
					degats = armeAttaquant.getValeurAttaque()
					- armureDefenseur.getValeurDefense();
				else if ( armeAttaquant instanceof ArmeMagique )
					degats = armeAttaquant.getValeurAttaque();
			}
		}
		
		if ( degats < 0)
			degats = 0;
		
		return degats;
	}
	
	private List<Personnage> subListePersonnages (boolean hero) {
		List<Personnage> perso = new ArrayList<Personnage>();
		
		for (IPersonnage personnage : personnages) {
			if ( hero && personnage instanceof IHero && personnage.hasPDV() ) {
				perso.add((Personnage) personnage);
			}
			else if ( ! hero && personnage instanceof IMob && personnage.hasPDV() ) {
				perso.add((Personnage) personnage);
			}
		}
		
		return perso;		
	}

}
