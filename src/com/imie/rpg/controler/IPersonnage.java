/**
 * 
 */
package com.imie.rpg.controler;

import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.armure.Armure;

/**
 * @author florian
 *
 */
public interface IPersonnage {
	
	public void equiper();
	
	public boolean hasPDV();
	
	public boolean hasPA();

	public boolean hasButin();
	
	public String getType();
	
	public boolean isArmeEquipable(Arme arme);
	
	public boolean isArmureEquipable(Armure armure);	

}
