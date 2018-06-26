/**
 * 
 */
package com.imie.rpg.model.personnage.mob;

import java.util.List;

import com.imie.rpg.controler.IPersonnage;
import com.imie.rpg.model.Butin;

/**
 * @author florian
 *
 */
public interface IMob extends IPersonnage {
	
	public List<Butin> lacherButin();

}
