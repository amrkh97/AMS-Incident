package BLL;

import DAL.IncidentDAL;
import Models.Incident.*;

public class IncidentManager {
	public static InsertIncidentResponse addIncident(InsertIncident Incident) {
		return IncidentDAL.addIncident(Incident);
	}

}
