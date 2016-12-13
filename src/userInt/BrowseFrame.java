package userInt;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DBAccessClasses.BookDBAccess;
import ObjectClasses.Book;
/**
 * This Class handles the browsing part of the user interface. adding a book to a cart and searching for a particular book
 * or the entire database to see what's in it. There should be options to search by author, title or ISBN
 * 
 *
 */
public class BrowseFrame extends JFrame {
	private static final int FRAME_HEIGHT = 450;
	private static final int FRAME_WIDTH = 450;
	private JTextArea searchResultField;
	private JPanel browsePanel;
	private JLabel browseIsbnLabel;
	private JLabel addToCartLabel;
	private JTextField isbnField;
	private JTextField addToCartField;
	private JButton searchButton;
	private JButton searchAllButton;
	private JButton addToCartButton;
	private JButton menu;
	
	//ArrayList<Book> cart= new ArrayList(); //for Alexanders part
	BookDBAccess bookdba= new BookDBAccess();
	public BrowseFrame() 
	{
		createTextField();
		createTextArea();
		createButtons();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createTextField()
	      {
	         browseIsbnLabel = new JLabel("Book ISBN: ");
	         addToCartLabel = new JLabel("Type in ONE book's ID number then add to cart: ");

	         final int FIELD_WIDTH = 13;
	         isbnField = new JTextField(FIELD_WIDTH);
	         addToCartField = new JTextField(FIELD_WIDTH);

	         //isbnField.setText("");
	      }

	private void createTextArea() 
	{
		searchResultField = new JTextArea(20, 30);
		//searchResultField.setText();
		searchResultField.setEditable(false);
	}
	
	private void createButtons()
	{
		searchButton = new JButton("Search");
		searchAllButton = new JButton("Search All");
		addToCartButton = new JButton("Add to Cart");
		menu = new JButton("Menu");
		
		/**
		 * This button when pressed with take the contents of the isbnField, store it in a variable and use it
		 * to find all the books that match then return its information in a formatted string
		 */
		 ActionListener SearchListener = new ActionListener() {
 	    	public void actionPerformed(ActionEvent e) {
 	    		//back-end query results displayed for individual search
 	    		int search;// takes the text in the search field
 	    		try {
 	    			search=Integer.parseInt(isbnField.getText());//changes it to an integer 
 	    			//may change the type in the database to varchar(13)
					String searchResult=bookdba.getBookByISBN(search);
					searchResultField.setText(searchResult);//check to see if ArrayList declaration is needed here
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//search method that passes search and returns result(s) method located in BookDBAccess
 	    		
 	    		//here have a JOptionpane tell the user that the book was either added or not found.
 	    	}
 	    };
 	    /**
 	     * This button, when pressed should return a list of every book in the database in a formatted string
 	     * that includes its entry number, title, author etc.
 	     */
 	   ActionListener SearchAllListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    			
	    	//back-end query results displayed for general search
	    	//call to method that will display the contents of ArrayList in formated string
	    		ArrayList<Book> bookResults = null;
	    		String results;
				try {
					bookResults = bookdba.searchAllBooks();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		for(int i=0; i<bookResults.size(); i++){//prints out the list of results in formatted string
	    			results=bookResults.get(i).BooktoString();//may add "\n"
	    			searchResultField.append(results);
	    		}
	    		
	    	}
	    };
	    /**
	     * This button when pressed, Adds a book matching the entry number to an ArrayList that functions as
	     * the cart
	     */
	    ActionListener AddToCartListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		bookdba.getBookByEntryNum(num);//sends book id number to back end, back end sends back book's info,
	    		//which is displayed in the cart
	 	    	dispose();
	 	    	JFrame frame = new CartFrame();
	 	   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	   		frame.setTitle("GetRid - Cart");
	 	   		frame.setResizable(false);
	 	   		frame.setVisible(true);
	    	}
	    };
	    /**
	     * This button when pressed takes the user back to the menu
	     */
	    ActionListener MenuListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	 	    	dispose();
	 	    	JFrame frame = new MenuFrame();
	 	   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	   		frame.setTitle("GetRid - Menu");
	 	   		frame.setResizable(false);
	 	   		frame.setVisible(true);
	    	}
	    };
	    
	    menu.addActionListener(MenuListener);
		searchButton.addActionListener(SearchListener);
		searchAllButton.addActionListener(SearchAllListener);
		addToCartButton.addActionListener(AddToCartListener);
		
	}
	
	private void createPanel()
	{
		browsePanel = new JPanel();
		browsePanel.setLayout(new FlowLayout());
        
		browsePanel.add(browseIsbnLabel);
		browsePanel.add(isbnField);
		browsePanel.add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane(searchResultField);
		browsePanel.add(scrollPane);
		
		browsePanel.add(searchAllButton);
		browsePanel.add(addToCartLabel);
		browsePanel.add(addToCartField);
		browsePanel.add(addToCartButton);
		browsePanel.add(menu);
		add(browsePanel);
	}
}