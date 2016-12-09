package DBAccessClasses;

import java.sql.DriverManager;
import java.sql.*;
public class DBConnection {
	public static void main(String[]args){ 
Connection conn=null; 


try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book?autoReconnect=true&useSSL=false", "root", "ganam");
	
}catch(Exception e){
	e.printStackTrace();
}
if(conn != null){
	System.out.print("connected");
}
}
	/**
	 * these methods are created so every class can call them and get the database connection. 
	 * if we plan to use a different way like getting the connection in each class that needs it, we can delete these or change them which is why i left the original
	 * code intact and commented this out. i wrote my code in BookDBAccess based on these methods so the class will have errors- Gyo
	 * @return the connection to the database
	 * @throws SQLException
	 *//*
	public static Connection getConnection()throws SQLException{
		if(conn==null)
			Class.forName("com.mysql.jdbc.Driver").newInstance();//may put in it's own method or outside all methods depending on if this works or not
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book?autoReconnect=true&useSSL=false", "root", "ganam");
		return conn;
	}
	
	public static void close(){
		if(conn!=null)
			try{
				conn.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
	}*/
}