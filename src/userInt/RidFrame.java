package userInt;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RidFrame extends JFrame {
	private static final int FRAME_HEIGHT = 450;
	private static final int FRAME_WIDTH = 450;

	private JPanel ridPanel;
	
	private JLabel bookTitleLabel;
	private JTextField bookTitleField;
	
	private JLabel isbnLabel;
	private JTextField isbnField;
	
	private JLabel firstNameLabel;
	private JTextField firstNameField;

	private JLabel lastNameLabel;
	private JTextField lastNameField;

	private JLabel conditionLabel;
	private JTextField conditionField;
	
	private JLabel priceLabel;
	private JTextField priceField;
	
	private JButton menuButton;
	private JButton submitButton;
	
	public RidFrame() 
	{
		createTextField();
		createButtons();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createTextField()
	      {
			final int FIELD_WIDTH = 20;
	         bookTitleLabel = new JLabel("   Book Title: ");	   
	         bookTitleField = new JTextField(FIELD_WIDTH);
	         isbnLabel = new JLabel("   ISBN (13): ");	   
	         isbnField = new JTextField(FIELD_WIDTH);
	         firstNameLabel = new JLabel("   Author First Name: ");	   
	         firstNameField = new JTextField(FIELD_WIDTH);
	         lastNameLabel = new JLabel("   Author Last Name: ");	   
	         lastNameField = new JTextField(FIELD_WIDTH);
	         conditionLabel = new JLabel("   Condition(USED/NEW): ");	   
	         conditionField = new JTextField(FIELD_WIDTH);
	         priceLabel = new JLabel("   Price (ex. 19.99): ");	   
	         priceField = new JTextField(FIELD_WIDTH);
	        }
	
	private void createButtons()
	{
		menuButton = new JButton("Main Menu");
		submitButton = new JButton("Post Book");
		
		 ActionListener MenuListener = new ActionListener()
		 {
			public void actionPerformed(ActionEvent ae) 
			{
				dispose();
 	 	    	JFrame frame = new MenuFrame();
 	 	   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	 	   		frame.setTitle("GetRid - Menu");
 	 	   		frame.setResizable(false);
 	 	   		frame.setVisible(true);
			}
 	    };
		 
 	   ActionListener PostBookListener = new ActionListener() 
 	   {
	    	public void actionPerformed(ActionEvent ae) 
	    	{
	    		//TODO send to backend the info in the textfields
	    		
	    		
	    		//goes back to main menu after posting book
	    		dispose();
	    		JOptionPane.showMessageDialog(null, "Your book has been posted.");
	    		JFrame frame = new MenuFrame();
 	 	   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	 	   		frame.setTitle("GetRid - Menu");
 	 	   		frame.setResizable(false);
 	 	   		frame.setVisible(true);
	    	}
	    	 
 	    };
		 
 	    menuButton.addActionListener(MenuListener);
	 	submitButton.addActionListener(PostBookListener);
		
		 }
	
 	   
	private void createPanel()
	{
	
		ridPanel = new JPanel();
		ridPanel.setLayout(new FlowLayout());
        
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(6, 2));
        middlePanel.add(bookTitleLabel);
        middlePanel.add(bookTitleField);
        
        middlePanel.add(isbnLabel);
        middlePanel.add(isbnField);
        
        middlePanel.add(firstNameLabel);
        middlePanel.add(firstNameField);
        
        middlePanel.add(lastNameLabel);
        middlePanel.add(lastNameField);
        
        middlePanel.add(conditionLabel);
        middlePanel.add(conditionField);
        
        middlePanel.add(priceLabel);
        middlePanel.add(priceField);
        
        
        
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(menuButton);
		bottomPanel.add(submitButton);		
	
		ridPanel.add(middlePanel);
		ridPanel.add(bottomPanel);
		add(ridPanel);
	}
}