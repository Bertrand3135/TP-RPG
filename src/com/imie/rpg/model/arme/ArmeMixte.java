/**
 * 
 */
package com.imie.rpg.model.arme;

/**
 * @author florian
 *
 */
public class ArmeMixte extends Arme {
	
	private ArmeMagique armeMagique;
	private ArmePhysique armePhysique;
	
	public ArmeMixte() {
		this.setArmeMagique(new ArmeMagique());
		this.setArmePhysique(new ArmePhysique());
		
		this.getArmeMagique().setValeurAttaque(this.getArmeMagique().getValeurAttaque() / 2);
		this.getArmePhysique().setValeurAttaque(this.getArmePhysique().getValeurAttaque() / 2);
	}
	
	public ArmeMixte(String nom) {
		this();
		
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
