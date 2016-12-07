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
}