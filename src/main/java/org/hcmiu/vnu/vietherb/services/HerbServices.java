package org.hcmiu.vnu.vietherb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hcmiu.vnu.vietherb.CRUDS.VietHerbDatabaseClass;
import org.hcmiu.vnu.vietherb.model.Herb;

public class HerbServices {
	
	private static Map<Long, Herb> herbList = VietHerbDatabaseClass.getAllHerbs();

	public List<Herb> getAllHerbs() {
		return new ArrayList<Herb>(herbList.values());
	}

	public HerbServices(){
		refreshDB();
	}
	
	public Herb getHerb(long id) {
		return herbList.get(id);
	}

	public void insertHerb(Herb herb) {
		
		
	}

	public void updateHerb(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteHerb(long id) {
		// TODO Auto-generated method stub
		
	}

	public void refreshDB() {
		VietHerbDatabaseClass.refreshDB();
		herbList = VietHerbDatabaseClass.getAllHerbs();
	}
	
}
