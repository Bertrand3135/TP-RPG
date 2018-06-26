/**
 * 
 */
package com.imie.rpg.controler;

import java.util.List;

import com.imie.rpg.model.Butin;
import com.imie.rpg.model.arme.Arme;
import com.imie.rpg.model.armure.Armure;

/**
 * @author florian
 *
 */
public interface IPersonnage {

	public boolean hasButin();
	
	public void equiper();
	
	public void equiper(List<Butin> butins);
}
