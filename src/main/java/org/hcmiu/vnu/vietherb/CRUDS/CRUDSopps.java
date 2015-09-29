package org.hcmiu.vnu.vietherb.CRUDS;

import java.util.List;

import org.hcmiu.vnu.vietherb.model.Herb;
import org.hcmiu.vnu.vietherb.services.HerbServices;

public class CRUDSopps {
	
	private static HerbServices herbService= new HerbServices();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Herb herb = new Herb();
		herb.setScientificName("alo3");
		VietHerbDatabaseClass.insertHerbToDB(herb);
		
		herbService.refreshDB();
		
		System.out.println(VietHerbDatabaseClass.getHerbLastID());
		
		listAllherbs();
		
	}

	private static void listAllherbs() {
		// TODO Auto-generated method stub
		List<Herb> herbList = herbService.getAllHerbs();
		for (Herb herb : herbList) {
			System.out.println(herb.getId()+" name: "+herb.getScientificName());
		}
		
	}

}
