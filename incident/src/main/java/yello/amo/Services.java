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
import Models.Callers.AddCallerModel;
import Models.Callers.ServerResponse;
import Models.Data.DataModel;
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
		return "Incident Services Are Running!";
	}

	@Path("addIncident")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response InsertIncident(InsertIncident Incident) {
		ServerResponse response = new ServerResponse();
		
		if (!(Incident.getIncidentLocationID() <= 0)) {
			if (!(Incident.getIncidentPriority() <= 0)) {
				if (!(Incident.getIncidentType() <= 0)) {
					return Response.ok(IncidentManager.addIncident(Incident)).header("Access-Control-Allow-Origin", "*").build();
				} else {
					response.setResponseHexCode("A01003001001");
					return Response.status(401).entity(response).header("Access-Control-Allow-Origin", "*").build();
				}
			} else {
				response.setResponseHexCode("A01003001001");
				return Response.status(402).entity(response).header("Access-Control-Allow-Origin", "*").build();
			}
		} else {
			response.setResponseHexCode("A01003001001");
			return Response.status(403).entity(response).header("Access-Control-Allow-Origin", "*").build();
		}

	}
	////////////////////////////////////////////////////////////////////////////////////
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Priorities/addpriority")
	public Response InsertPriority(PrioritiesData Priority) {
		ServerResponse response = new ServerResponse();
		if(Priority.getPrioname().equals(null) ||  Priority.getPrioname().equals("")) {
			response.setResponseHexCode("A01003002001");
			return Response.status(401).entity(response).header("Access-Control-Allow-Origin", "*").build();
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
		ServerResponse response = new ServerResponse();
		if(Priority.getPrioname().equals(null) ||  Priority.getPrioname().equals("")) {
			response.setResponseHexCode("A01003003001");
			return Response.status(401).entity(response).header("Access-Control-Allow-Origin", "*").build();
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
	
	
	@Path("incident/getCallers")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCallers(DataModel Incident) {

		return Response.ok(IncidentManager.getCallers(Incident)).build();
	}

	@Path("incident/addCaller")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCaller(AddCallerModel caller) {
		ServerResponse response = new ServerResponse();
		response = IncidentManager.addCaller(caller);

		switch (response.getResponseHexCode()) {
		case "01":
			response.setResponseHexCode("A01003006001");
			return Response.status(401).entity(response).build();
		default:
			return Response.ok(response).build();
		}

	}

}
