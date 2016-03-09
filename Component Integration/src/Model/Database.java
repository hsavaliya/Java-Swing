package Model;

import java.util.List;
import java.util.ArrayList;

public class Database {
	
	private List<Person> personList;
	
	public Database()
	{
		
		personList = new ArrayList<Person>();
	}

	public void AddPerson(Person p)
	{
		personList.add(p);
	}
	
	public List<Person> getPeople()
	{
		return personList;
	}
	
	public void connect()
	{
		
	}
}
