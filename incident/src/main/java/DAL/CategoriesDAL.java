package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Models.Categories.DepartmentsArray;
import Models.Categories.DepartmentsModel;
import Models.Categories.TypesArray;
import Models.Categories.TypesModel;

public class CategoriesDAL {

	public static DepartmentsArray getMainDepartments(Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_MainDepartments]";
		ResultSet RS;
		DepartmentsArray logArray = new DepartmentsArray();
		ArrayList<DepartmentsModel> requestLogData = new ArrayList<DepartmentsModel>();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			RS = cstmt.executeQuery();
			
			while (RS.next()) {
				DepartmentsModel data = new DepartmentsModel();
				data.setDep_id(RS.getInt("Dep_ID"));
				data.setDep_name(RS.getString("Arab_Dep_Name"));
				data.setDep_name_eng(RS.getString("Eng_Dep_Name"));
				requestLogData.add(data);
			}
			RS.close();
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		logArray.setItems(requestLogData);
		return logArray;
	}

	public static TypesArray getCategoriesByDepID(Integer dep_ID, Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_IncidentTypesByDepID] ?";
		ResultSet RS;
		TypesArray logArray = new TypesArray();
		ArrayList<TypesModel> requestLogData = new ArrayList<TypesModel>();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			cstmt.setInt(1, dep_ID);
			RS = cstmt.executeQuery();
			
			while (RS.next()) {
				TypesModel data = new TypesModel();
				data.setServ_id(RS.getInt(1));
				data.setName(RS.getString(2));
				
				requestLogData.add(data);
			}
			RS.close();
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		logArray.setItems(requestLogData);
		return logArray;
	}

}
