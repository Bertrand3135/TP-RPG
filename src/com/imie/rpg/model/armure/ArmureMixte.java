/**
 * 
 */
package com.imie.rpg.model.armure;

/**
 * @author florian
 *
 */
public class ArmureMixte extends Armure {
	
	private ArmureMagique armureMagique;
	private ArmurePhysique armurePhysique;
	
	public ArmureMixte() {
		super();
		
		this.setArmureMagique(new ArmureMagique());
		this.setArmurePhysique(new ArmurePhysique());		
		this.getArmureMagique().setValeurDefense(this.getArmureMagique().getValeurDefense() / 2);
		this.getArmurePhysique().setValeurDefense(this.getArmurePhysique().getValeurDefense() / 2);
		
		super.setValeurDefense(this.getArmureMagique().getValeurDefense() + this.getArmurePhysique().getValeurDefense());
		
	}
	
	public ArmureMixte(String nom) {
		this();		
		super.setNom(nom);
	}
	
	public ArmureMixte(int valeurDefenseMagique, int valeurDefensePhysique) {
		super();
		
		this.setArmureMagique(new ArmureMagique(valeurDefenseMagique));
		this.setArmurePhysique(new ArmurePhysique(valeurDefensePhysique));
		
		super.setValeurDefense(this.getArmureMagique().getValeurDefense() + this.getArmurePhysique().getValeurDefense());
	}
	
	public ArmureMixte(String nom, int valeurDefenseMagique, int valeurDefensePhysique) {
		this(valeurDefenseMagique, valeurDefensePhysique);
		super.setNom(nom);
	}

	public ArmureMagique getArmureMagique() {
		return armureMagique;
	}
	public void setArmureMagique(ArmureMagique armureMagique) {
		this.armureMagique = armureMagique;
	}

	public ArmurePhysique getArmurePhysique() {
		return armurePhysique;
	}
	public void setArmurePhysique(ArmurePhysique armurePhysique) {
		this.armurePhysique = armurePhysique;
	}

}
