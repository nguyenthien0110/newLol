package Connection;

import java.sql.Connection; 
import java.sql.DriverManager;

public class DBconnection {
	public Connection getConnection() {
			
			String url = "jdbc:mysql://localhost:3306/baitap";
		    String username = "root";
		    String password = "";
		    
		    try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				 System.out.println("ERROR" +e);
			}
			
			return null;
			
		}
	
}
