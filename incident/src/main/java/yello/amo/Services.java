package yello.amo;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import BLL.*;
import Models.Incident.*;

/**
 * Root resource (exposed at "api" path)
 */
@Path("api")
public class Services {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Server is Running ..!";
	}

	@Path("addIncident")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response InsertIncident(InsertIncident Incident) {
		if (!(Incident.getIncidentLocationID() <= 0)) {
			if (!(Incident.getIncidentPriority() <= 0)) {
				if (!(Incident.getIncidentType() <= 0)) {
					return Response.ok(IncidentManager.addIncident(Incident)).build();
				} else {
					return Response.ok(" No Type ID Provided ").build();
				}
			} else {
				return Response.ok(" No Priority ID Provided ").build();
			}
		} else {
			return Response.ok(" No Location ID Provided ").build();
		}

	}

}
