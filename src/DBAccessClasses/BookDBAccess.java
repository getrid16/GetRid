package DBAccessClasses;
/**
 * these are import statements that may be needed and are subject to change
 * can also  just use java.sql.*;
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

import ObjectClasses.Book;
/**
 * this class will handle the interaction between Book objects and the Product database table
 * it will have all the methods related to Book objects like searching for them, adding them to the database, removing them.
 * it will be accessed by the Main Classes when a user searches or wants to make changes to an existing post 
 * or create a new one along with the UserDBAccess class
 * @author gchar158
 *NOTE-need to add methods for searching by account number for post related code like updating
 *need to add methods to update records, create records and delete records. These methods may be void or return type depending on the user interface
 */
public class BookDBAccess {//may remove public access specifier

	private static Connection conn;
	/**
	 * this method will search for books that match the isbn passed and return them to be displayed. if no book is found a message is returned. 
	 * the method may need to be modified for the different search options if the separate one isn't created i.e. author, subject, edition etc.
	 * @param isbn the isbn entered in the browse class for the initial search
	 * @return a list of books or "not found" message
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getBookByISBN( String isbn)throws ClassNotFoundException, SQLException{
		conn=getConnection();//solution to error is uncommenting code in DBConnection class. see explanation
		String searchResult;
		//PreparedStatement stmt= conn.prepareStatement("SELECT Entry_number, Booktitle, IBSN, Condition, Author_Firstname, Author_Lastname, Seller_Name, Price"
			//	+ " FROM product WHERE ISBN="+isbn);//testing this way of writing the query. use OR if it doesn't work
		PreparedStatement stmt= conn.prepareStatement("SELECT Entry_number, Booktitle, IBSN, Condition, Author_Firstname, Author_Lastname,"
				+ "Seller_Name, Price FROM product WHERE ISBN=?");
		stmt.setString(1,isbn);//change ISBN to char in database or pass a int in method header
		ResultSet rs= stmt.executeQuery();
		if(!rs.next()){
			searchResult="No Book found, please try again";
		}
		else
			while(rs.next()){//while there is data to be taken in, enter it in the correct variable and put it into a formatted string.
				int entrynum=rs.getInt("Entry_number");
				String title=rs.getString("Booktitle");
				int ISBN=rs.getInt("ISBN");
				String condition=rs.getString("Condition");
				String authorFirst=rs.getString("Author_Firstname");
				String authorLast=rs.getString("Author_Lastname");
				String seller=rs.getString("Seller");
				double price=rs.getDouble("Price");
				searchResult="Entry Number: "+entrynum+"\t"+title+
						"\nISBN:\t"+ISBN+
						"\nAuthor:"+authorFirst+" "+authorLast+
						"\nSeller:\t"+seller+
						"\nCondition:\t"+condition+"\nPrice:\t"+price;
				
			}
		stmt.close();
		return searchResult;//return the formated string
	}
	
	/**
	 * This method retrieves all the info of ALL the books in the product table. It calls createResultList to create 
	 * an ArrayList of book objects then returns it. It will be called when the "Browse All" button is hit in the BrowseFrame class.
	 * will either be modified for finding the books of a specific seller or used as a base for a separate similar method
	 * @return an ArrayList of book objects each containing info about a book. may require a toString method to format it
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Book> searchAllBooks()throws ClassNotFoundException, SQLException{
		ArrayList<Book>books;
		conn=getConnection();
		PreparedStatement stmt= conn.prepareStatement("SELECT Entry_number, SellerAcountNum, Booktitle, IBSN, Condition, Author_Firstname, Author_Lastname, "
				+ "Seller_Name, Price FROM product");
		ResultSet rs= stmt.executeQuery();
		books=createResultList(rs);
		stmt.close();
		/*for(int i=0; i<books.size(); i++){//prints out the list of results in formatted string
			books.get(i).BooktoString();
		}	*/
		return books;
	}

	/**
	 * This method creates the ArrayList of books objects with the help of creatBook(rs);
	 * @param rs the result set from ArrayList<Book>allBooks
	 * @return ArrayList of book objects
	 * @throws SQLException
	 */
	private static ArrayList<Book> createResultList(ResultSet rs) throws SQLException {
		ArrayList<Book>books=new ArrayList<Book>();
		while(rs.next()){
			Book book= createBook(rs);
			books.add(book);
		}
		return books;
	}
	/**
	 * This method assists ArrayList<Book>allBooks in creating the ArrayList of books by creating the book objects
	 * @param rs the result set
	 * @return book object
	 * @throws SQLException
	 */
	private static Book createBook(ResultSet rs)throws SQLException {
		int entrynum=rs.getInt("Entry_number");
		int sellerAcc=rs.getInt("SellerAcountNum");
		String title=rs.getString("Booktitle");
		int ISBN=rs.getInt("ISBN");
		String condition=rs.getString("Condition");
		String authorFirst=rs.getString("Author_Firstname");
		String authorLast=rs.getString("Author_Lastname");
		String seller=rs.getString("Seller");
		double price=rs.getDouble("Price");
		Book book= new Book(entrynum, sellerAcc, seller, title, authorFirst, authorLast, ISBN, price, condition);
		return book;
	}
	/**
	 * This method does the same at getBookByIBSN except it searches by title instead of IBSN (in fact it was copied)
	 * @param title the title of the book being searched for
	 * @return formated string of the result(s)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getBookByTitle(String Title)throws ClassNotFoundException, SQLException{
		conn=getConnection();//solution to error is uncommenting code in DBConnection class. see explanation
		String searchResult;
		PreparedStatement stmt= conn.prepareStatement("SELECT Entry_number, Booktitle, IBSN, Condition, Author_Firstname, Author_Lastname,"
				+ "Seller_Name, Price FROM product WHERE Booktitle=?");
		stmt.setString(1, Title);
		ResultSet rs= stmt.executeQuery();
		if(!rs.next()){
			searchResult="No Book found, please try again";
		}
		else
			while(rs.next()){//while there is data to be taken in, enter it in the correct variable and put it into a formatted string.
				int entrynum=rs.getInt("Entry_number");
				String title=rs.getString("Booktitle");
				int ISBN=rs.getInt("ISBN");
				String condition=rs.getString("Condition");
				String authorFirst=rs.getString("Author_Firstname");
				String authorLast=rs.getString("Author_Lastname");
				String seller=rs.getString("Seller");
				double price=rs.getDouble("Price");
				searchResult="Entry Number: "+entrynum+"\t"+title+
						"\nISBN:\t"+ISBN+
						"\nAuthor:"+authorFirst+" "+authorLast+
						"\nSeller:\t"+seller+
						"\nCondition:\t"+condition+"\nPrice:\t"+price;
				
			}
		stmt.close();
		return searchResult;//return the formated string
	}
	/**
	 * This method searches for books by author's name
	 * @param first author's first name
	 * @param last author's last name
	 * @return formated string of the result(s)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getBookByAuthor( String first, String last)throws ClassNotFoundException, SQLException{
		conn=getConnection();//solution to error is uncommenting code in DBConnection class. see explanation
		String searchResult;
		PreparedStatement stmt= conn.prepareStatement("SELECT Entry_number, Booktitle, IBSN, Condition, Author_Firstname, Author_Lastname,Seller_Name, "
				+ "Price FROM product WHERE Author_Firstname=? AND Author_Lastname=?");
		stmt.setString(1,first);
		stmt.setString(2,last);
		ResultSet rs= stmt.executeQuery();
		if(!rs.next()){
			searchResult="No Book found, please try again";
		}
		else
			while(rs.next()){//while there is data to be taken in, enter it in the correct variable and put it into a formatted string.
				int entrynum=rs.getInt("Entry_number");
				String title=rs.getString("Booktitle");
				int ISBN=rs.getInt("ISBN");
				String condition=rs.getString("Condition");
				String authorFirst=rs.getString("Author_Firstname");
				String authorLast=rs.getString("Author_Lastname");
				String seller=rs.getString("Seller");
				double price=rs.getDouble("Price");
				searchResult="Entry Number: "+entrynum+"\t"+title+
						"\nISBN:\t"+ISBN+
						"\nAuthor:"+authorFirst+" "+authorLast+
						"\nSeller:\t"+seller+
						"\nCondition:\t"+condition+"\nPrice:\t"+price;
				
			}
		stmt.close();
		return searchResult;//return the formated string
	}
	
}
