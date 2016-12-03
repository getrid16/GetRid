package userInt;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		
		 ActionListener SearchListener = new ActionListener() {
 	    	public void actionPerformed(ActionEvent e) {
 	    		//back-end query results displayed
 	    	}
 	    };
 	    
 	   ActionListener SearchAllListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//back-end query results displayed
	    	}
	    };
	    
	    ActionListener AddToCartListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//sends book id number to back end, back end sends back book's info,
	    		//which is displayed in the cart
	    		setVisible(false);
	 	    	JFrame frame = new CartFrame();
	 	   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	   		frame.setTitle("GetRid - Cart");
	 	   		frame.setResizable(false);
	 	   		frame.setVisible(true);
	    	}
	    };

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
		
		add(browsePanel);
	}
}