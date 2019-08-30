package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.CategoriesDAL;
import DB.DBManager;
import Models.Categories.DepartmentsArray;
import Models.Categories.GetByDepIDModel;
import Models.Categories.TypesArray;

public class CategoriesManager {

	public static DepartmentsArray getMainDepartments() {
		
		Connection intermediateConnection = DBManager.getDBConn();
		DepartmentsArray departmentsArray = new DepartmentsArray();
		try {
			departmentsArray = CategoriesDAL.getMainDepartments(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return departmentsArray;
	}

	public static TypesArray getCategoriesByDepID(GetByDepIDModel model) {
		
		Connection intermediateConnection = DBManager.getDBConn();
		TypesArray departmentsArray = new TypesArray();
		try {
			departmentsArray = CategoriesDAL.getCategoriesByDepID(model.getDep_ID(),intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return departmentsArray;
	}

}
