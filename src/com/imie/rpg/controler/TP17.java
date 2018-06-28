/**
 * 
 */
package com.imie.rpg.controler;

import java.sql.SQLException;
import java.util.Random;

import com.imie.rpg.database.DBManager;
import com.imie.rpg.database.DBOpenHelper;

/**
 * @author florian
 *
 */
public class TP17 {
	
	private static Random rand = new Random();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testBDD();		
		
		playJeu();
	}

	@SuppressWarnings("unused")
	private static void testBDD() {
		DBOpenHelper.getInstance();
		
		DBManager bddManager = new DBManager();
		
		StringBuilder resultats = new StringBuilder();

//		bddManager.update("DELETE FROM users");
//		bddManager.update("DELETE FROM roles");
		
		try {
			if ( ! bddManager.select("SELECT name FROM roles WHERE name='administrator'").next() ) {
				bddManager.update("INSERT INTO roles (id, name) VALUES (1, 'administrator')");
			}
			if ( ! bddManager.select("SELECT name FROM roles WHERE name='user'").next() ) {
				bddManager.update("INSERT INTO roles (id, name) VALUES (2, 'user')");
			}
			if ( ! bddManager.select("SELECT name FROM roles WHERE name='moderator'").next() ) {
				bddManager.update("INSERT INTO roles (id, name) VALUES(3, 'moderator')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		StringBuilder users = new StringBuilder();
		for ( int user = 1; user <=20; user++ ) {
			users.append("('").append(user).append("'), ");
		}
		String listUsers = users.substring(0, users.length()-2);		
		bddManager.update("INSERT INTO users (name) VALUES " + listUsers);
		
		for ( int user = 1; user <= 20; user++) {
			switch(rand.nextInt(3)+1) {
				case 1:
					bddManager.update("UPDATE users SET id_role=1 WHERE name=" + user);
					break;
				case 2:
					bddManager.update("UPDATE users SET id_role=2 WHERE name=" + user);
					break;
				case 3:
					bddManager.update("UPDATE users SET id_role=3 WHERE name=" + user);
					break;
			}
		}
		
		resultats.append( bddManager.select("SELECT name FROM roles") );
		resultats.append("\n\n");
		resultats.append( bddManager.select("SELECT name FROM users") );
		resultats.append("\n\n");
		resultats.append( bddManager.select("SELECT users.name, roles.name FROM users JOIN roles ON users.id_role=roles.id") );
		resultats.append("\n\n");
		
		System.out.println(resultats);
	}

	private static void playJeu() {
		Jeu jeuUn = new Jeu();
		
		jeuUn.nouvellePartie();
		jeuUn.lancerPartie();
		jeuUn.afficherVainqueur();
	}
}
