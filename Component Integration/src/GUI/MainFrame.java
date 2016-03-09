package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Controller.MainController;



public class MainFrame extends JFrame {

    
	//private JTextArea txtResult;
	public MainFrame(String title)
	{
		super(title);
		MainController controller = new MainController();
		
		setSize(500, 500);
		setPreferredSize(getPreferredSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FormPanel formPanel = new FormPanel();
		//txtResult = new JTextArea();
		//txtResult.setSize(500, 100);
		
		TablePanel tablePanel = new TablePanel();
		tablePanel.setData(controller.getPeople());
		
		setJMenuBar(new MainMenuBar());
		setLayout(new BorderLayout());
		add(formPanel, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
		
		
		formPanel.setFormActionListener(new IFormListener() {
			
			@Override
			public void FormEventOccured(FormEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Call method to show content into textarea");
				controller.addPerson(e);
				tablePanel.refresh();
			}
		});
		
		
		setVisible(true);
		
	}
}
