package com.magneto.detector;

import com.magneto.detector.modelo.Humano;
import com.magneto.detector.repository.HumanoRepository;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("myresource")
public class MyResource {

	HumanoRepository humanoRepository= new HumanoRepository();
   
    @POST
    @Path("isMutant")
    @Produces(MediaType.TEXT_PLAIN)
    public Response isMutant(Humano humano) throws Exception {
    	try {
    		boolean response = humanoRepository.IsMutant(humano, true,true);
    		return Response.ok(response, MediaType.APPLICATION_JSON).build();
    	}
    	catch(Exception e) {
    		return Response.status(Response.Status.FORBIDDEN).entity("Error: " + e.getMessage()).build();
    	}
        
    }
}
