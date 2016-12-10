package DBAccessClasses;
/**
 * these are import statements that may be needed and are subject to change
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
import java.util.*;
//import com.mysql.jdbc.PreparedStatement;
/**
 * this class will handle the interaction between the program and the transaction table
 * this includes all transaction related actions and methods to fill the table
 * it will most likely be accessed by the Main Classes when an order is completed to create a record
 * @author gchar158
 *
 */

public class TransactionDBAccess {
	
	private static Connection conn;
	
	public static void main(String[] args){
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book?autoReconnect=true&useSSL=false", "root", "ganam");
			PreparedStatement stmt=conn.prepareStatement("insert into Emp values(?,?)");  
			stmt.setInt(1,101);//1 specifies the first parameter in the query  
			stmt.setString(2,"Ratan");  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			  
			conn.close(); 
		}
			catch(Exception e)
		{ 
			System.out.println(e);
		}
		
		
		
	}
			
			
		}
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
	
	/*int transactionNum;
	{
		Object transaction= new Object();//Each transaction contains a transaction#, transaction date, book title, total etc. 
										//A new transaction object will be created once a person makes a purchase.
		
	}
	public int TransactionNum(){ //creates a new transaction number every time an order is placed. Transaction number is autoincremented.
		
		
		return 0;
		
		
		
	}
	public String getTransaction(){//this method will retrieve the appropriate transaction information and will displayed to the user when they make a purchase.
		conn.getConnection();
		PreparedStatement stmt= conn.prepareStatement("Select Transaction#, SellerName, BuyerName, BuyerAddress, "
				+ "TransactionDate,BookTitle, Author_Firstname,Author_Lastname,ISBN,Total");
		ResultSet rs= stmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
	
		
	}*/

