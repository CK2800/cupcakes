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
 * DBConnection facilitates an easy-to-configure access to a database.
 */
public class DBConnection {
    
        /**
         * Class of the database driver.
         */
	public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
        /**
         * URL of the database.
         */
	public final static String DB_URL = "jdbc:mysql://142.93.174.238:3306/cupcakes";
        /**
         * Username for the database.
         */
	public final static String DB_USERNAME = "cupcakeUser";
        /**
         * Password for the database.
         */
	public final static String DB_PASSWORD = "Cupcake@2018";

        /**
         * Returns a connection for the configured database.
         * @return Connection object.
         * @throws ClassNotFoundException Thrown if the database driver class is not found.
         * @throws SQLException Thrown if the DriverManager can not establish a connection to the database.
         */
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
