package Controller;

import java.util.List;

import GUI.FormEvent;
import Model.AgeCategory;
import Model.Database;
import Model.EmploymentCategory;
import Model.Gender;
import Model.Person;

public class MainController {

	Database db;
	public MainController()
	{
		db=new Database();
	}
	public List<Person> getPeople()
	{
		return db.getPeople();
	}
	public void addPerson(FormEvent e)
	{
		EmploymentCategory occupation;
		Gender gender;
		AgeCategory ageCategory;
		
		switch (e.getOccupation()) {
		case "Employee":
			occupation = EmploymentCategory.employee;
			break;
		case "UnEmployee":
			occupation = EmploymentCategory.unEmployee;
			break;
		case "Self Employee":
			occupation = EmploymentCategory.selfEmployee;
			break;
		case "Student":
			occupation = EmploymentCategory.student;
			break;
		default:
			occupation = null;
			break;
		}
		
		switch (e.getGender()) {
		case "male":
			gender = Gender.male;
			break;
		case "female":
			gender = Gender.female;
			break;
		default:
			gender = null;
			break;
		}
		
		switch (e.getAge()) {
		case 0:
			ageCategory = AgeCategory.child;
			break;
		case 1:
			ageCategory = AgeCategory.adult;
			break;
		case 2:
			ageCategory = AgeCategory.senior;
			break;
		default:
			ageCategory = null;
			break;
		}
		System.out.println(gender.toString());
		Person p = new Person(e.getfName(), e.getlName(), e.getuName(), e.getPassword(),
				occupation, e.getIsUsCitizen(),	e.getTaxId(), gender, ageCategory);
		
		db.AddPerson(p);
		
	}
}
