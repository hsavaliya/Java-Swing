package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import Model.Person;

public class TablePanel extends JPanel {

	private JTable table;
	private PersonTableAbstractModel tableModel;
	public TablePanel()
	{
		
		tableModel = new PersonTableAbstractModel();
		table = new JTable(tableModel);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setData(List<Person> data)
	{
		tableModel.setData(data);
	}
	public void refresh()
	{
		tableModel.fireTableDataChanged();
	}
}
