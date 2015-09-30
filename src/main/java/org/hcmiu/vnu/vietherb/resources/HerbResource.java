package org.hcmiu.vnu.vietherb.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hcmiu.vnu.vietherb.model.Herb;
import org.hcmiu.vnu.vietherb.services.HerbServices;

@Path("herbs")
public class HerbResource {
		public HerbServices herbServices = new HerbServices();
		
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Herb> getAllHerb() {
	        return herbServices.getAllHerbs();
	    }
}
