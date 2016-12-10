package DBAccessClasses;

import java.sql.*;
public class DBConnection {


	public static void main(String[]args){ 
		Connection conn; 
		


		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book?autoReconnect=true&useSSL=false", "root", "ganam");

		}catch(Exception e){
			e.printStackTrace();
		}

			System.out.print("connected");
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

	public  boolean checkLogin(String uname,String pwd) {
		PreparedStatement pst = null;
	    ResultSet rs;
	    
		try 
		{
			pst.setString(1, uname); //this replaces the 1st  "?" in the query for username
			pst.setString(2, pwd);    //this replaces the 2st  "?" in the query for password
			//executes the prepared statement
			rs=pst.executeQuery();
			if(rs.next())
			{
				//TRUE iff the query founds any corresponding data
				return true;
			}
			else
			{
				return false;
			}
		} 
		
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("error while validating"+e);
			return false;
		}
	}
}