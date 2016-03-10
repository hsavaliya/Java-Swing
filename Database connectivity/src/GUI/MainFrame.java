package GUI;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.MainController;
import Model.Person;



public class MainFrame extends JFrame {

    
	//private JTextArea txtResult;
	public MainFrame(String title)
	{
		super(title);
		MainController controller = new MainController();
		
		setSize(500, 700);
		setPreferredSize(getPreferredSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FormPanel formPanel = new FormPanel();
		
		//txtResult = new JTextArea();
		//txtResult.setSize(500, 100);
		
		TablePanel tablePanel = new TablePanel();
		tablePanel.setData(controller.getPeople());
		
		ToolBar toolbar = new ToolBar();
		toolbar.setToolBarListener(new IToolBarListener() {
			
			@Override
			public void SaveEventFire() {
				// TODO Auto-generated method stub
				
				try {
					controller.connect();
					controller.save();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(MainFrame.this, "Unable to save to database", "Database Save problem", JOptionPane.ERROR_MESSAGE);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(MainFrame.this, "Can not connect to database", "Database connection problem", JOptionPane.ERROR_MESSAGE);
				} 
				finally{
					controller.disconnect();
				}
				
			}
			
			@Override
			public void RefreshEventFire() {
				// TODO Auto-generated method stub
			
				try {
					controller.connect();
					List<Person> resultData =controller.load();
					tablePanel.setData(resultData);
					tablePanel.refresh();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(MainFrame.this, "Unable to load from database", "Database load problem", JOptionPane.ERROR_MESSAGE);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(MainFrame.this, "Can not connect to database", "Database connection problem", JOptionPane.ERROR_MESSAGE);
				} 
				finally{
					controller.disconnect();
				} 
				
				
			}
		});
		
		
		
		setJMenuBar(new MainMenuBar());
		setLayout(new BorderLayout());
		add(toolbar, BorderLayout.PAGE_START);
		add(formPanel, BorderLayout.SOUTH);
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
