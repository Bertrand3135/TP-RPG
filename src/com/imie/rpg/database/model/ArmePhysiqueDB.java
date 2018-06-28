package com.imie.rpg.database.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imie.rpg.database.DBManager;
import com.imie.rpg.model.arme.ArmePhysique;

public class ArmePhysiqueDB {
	
	private ArmePhysique armePhysique;
	private DBManager manager = new DBManager();
	
	private static final String SELECT		= "SELECT * FROM %s %s";
	private static final String TABLE		= "ArmePhysique";
	private static final String ID			= "id";
	private static final String WHERE_ID	= "WHERE "+ID+"=%d";
	private static final String INSERT		= "INSERT INTO %s VALUES (%d, %d)";

	public ArmePhysique getArmePhysique() {
		return armePhysique;
	}

	public void setArmePhysique(ArmePhysique armePhysique) {
		this.armePhysique = armePhysique;
	}
	
	public ArmePhysique select(int id) {
		ArmePhysique result = new ArmePhysique();
		
		ResultSet rs = manager.select(String.format(SELECT, TABLE, String.format(WHERE_ID, id)));
		try {
			while(rs.next()) {
				result.setPointsAction(rs.getInt("PointsAction"));
				result.setValeurAttaque(rs.getInt("Attaque"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<ArmePhysique> select() {
		List<ArmePhysique> result = new ArrayList<ArmePhysique>();
		
		ResultSet rs = manager.select(String.format(SELECT, TABLE, ""));
		try {
			while(rs.next()) {
				result.add(new ArmePhysique(rs.getInt("PointsAction"), rs.getInt("Attaque")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void insert(ArmePhysique armePhysique) {
		manager.update(String.format(INSERT, TABLE, armePhysique.getValeurAttaque(), armePhysique.getPointsAction()));
	}
	
	public void update(ArmePhysique armePhysique) {
		
	}
	
	public void delete(ArmePhysique armePhysique) {
		
	}
}
