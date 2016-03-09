package GUI;

import javax.swing.SwingUtilities;

public class ApplicationMain {

	
	public static void main (String[] args)
	{
		//Helps to avoid crash while opening application
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MainFrame("User Management");
			}
			
		});
		
	}
}
