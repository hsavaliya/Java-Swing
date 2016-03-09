package GUI;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.KeyStore;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class ToolBar extends JMenuBar {
	
	public ToolBar(){
		
		JMenuBar menuBar =  new JMenuBar();
		menuBar.add(setFileMenu());
		
	}
	
	private JMenu setFileMenu(){
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.setMnemonic(KeyEvent.VK_S);
		
		JMenuItem importItem = new JMenuItem("Import Data");
		importItem.setMnemonic(KeyEvent.VK_I);
		importItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		
		JMenuItem exportItem = new JMenuItem("Export Data");
		exportItem.setMnemonic(KeyEvent.VK_E);
		exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		JMenuItem exitItem = new JMenuItem("Exit:");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(importItem);
		fileMenu.add(exportItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		return fileMenu;
	}

}
