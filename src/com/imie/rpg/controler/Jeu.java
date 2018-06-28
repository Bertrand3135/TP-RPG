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
	//Defaults
	private static final int NBEQUIPEUN		= 7;
	private static final int NBEQUIPEDEUX	= 7;
	
	private static final int NBTYPEEQUIPE	= 2;
	private static final int NBTYPEHEROS	= 2;
	private static final int NBTYPEMOBS		= 2;
	
	private static final String MSGANONCECBTEQPUN	= "L’équipe 1 attaque.";
	private static final String MSGANONCECBTEQPDEUX	= "L’équipe 2 attaque.";
	private static final String MSGATAPE			= "Le %s a tapé avec son arme %s en utilisant %d points d’action. Il lui en reste %d.";
	private static final String MSGAETETAPE			= "Le %s a encore %d points de vie après avoir subi l’attaque.";
	private static final String MSGPRISEBUTIN		= "Le %s a récupéré le butin de %s.";
	
	private static Random rand = new Random();
	
	private List<Personnage> equipeUn;
	private List<Personnage> equipeDeux;
	
	public Jeu() {}
	
	public void nouvellePartie() {
		this.nouvellePartie(NBEQUIPEUN, NBEQUIPEDEUX);
	}
	
	public void nouvellePartie(int nbEqpUn, int nbEqpDeux) {
		equipeUn	= constituerEquipe(nbEqpUn);
		equipeDeux	= constituerEquipe(nbEqpDeux);
	}
	
	public void lancerPartie() {		
		Personnage attaquant = selectionCombattant(equipeUn);
		Personnage adversaire = selectionCombattant(equipeDeux);
		
		while( attaquant != null && adversaire != null ) {
			System.out.println(MSGANONCECBTEQPUN);
			attaquant.resetPACombat();
			attaquant.equiper();
			attaque(attaquant, adversaire);
			
			if ( adversaire.hasPDV() ) {
				System.out.println(MSGANONCECBTEQPDEUX);
				adversaire.resetPACombat();
				adversaire.equiper();
				attaque(adversaire, attaquant);
			}
			
			attaquant = selectionCombattantSuivant(equipeUn, attaquant);
			adversaire = selectionCombattantSuivant(equipeDeux, adversaire);
		}
		
	}
	
	public void afficherVainqueur() {		
		StringBuilder txt = new StringBuilder();
		
		if ( hasCombattants(equipeUn) || hasCombattants(equipeDeux) ) {
			//Dernier restant en vie
			Personnage vainqueur = null;
			int equipe = 0;
			if ( hasCombattants(equipeUn) ) {
				vainqueur = selectionCombattant(equipeUn);
				equipe = 1;
				System.out.println("e1");
			}
			else {
				vainqueur = selectionCombattant(equipeDeux);
				equipe = 2;
				System.out.println("e2");
			}
			
			txt.append("\n");
			txt.append("################################## End Game ##################################\n");
			txt.append(" Le dernier survivant et grand vainqueur est le ");
			txt.append(vainqueur.getType());
			txt.append(" de l’équipe n°").append(equipe).append(" !\n");
			txt.append("##############################################################################\n\n");
			
			txt.append("Il est équipé d’une arme avec ").append(vainqueur.getArme().getValeurAttaque());
			txt.append(" points d’attaque, et d’une armure avec ").append(vainqueur.getArmure().getValeurDefense());
			txt.append(" points de défense. Il lui reste ");
			txt.append(vainqueur.getPointsDeVie()).append(" points de vie.");
			
			System.out.println(txt.toString());
		}
		else {
			
			txt.append("\n");
			txt.append("################################## End Game ##################################\n");
			txt.append(" Il n’y a aucun vainqueur :-s ");
			txt.append("##############################################################################\n\n");
			
			System.out.println(txt.toString());;
		}
	}
	
	private Personnage selectionCombattant(List<Personnage> equipe) {
		return selectionCombattantSuivant(equipe, null);
	}
	
	private Personnage selectionCombattantSuivant(List<Personnage> equipe, Personnage personnageCourant) {
		Personnage combattant = null;
		
		if ( equipe.size() > 1 ) {
			int idPersoCourant = equipe.indexOf(personnageCourant);
			
			for (int i = idPersoCourant+1; i <= equipe.size() && i != idPersoCourant; i++) {
				if ( i == equipe.size() )
					i = 0;
	
					if ( equipe.get(i).hasPDV() ) {
						combattant = equipe.get(i);
						break;
					}
				
			}
		}
		
		return combattant;
	}
	
	private boolean hasCombattants(List<Personnage> equipe) {
		boolean result = false;
		
		for (Personnage perso : equipe) {
			if ( perso.hasPDV() ) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	private void attaque(Personnage attaquant, Personnage adversaire) {	
		while ( attaquant.hasPA( attaquant.getArme().getPointsAction() )
				&& adversaire.hasPDV() )
		{
			taper(attaquant, adversaire, attaquant.getArme());
			System.out.println( String.format(
										MSGATAPE,
										attaquant.getType(),
										attaquant.getArme().getNom(),
										attaquant.getArme().getPointsAction(),
										attaquant.getPointsActionCombat()
										)
								);
			System.out.println( String.format(MSGAETETAPE, adversaire.getType(), adversaire.getPointsDeVie()) );
			
			if ( attaquant instanceof Barbare
					&& attaquant.getPointsActionCombat() >= ((Barbare) attaquant).getArme2().getPointsAction()
					&& adversaire.hasPDV() )
			{
				taper(attaquant, adversaire, ((Barbare) attaquant).getArme2());
				System.out.println( String.format(
						MSGATAPE,
						attaquant.getType(),
						((Barbare) attaquant).getArme2().getNom(),
						((Barbare) attaquant).getArme2().getPointsAction(),
						attaquant.getPointsActionCombat()
						)
					);
			}
		}		

		if ( ! adversaire.hasPDV() ) {
			if ( adversaire instanceof IMob && attaquant instanceof IHero && attaquant.hasPDV() ) {
				((IHero) attaquant).ramasserButin(((IMob) adversaire).lacherButin());
				System.out.println( String.format(MSGPRISEBUTIN, attaquant.getType(), adversaire.getType()) );
			}
			
			if ( equipeUn.contains(adversaire) )
				equipeUn.remove(adversaire);
			else
				equipeDeux.remove(adversaire);
		}
	}
	
	private void taper (Personnage attaquant, Personnage adversaire, Arme arme) {
		adversaire.setPointsDeVie( adversaire.getPointsDeVie()
				- calculerDegats(attaquant.getArme(), adversaire.getArmure()) );
		
		attaquant.setPointsActionCombat( attaquant.getPointsActionCombat() - arme.getPointsAction() );
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
	
	private List<Personnage> constituerEquipe(int nbMembres) {
		List<Personnage> equipe = new ArrayList<Personnage>();
		
		for ( int i = nbMembres; i > 0; i--) {
			switch ( rand.nextInt(NBTYPEEQUIPE) % NBTYPEEQUIPE ) {
				case 0:
					switch( rand.nextInt(NBTYPEHEROS) % NBTYPEHEROS ) {
						case 0:
							equipe.add(new MagicienHero());
						break;
						case 1:
							equipe.add(new PaladinHero());
						break;
					}
				break;
				case 1:
					switch( rand.nextInt(NBTYPEMOBS) % NBTYPEMOBS ) {
						case 0:
							equipe.add(new MagicienMob());
						break;
						case 1:
							equipe.add(new BarbareMob());
						break;
					}
				break;
			}
		}
		
		return equipe;
	}

}
