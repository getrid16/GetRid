package MainClasses;
import javax.swing.JFrame;

import userInt.WelcomeFrame;

public class MainClass 
{		
	public static void main(String[]args)
	{
		JFrame frame = new WelcomeFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GetRid");
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
//