package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.Callers.CallerModel;
import Models.Callers.CallersArray;
import Models.Callers.ServerResponse;
import Models.Incident.*;

public class IncidentDAL {

	public static InsertIncidentResponse addIncident(InsertIncident Incident) {

		String SPsql = "EXEC usp_Incident_Insert ?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		InsertIncidentResponse IncidentData = new InsertIncidentResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, Incident.getIncidentType());
			cstmt.setInt(2, Incident.getIncidentPriority());
			cstmt.setInt(3, Incident.getIncidentLocationID());
			cstmt.registerOutParameter(4, Types.NVARCHAR);
			cstmt.registerOutParameter(5, Types.NVARCHAR);
			cstmt.registerOutParameter(6, Types.INTEGER);
			cstmt.execute();
			IncidentData.setiSN(cstmt.getInt(6));
			IncidentData.setHexReturn(cstmt.getString(4));
			IncidentData.setResponseMsg(cstmt.getString(5));

			if (IncidentData.getHexReturn().equals("00")) {
				AddCallerInformation(IncidentData.getiSN(),Incident.getCallerFName(),Incident.getCallerLName(),Incident.getCallerMobile(),conn);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return IncidentData;
	}

	public static ServerResponse AddCallerInformation(Integer iSQN,String fName,String lName, String mobileNumber,Connection connection) {
		String SPsql = "EXEC usp_Incident_InsertCallData ?,?,?,?,?";
		Connection conn = connection;
		ServerResponse serverData = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, iSQN);
			cstmt.setString(2, fName);
			cstmt.setString(3, lName);
			cstmt.setString(4, mobileNumber);
			cstmt.registerOutParameter(5, Types.NVARCHAR);
			cstmt.executeUpdate();
			serverData.setResponseHexCode(cstmt.getString(5));
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(serverData.getResponseHexCode().equals("00")) {
			serverData.setResponseMsg("Added Succesfully");
		}else {
			serverData.setResponseMsg("Addition Failed, This Number is already registered to this incident.");
		}
		return serverData;	
	}
	
	public static CallersArray getCallers(Integer iSQN) {

		String SPsql = "EXEC usp_Incident_getCallers ?";
		Connection conn = DBManager.getDBConn();
		ResultSet resultSet;
		CallersArray callersArray = new CallersArray();
		ArrayList<CallerModel> arrayList = new ArrayList<CallerModel>();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, iSQN);
			resultSet = cstmt.executeQuery();

			while (resultSet.next()) {

				CallerModel callerModel = new CallerModel();
				callerModel.setCallerName(resultSet.getString(1) + " " + resultSet.getString(2));
				callerModel.setCallerMobile(resultSet.getString(3));
				callerModel.setCallTime(resultSet.getString(4));

				arrayList.add(callerModel);
			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		callersArray.setCallersList(arrayList);
		return callersArray;
	}
	
}
