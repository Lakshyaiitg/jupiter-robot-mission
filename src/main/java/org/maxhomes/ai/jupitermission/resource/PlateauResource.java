package org.maxhomes.ai.jupitermission.resource;

import org.maxhomes.ai.jupitermission.entities.PlateauImpl;
import org.maxhomes.ai.jupitermission.manager.ServiceManager;
import org.maxhomes.ai.jupitermission.services.PlateauService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/plateau")
public class PlateauResource {
	private final PlateauService plateauService;

	public PlateauResource() {
		this.plateauService = ServiceManager.getInstance().getPlateauService();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public jakarta.ws.rs.core.Response createPlateau(PlateauImpl plateau) {
		try {
			plateauService.createPlateau(plateau.getUpperX(), plateau.getUpperY());
			return jakarta.ws.rs.core.Response.status(Status.OK)
					.entity(new Response(true, "Plateau created successfully", plateau)).build();
		} catch (Exception e) {
			return jakarta.ws.rs.core.Response.status(Status.BAD_REQUEST)
					.entity(new Response(false, e.getMessage(), null)).build();
		}
	}
}
