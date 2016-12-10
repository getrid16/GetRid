package userInt;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CheckoutFrame extends JFrame {
	private static final int FRAME_HEIGHT = 450;
	private static final int FRAME_WIDTH = 450;
	private JTextArea cartField;
	private JPanel cartPanel;
	private JButton checkoutButton;
	
	public CheckoutFrame() 
	{
		createTextArea();
		createButtons();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createTextArea() 
	{
		cartField = new JTextArea(20, 30);
		//searchResultField.setText();
		cartField.setEditable(false);
	}
	
	private void createButtons()
	{
		checkoutButton = new JButton("Pay");
 	    
 	   ActionListener CheckoutAndPayListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		// check if IsLoggedIn = true, then add up all prices of books in cart and move to paymentFrame
	    		//check if IsLoggedIn = false, then go to LogInFrame
	 	    	dispose();
	    		JOptionPane.showMessageDialog(null, "Thank you for your purchase. A confirmation email of the transaction will be sent out. Please give 7-10 days for processing and shipment.");
	    		JFrame frame = new MenuFrame();
 	 	   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	 	   		frame.setTitle("GetRid - Menu");
 	 	   		frame.setResizable(false);
 	 	   		frame.setVisible(true);
	    	}
	    };
	   	    checkoutButton.addActionListener(CheckoutAndPayListener);
	}
	
	private void createPanel()
	{
		cartPanel = new JPanel();
		cartPanel.setLayout(new FlowLayout());
        
		JScrollPane scrollPane = new JScrollPane(cartField);
		cartPanel.add(scrollPane);
		
		cartPanel.add(checkoutButton);
		
		add(cartPanel);
	}
}
