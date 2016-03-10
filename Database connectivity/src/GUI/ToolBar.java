package GUI;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.KeyStore;
import java.sql.Savepoint;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class ToolBar extends JToolBar implements ActionListener {
	
	private JButton saveButton;
	private JButton RefreshButton;
	
	private IToolBarListener toolBarListener;
	
	public ToolBar(){
		
		 saveButton = new JButton("Save");
		 RefreshButton = new JButton("Refresh");
		
		saveButton.addActionListener(this);
		RefreshButton.addActionListener(this);
		
		//setFloatable(false); // if you don't need draggable toolbar
		
		//setLayout(new FlowLayout(FlowLayout.LEFT));  // instead of JToolBar, if we use panel, then we need
		add(saveButton);
		addSeparator();
		add(RefreshButton);
		
		
	}

	public void setToolBarListener(IToolBarListener listener){
		toolBarListener = listener;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton eventBtn = (JButton)e.getSource();
		if(eventBtn == saveButton)
		{
			toolBarListener.SaveEventFire();
		}
		else if(eventBtn == RefreshButton)
		{
			toolBarListener.RefreshEventFire();
		}
		
	}
	
	

}
