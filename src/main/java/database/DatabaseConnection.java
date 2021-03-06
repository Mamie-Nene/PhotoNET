package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection 
{
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/photonet";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "";
	
	public static Connection getConnection() 
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DATABASE_URL,DATABASE_USER,DATABASE_PASSWORD);
		} 
		catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
