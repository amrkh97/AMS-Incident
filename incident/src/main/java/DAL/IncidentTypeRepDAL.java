package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import Models.IncidentType.*;

public class IncidentTypeRepDAL {
	
	public int addIncidentType(IncidentType incidentType)
	{
		Connection connection = DBManager.getDBConn();
		int incidentTypeId = -1;
		try
		{
			String spAddIncidentType = "USE DemoDatabase; EXEC [dbo].[spIncidentTypes_AddRow] ?,?,?";
			
			CallableStatement cstmt = connection.prepareCall(spAddIncidentType);
			cstmt.setString(1, incidentType.getTypeName());
			cstmt.setString(2, incidentType.getTypeNote());
			cstmt.registerOutParameter(3, Types.INTEGER);
			
		    cstmt.executeUpdate();
		    
		    incidentTypeId = cstmt.getInt(3);
			
		    System.out.println("The incidentType which ID = '" + incidentTypeId + "' and name = '" + incidentType.getTypeName() + "' is added successfully :)");
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}finally 
		{
			try {
				connection.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return incidentTypeId;
		
	}
	
	public static int deleteIncidentType(String incidentTypeName)
	{
		Connection connection = DBManager.getDBConn();
		int DeleteStatus=0;
		
		try
		{
			String spDeleteIncidentType = "USE DemoDatabase; EXEC [dbo].[spIncidentTypes_DeleteByTypeName] ?";
			
			CallableStatement cstmt = connection.prepareCall(spDeleteIncidentType);
			
			cstmt.setString(1, incidentTypeName);
	
		    cstmt.executeUpdate();

			System.out.println("The incidentType which name = '" + incidentTypeName + "' is deleted successfully :)");
			DeleteStatus = 1;
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}finally 
		{
			try {
				connection.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return DeleteStatus;
	}
	
	public List<IncidentType> getAllIncidentTypes()
	{
		List<IncidentType> incidentTypeList = new ArrayList<>();
		
		try
		{
			Connection connection = DBManager.getDBConn();
			Statement statement = connection.createStatement();
			String query = "select * from IncidentTypes";
			
			ResultSet resultSet = statement.executeQuery(query);
	
			while(resultSet.next())
			{
				IncidentType incidentType = new IncidentType();
				incidentType.setTypeName(resultSet.getString("TypeName"));
				incidentType.setTypeNote(resultSet.getString("TypeNote"));
				incidentTypeList.add(incidentType);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return incidentTypeList;
	}


}
