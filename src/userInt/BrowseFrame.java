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
	private JTextField isbnField;
	private JButton searchButton;
	private JButton searchAllButton;
	
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
	   
	         final int FIELD_WIDTH = 13;
	         isbnField = new JTextField(FIELD_WIDTH);
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
		
		
		 ActionListener SearchListener = new ActionListener() {
 	    	public void actionPerformed(ActionEvent e) {
 	    	    	
 	    	}
 	    };
 	    
 	   ActionListener SearchAllListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	
	    	}
	    };

		searchButton.addActionListener(SearchListener);
		searchAllButton.addActionListener(SearchAllListener);
		
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
		
		add(browsePanel);
	}
}