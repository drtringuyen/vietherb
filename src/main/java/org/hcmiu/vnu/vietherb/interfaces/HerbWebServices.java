package org.hcmiu.vnu.vietherb.interfaces;

import org.hcmiu.vnu.vietherb.model.Herb;
import org.hibernate.mapping.List;


public interface HerbWebServices {
	
	public List getAllHerbs();
	public Herb getHerb(long id);
	public void insertHerb(Herb herb);
	public void updateHerb(long id);
	public void deleteHerb(long id);

}
