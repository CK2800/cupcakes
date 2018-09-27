/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhc.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Claus
 */
public class DBConnection {
    
	public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://142.93.174.238:3306/Recipes";
	public final static String DB_USERNAME = "recipeUser";
	public final static String DB_PASSWORD = "Recipe@2018";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection con = null;

		// load the Driver Class
		Class.forName(DB_DRIVER_CLASS);

		// create the connection now
		con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

		System.out.println("DB Connection created successfully");
		return con;
	}
   
}
