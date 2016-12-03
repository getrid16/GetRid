package userInt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LogInFrame extends JFrame {
	private static final int FRAME_HEIGHT = 450;
	private static final int FRAME_WIDTH = 450;

	private JPanel loginPanel;
	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel passwordLabel;
	private JTextField passwordField;
	private JButton loginButton;
	private JButton signupButton;
	
	public LogInFrame() 
	{
		createTextField();
		createButtons();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createTextField()
	      {
			final int FIELD_WIDTH = 20;
	         usernameLabel = new JLabel("Username: ");	   
	         usernameField = new JTextField(FIELD_WIDTH);
	         
	         passwordLabel = new JLabel("Password: ");	   
	         passwordField = new JTextField(FIELD_WIDTH);
	      }
	
	private void createButtons()
	{
		loginButton = new JButton("Log In");
		signupButton = new JButton("Sign Up");
		
		 ActionListener LoginListener = new ActionListener() {
 	    	public void actionPerformed(ActionEvent e) {
 	    	    
 	    	}
 	    };
 	    
 	   ActionListener SignupListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	
	    	}
	    };

		loginButton.addActionListener(LoginListener);
		signupButton.addActionListener(SignupListener);
		
	}
	
	private void createPanel()
	{
	
		loginPanel = new JPanel();
		loginPanel.setLayout(new FlowLayout());
        
		ImageIcon image = new ImageIcon("loginLogo.png");
        JLabel imageLabel = new JLabel(image); 
		imageLabel.setBounds(5, 5, 5, 5);
		imageLabel.setVisible(true);
        loginPanel.add(imageLabel);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(2, 2));
        middlePanel.add(usernameLabel);
        middlePanel.add(usernameField);
        middlePanel.add(passwordLabel);
        middlePanel.add(passwordField);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(loginButton);
		bottomPanel.add(signupButton);		
	
		loginPanel.add(middlePanel);
		loginPanel.add(bottomPanel);
		add(loginPanel);
	}
}
