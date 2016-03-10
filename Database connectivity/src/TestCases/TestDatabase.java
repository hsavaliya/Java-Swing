package TestCases;

import java.util.List;

import Model.AgeCategory;
import Model.Database;
import Model.EmploymentCategory;
import Model.Gender;
import Model.Person;

public class TestDatabase {

	
	public TestDatabase()
	{
		
		
	}
	
	public static void main(String[] args)
	{
		Database db = new Database();
		try {
			db.connect();
			
			
			Person p1 = new Person("Hetal", "Savaliya", "Uname", "asdf", EmploymentCategory.employee, true, "123456789", Gender.female, AgeCategory.adult);
			Person p2 = new Person("fname", "lname", "Uname", "asd", EmploymentCategory.selfEmployee, true, "111222333", Gender.male, AgeCategory.senior);
			db.AddPerson(p1);
			//db.AddPerson(p2);
			//db.select();
			//db.save();
			List<Person> resultList = db.load();
			
			System.out.println("Total Users in database:"+ resultList.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			db.disConnect();
		}
	}
	
}
