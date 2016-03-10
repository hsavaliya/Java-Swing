package Model;

public class Person {
	
	private static int count=0;
	private int Id;
	
	private String fName;
	private String lName;
	private String uName;
	private String password;
	private EmploymentCategory occupation;
	private Boolean isUsCitizen;
	private String taxId;
	private Gender gender;
	private AgeCategory ageCategory;
	public Person()
	{
		Id = 0;
		this.fName = "";
		this.lName = "";
		this.uName = "";
		this.password = "";
		this.occupation = null;
		this.isUsCitizen = false;
		this.taxId = "";
		this.gender = null;
		this.ageCategory = null;
		
	}
	public Person(String fName, String lName, String uName,
			String password, EmploymentCategory occupation,
			Boolean isUsCitizen, String taxId, Gender gender,
			AgeCategory ageCategory) {
		super();
		Id = ++count;
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.password = password;
		this.occupation = occupation;
		this.isUsCitizen = isUsCitizen;
		this.taxId = taxId;
		this.gender = gender;
		this.ageCategory = ageCategory;
		
		
	}
	public Person(int id, String fName, String lName, String uName,
			String password, EmploymentCategory occupation,
			Boolean isUsCitizen, String taxId, Gender gender,
			AgeCategory ageCategory) {
		super();
		Id = id;
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.password = password;
		this.occupation = occupation;
		this.isUsCitizen = isUsCitizen;
		this.taxId = taxId;
		this.gender = gender;
		this.ageCategory = ageCategory;
		
		
	}
	public static int getCount() {
		return count;
	}
	public int getId() {
		return Id;
	}
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public String getuName() {
		return uName;
	}
	public String getPassword() {
		return password;
	}
	public EmploymentCategory getOccupation() {
		return occupation;
	}
	public Boolean getIsUsCitizen() {
		return isUsCitizen;
	}
	public String getTaxId() {
		return taxId;
	}
	public Gender getGender() {
		return gender;
	}
	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

		
}
