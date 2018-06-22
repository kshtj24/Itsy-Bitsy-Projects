package com.dkm.api;

import java.sql.*;
import org.json.*;

public class DBHelper {

	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static boolean connectDB() {
		try { // This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/dkmtestdb?" + "user=root&password=");
			return true;
		} catch (Exception exception) {
			System.out.println("Exception occured" + exception.getMessage());
			return false;
		}
	}

	public static JSONArray getData() {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("Select * from oc_address");
			System.out.println(resultSet);
			return convertToJSON(resultSet);

		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return null;
		}
	}

	private static JSONArray convertToJSON(ResultSet resultSet) {
		try {
			JSONArray jsonArray = new JSONArray();
			while (resultSet.next()) {
				int total_rows = resultSet.getMetaData().getColumnCount();
				for (int i = 0; i < total_rows; i++) {
					JSONObject obj = new JSONObject();
					obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
					jsonArray.put(obj);
				}
			}

//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("product_list", jsonArray);
			return jsonArray;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return null;
		}

	}
}
