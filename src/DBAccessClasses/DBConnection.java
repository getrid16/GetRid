package DBAccessClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 * this class is the one that grants database access to the entire program. Can be removed/changed if needed.
 * @author gchar158
 *
 */
public class DBConnection {
private static Connection conn=null;
private static String dbString= "jdbc:mysql://localhost:3306/";//missing database name
private static String username= "   ";
private static String password= "    ";

public static void initialize() throws ClassNotFoundException{
	Class.forName("com.mysql.jdbc.Driver");
}
public static Connection getMyConnection()throws SQLException{
	if(conn==null)
		conn=DriverManager.getConnection(dbString, username, password);
	return conn;
}

public static void close(){
	if(conn !=null)
		try{
			conn.close();
		}catch (SQLException ex){
			ex.printStackTrace();
		}
}
}
