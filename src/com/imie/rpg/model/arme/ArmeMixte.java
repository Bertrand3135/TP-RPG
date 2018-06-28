/**
 * 
 */
package com.imie.rpg.model.arme;

/**
 * @author florian
 *
 */
public class ArmeMixte extends Arme {
	
	private static final int PAPARDEFAUT	= 6;
	
	private ArmeMagique armeMagique;
	private ArmePhysique armePhysique;
	
	public ArmeMixte() {
		super();
		
		this.setArmeMagique(new ArmeMagique());
		this.setArmePhysique(new ArmePhysique());
		
		this.getArmeMagique().setValeurAttaque(this.getArmeMagique().getValeurAttaque() / 2);
		this.getArmePhysique().setValeurAttaque(this.getArmePhysique().getValeurAttaque() / 2);		

		super.setPointsAction(PAPARDEFAUT);
		super.setValeurAttaque(this.getArmeMagique().getValeurAttaque() + this.getArmePhysique().getValeurAttaque());
	}
	
	public ArmeMixte(String nom) {
		this();		
		super.setNom(nom);
	}
	
	public ArmeMixte(String nom, int pa) {
		this();		
		super.setNom(nom);
		super.setPointsAction(pa);
	}
	
	public ArmeMixte(int attaqueMagique, int attaquePhysique) {
		super();
		
		this.setArmeMagique(new ArmeMagique(attaqueMagique));
		this.setArmePhysique(new ArmePhysique(attaquePhysique));		

		super.setPointsAction(PAPARDEFAUT);
		super.setValeurAttaque(this.getArmeMagique().getValeurAttaque() + this.getArmePhysique().getValeurAttaque());
	}
	
	public ArmeMixte(String nom, int attaqueMagique, int attaquePhysique) {		
		this(attaqueMagique, attaquePhysique);
		super.setNom(nom);
	}
	
	public ArmeMixte(int pa, int attaqueMagique, int attaquePhysique) {		
		this(attaqueMagique, attaquePhysique);
		super.setPointsAction(pa);
	}
	
	public ArmeMixte(String nom, int pa, int attaqueMagique, int attaquePhysique) {
		this(pa, attaqueMagique, attaquePhysique);
		super.setNom(nom);
	}

	public ArmeMagique getArmeMagique() {
		return armeMagique;
	}
	public void setArmeMagique(ArmeMagique armeMagique) {
		this.armeMagique = armeMagique;
	}

	public ArmePhysique getArmePhysique() {
		return armePhysique;
	}
	public void setArmePhysique(ArmePhysique armePhysique) {
		this.armePhysique = armePhysique;
	}

}
