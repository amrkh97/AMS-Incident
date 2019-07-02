package BLL;

import DAL.IncidentDAL;
import Models.Incident.*;
import Models.IncidentType.IncidentType;
import DAL.IncidentTypeRepDAL;

public class IncidentManager {
	public static InsertIncidentResponse addIncident(InsertIncident Incident) {
		return IncidentDAL.addIncident(Incident);
	}
	public static int deleteIncident(IncidentType Incident) {
		return IncidentTypeRepDAL.deleteIncidentType(Incident.getTypeName());
	}

}
