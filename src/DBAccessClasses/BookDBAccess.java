package DBAccessClasses;
/**
 * these are import statements that may be needed and are subject to change
 * can also  just use java.sql.*;
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import ObjectClasses.Book;
/**
 * this class will handle the interaction between Book objects and the Product database table
 * it will have all the methods related to Book objects like searching for them, adding them to the database, removing them.
 * it will be accessed by the Main Classes when a user searches or wants to make changes to an existing post 
 * or create a new one along with the UserDBAccess class
 * @author gchar158
 *
 */
public class BookDBAccess {//may remove public access specifier

	private static Connection conn;
	
	
	
}
