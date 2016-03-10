package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Person;

public class PersonTableAbstractModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Person> db;
	
	private String[] colNames = {"First Name", "Last Name", "User Name", "Password",
			"Occupation", "Is US Citizen?", "Tax Id", "Gender", "Age Group"};
	
	public void setData(List<Person> db)
	{
		this.db=db;	
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Person person = db.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return person.getfName();
		case 1:
			return person.getlName();
		case 2:
			return person.getuName();
		case 3:
			return person.getPassword();
		case 4:
			return person.getOccupation();
		case 5:
			return person.getIsUsCitizen();	
		case 6:
			return person.getTaxId();
		case 7:
			return person.getGender();
		case 8:
			return person.getAgeCategory();
		default:
			 break;
		}
		return null;
	}

}
