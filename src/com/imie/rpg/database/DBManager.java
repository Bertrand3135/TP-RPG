/**
 * 
 */
package com.imie.rpg.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author florian
 *
 */
public class DBManager {
	
	public DBManager() {
		
	}
	
	public ResultSet select(String request) {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = DBOpenHelper.getInstance().getConnection().createStatement();
			rs = stmt.executeQuery(request);
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rs;
	}
	

	
	public void update(String request) {		
		Statement stmt = null;
		try {
			stmt = DBOpenHelper.getInstance().getConnection().createStatement();
			stmt.executeUpdate(request);
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
