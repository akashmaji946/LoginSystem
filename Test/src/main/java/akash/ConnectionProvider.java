package akash;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionProvider {
	static Connection con = null;
	
	private ConnectionProvider() {
		
	}
	
	public static Connection getConnectionFromMySQL() {
		try {
			// if already there no need to reconnect
			if(con == null) {
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "akash");
				
			}else {
				return con;
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	

}
