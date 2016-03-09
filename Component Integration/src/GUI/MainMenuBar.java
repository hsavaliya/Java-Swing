package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.plaf.FileChooserUI;

public class MainMenuBar extends JMenuBar {
	private JFileChooser fileChooser;
	public MainMenuBar(){
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFilter());
		add(setFileMenu());
		add(setWindowMenu());
	}
	private JMenu setWindowMenu(){

		JMenu windowMenu = new JMenu("Window");
		windowMenu.setMnemonic(KeyEvent.VK_W);
		
		return windowMenu;
	}
	private JMenu setFileMenu(){
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.setMnemonic(KeyEvent.VK_S);
		
		JMenuItem importItem = new JMenuItem("Import Data");
		importItem.setMnemonic(KeyEvent.VK_I);
		importItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		
		importItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MainMenuBar.this) == JFileChooser.APPROVE_OPTION)
				{
					System.out.println(fileChooser.getSelectedFile());
				}
				
			}
		});
		
		
		JMenuItem exportItem = new JMenuItem("Export Data");
		exportItem.setMnemonic(KeyEvent.VK_E);
		exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		JMenuItem exitItem = new JMenuItem("Exit:");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int action =JOptionPane.showConfirmDialog(MainMenuBar.this, "Do you really want to exit?","Exit Confirmation",JOptionPane.CANCEL_OPTION);
				if(action==JOptionPane.OK_OPTION)
				{
					System.exit(0);
				}
			}
		});
		
		
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(importItem);
		fileMenu.add(exportItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		return fileMenu;
	}

}
