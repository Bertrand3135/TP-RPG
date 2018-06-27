/**
 * 
 */
package com.imie.rpg.model.personnage.hero;

import java.util.List;

import com.imie.rpg.model.Butin;

/**
 * @author florian
 *
 */
public interface IHero{
	
	public void ramasserButin(List<Butin> butins);
	
	public void equiperButin();

}
