package DBAccessClasses;
/**
 * this class grants access to the database via the getConnection method which is called by the other
 * classes in the package.
 */
import java.sql.*;
public class DBConnection {
	private static Connection conn; 

	public static void initial()throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	public static Connection getConnection()throws SQLException{
		if(conn==null)
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
	}
	


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