/**
 * 
 */
package com.imie.rpg.model.personnage.hero;

import java.util.List;

import com.imie.rpg.controler.IPersonnage;
import com.imie.rpg.model.Butin;

/**
 * @author florian
 *
 */
public interface IHero extends IPersonnage {
	
	public void ramasserButin(List<Butin> butins);

}
