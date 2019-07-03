package DAL;

import Models.Priority.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DB.DBManager;

public class PrioritiesDAL {
	
	public static List<PrioritiesData> addPriority(PrioritiesData data) {
		List<PrioritiesData> lsit = new ArrayList<>();
		Connection conn = DBManager.getDBConn();

		try {
			System.out.println(data.getPrionote() + data.getPrioname());
			Statement statement =  conn.createStatement();
			String query = "INSERT INTO Priorities ( PriorityName, PriorityNote)VALUES('"+data.getPrioname()+"', '"+data.getPrionote()+"');";
			statement.execute(query);
			
			String select = "select * from Priorities;";
			ResultSet resultSet = statement.executeQuery(select);
			while(resultSet.next())
			{
				PrioritiesData allrecord = new PrioritiesData();
				allrecord.setPrioname(resultSet.getString(2));				
				allrecord.setPrionote(resultSet.getString(3));
                lsit.add(allrecord);
				System.out.println(resultSet.getString(1) + ", " +
						   resultSet.getString(2) + ", " +
						   resultSet.getString(3) + ", "
								   );
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return lsit;	
	}
	////////////////////////////////////////////////////////////////////
	public static boolean deleteField(PrioritiesData priorityName) {
		boolean excuted = false;
			Connection conn = DBManager.getDBConn();
		try {
			Statement statement =  conn.createStatement();
			String query = "DELETE FROM Priorities WHERE PriorityName = '"+priorityName.getPrioname()+"';";
			excuted = statement.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excuted;
	}

}
