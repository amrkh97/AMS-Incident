package yello.amo;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import BLL.*;
import Models.Incident.*;
import Models.Priority.PrioritiesData;
import Models.IncidentType.*;

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
					return Response.ok(IncidentManager.addIncident(Incident)).header("Access-Control-Allow-Origin", "*").build();
				} else {
					return Response.status(401," No Type ID Provided ").header("Access-Control-Allow-Origin", "*").build();
				}
			} else {
				return Response.status(402," No Priority ID Provided ").header("Access-Control-Allow-Origin", "*").build();
			}
		} else {
			return Response.status(403," No Location ID Provided ").header("Access-Control-Allow-Origin", "*").build();
		}

	}
	////////////////////////////////////////////////////////////////////////////////////
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Priorities/addpriority")
	public Response InsertPriority(PrioritiesData Priority) {
		if(Priority.getPrioname().equals(null) ||  Priority.getPrioname().equals("")) {
			return Response.ok(" No Priority Name Provided ").header("Access-Control-Allow-Origin", "*").build();
		} else {
			return Response.ok(PriorityManager.addPriority(Priority)).header("Access-Control-Allow-Origin", "*").build();
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("Priorities/deletepriority")
	public Response DeletePriority(PrioritiesData Priority) {
		if(Priority.getPrioname().equals(null) ||  Priority.getPrioname().equals("")) {
			return Response.ok(" No Priority Name Provided ").header("Access-Control-Allow-Origin", "*").build();
		} else {
			return Response.ok(PriorityManager.deletePriority(Priority)).header("Access-Control-Allow-Origin", "*").build();
		}
	}
	@DELETE
    @Path("Incident/deleteIncident")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
    public Response deleteIncidentType(IncidentType incidentType)
    {
    	return Response.ok(IncidentManager.deleteIncident(incidentType)).header("Access-Control-Allow-Origin", "*").build();
    }

}
