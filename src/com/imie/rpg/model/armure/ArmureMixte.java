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
		this.setArmureMagique(new ArmureMagique());
		this.setArmurePhysique(new ArmurePhysique());
		
		this.getArmureMagique().setValeurDefense(this.getArmureMagique().getValeurDefense() / 2);
		this.getArmurePhysique().setValeurDefense(this.getArmurePhysique().getValeurDefense() / 2);
		
	}
	
	public ArmureMixte(String nom) {
		this();
		
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
