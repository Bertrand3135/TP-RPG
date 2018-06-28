/**
 * 
 */
package com.imie.rpg.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * @author florian
 * @description Connexion à la base de données avec un « design pattern » « DBOpenHelper » 
 * @lien http://thecodersbreakfast.net/index.php?post/2008/02/25/26-de-la-bonne-implementation-du-singleton-en-java
 * @description Synchronisation locale
 */
public class DBOpenHelper {

	/** Instance unique non préinitialisée */
	private static DBOpenHelper INSTANCE = null;
	
	private Connection conn = null;
	
	/** Constructeur privé */
	private DBOpenHelper() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("");
		dataSource.setServerName("127.0.0.1");
		dataSource.setDatabaseName("JavaTP17");
		
		try {
			dataSource.setServerTimezone("UTC");
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Point d'accès pour l'instance unique du DBOpenHelper */
	public static DBOpenHelper getInstance() {	
		if (INSTANCE == null) { 	
			synchronized(DBOpenHelper.class) {
				if (INSTANCE == null) {
					INSTANCE = new DBOpenHelper();
				}
			}
		}
		return INSTANCE;
	}
	
	public Connection getConnection() {
		return this.conn;
	}
}
