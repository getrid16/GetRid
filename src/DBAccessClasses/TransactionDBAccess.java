package DBAccessClasses;
/**
 * these are import statements that may be needed and are subject to change
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
//import com.mysql.jdbc.PreparedStatement;
/**
 * this class will handle the interaction between the program and the transaction table
 * this includes all transaction related actions and methods to fill the table
 * it will most likely be accessed by the Main Classes when an order is completed to create a record
 * Additionally there will also be a transaction object that is created once a transaction is made. 
 * A summary of the transaction will be sent to the customer as a receipt once a customer makes a transaction.
 * @author gchar158
 *
 */

public class TransactionDBAccess {
	
	private Connection conn;
	
	
	public void createTransaction(int transactionNum, String Seller_Name, int Seller_Acc_Num, String Buyer_Name, int Buyer_Acc_Num,
			String Buyer_Address, int transactionD, String Book_Title, String Author_Firstname, 
			String Author_Lastname, int ISBN, Double Price, int Credit_Card_Number, Double Percent_Received, 
			Double total, String received, String shipped ) throws SQLException
			
	{
		conn=DBConnection.getConnection();
		PreparedStatement stmt=conn.prepareStatement("");  
		
		//transactionNum=count.incremenetandGet();
		
		String Transaction_Date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(transactionD));

		stmt.setInt(1,transactionNum);  
		stmt.setString(2,Seller_Name); 
		stmt.setInt(3,Seller_Acc_Num);
		stmt.setString(4,Buyer_Name);
		stmt.setInt(5, Buyer_Acc_Num);
		stmt.setString(6, Buyer_Address);
		stmt.setString(7, Transaction_Date);
		stmt.setString(8,Book_Title );
		stmt.setString(9, Author_Firstname);
		stmt.setString(10, Author_Lastname);
		stmt.setInt(11, ISBN);
		stmt.setDouble(12,Price);
		stmt.setInt(13, Credit_Card_Number);
		stmt.setDouble(14, Percent_Received);
		stmt.setDouble(15, total);
		stmt.setString(16,received);
		stmt.setString(17, shipped);
			
		int i=stmt.executeUpdate();  
		System.out.println(i+" records updated"); 
	}}
	/*public void updateTransaction(){
		
		
		
	}
	*/


	/*public static void main(String[] args){
		
		
		
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
			
			
		}*/

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


