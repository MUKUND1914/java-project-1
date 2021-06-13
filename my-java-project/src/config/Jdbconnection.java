package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbconnection {

	public static Connection getDBconnection() throws ClassNotFoundException,SQLException
	{
		Class.forName("org.h2.Driver");
		Connection con =DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		
		return con;
	}
	
	
}
