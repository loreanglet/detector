package com.magneto.detector;

import com.magneto.detector.modelo.Humano;
import com.magneto.detector.modelo.Stats;
import com.magneto.detector.repository.HumanoRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("magneto")
public class Magneto {

	HumanoRepository humanoRepository= new HumanoRepository();
   
    @POST
    @Path("isMutant")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response isMutant(Humano humano) throws Exception {
    	try {
    		boolean response = humanoRepository.IsMutant(humano, true,true);
    		
    		if(response) {
    			humanoRepository.AddHumanoMutante(humano);
				return Response.ok().build();}
    		else {
    			humanoRepository.AddHumanoComun(humano);
        		return Response.status(Response.Status.FORBIDDEN).build();
    		}    		
    		
    	}
    	catch(Exception e) {
    		return Response.status(Response.Status.BAD_REQUEST).entity("Error: " + e.getMessage()).build();
    	}
        
    }
    
    @GET
    @Path("getStats")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response getStats() {
    	try {
    		Stats response = humanoRepository.GetStats();
    		return Response.ok(response, MediaType.APPLICATION_JSON).build();
    	}
    	catch(Exception e) {
    		return Response.status(Response.Status.BAD_REQUEST).entity("Error: " + e.getMessage()).build();
    	}
        
    }
}
