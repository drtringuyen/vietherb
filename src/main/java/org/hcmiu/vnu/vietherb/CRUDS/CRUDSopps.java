package org.hcmiu.vnu.vietherb.CRUDS;

import java.util.List;

import org.hcmiu.vnu.vietherb.model.Herb;
import org.hcmiu.vnu.vietherb.model.SingleTerm;
import org.hcmiu.vnu.vietherb.services.HerbServices;

public class CRUDSopps {
	
	private static HerbServices herbService= new HerbServices();
	
	public static void main(String[] args) {
		
		for (int i = 1; i < 10; i++) {
			
			Herb herb = new Herb("alo"+i);
			
			SingleTerm herbNameViet = new SingleTerm("thuoc duoc"+i,false);
			SingleTerm herbNameEnglish = new SingleTerm("daisy"+i,true);
			
			herb.getTrivalNames().add(herbNameEnglish);
			herb.getTrivalNames().add(herbNameViet);
			
			VietHerbDatabaseClass.insertHerbToDB(herb);
		}
		
		
		herbService.refreshDB();
		
		System.out.println(VietHerbDatabaseClass.getHerbLastID());
		
		listAllherbs();
		
	}

	private static void listAllherbs() {
		List<Herb> herbList = herbService.getAllHerbs();
		for (Herb herb : herbList) {
			System.out.println(herb.getId()+" name: "+herb.getScientificName());
		}
		
	}

}
