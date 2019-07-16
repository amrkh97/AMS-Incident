package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.IncidentDAL;
import Models.Callers.AddCallerModel;
import Models.Callers.CallersArray;
import Models.Callers.ServerResponse;
import Models.Data.DataModel;
import Models.Incident.*;
import Models.IncidentType.IncidentType;
import DAL.IncidentTypeRepDAL;
import DB.DBManager;

public class IncidentManager {
	public static InsertIncidentResponse addIncident(InsertIncident Incident) {
		return IncidentDAL.addIncident(Incident);
	}

	public static int deleteIncident(IncidentType Incident) {
		return IncidentTypeRepDAL.deleteIncidentType(Incident.getTypeName());
	}

	public static CallersArray getCallers(DataModel incident) {

		return IncidentDAL.getCallers(incident.getSentID());
	}

	public static ServerResponse addCaller(AddCallerModel caller) {
		Connection connection = DBManager.getDBConn();
		try {
			return IncidentDAL.AddCallerInformation(caller.getiSQN(), caller.getfName(), caller.getlName(),
					caller.getMobileNumber(), connection);

		} finally {
			try {
				connection.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
