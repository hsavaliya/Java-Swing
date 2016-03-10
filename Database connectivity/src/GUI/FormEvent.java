package GUI;

public class FormEvent  {

	private String fName;
	private String lName;
	private String uName;
	private String password;
	private String occupation;
	private Boolean isUsCitizen;
	private String taxId;
	private String gender;
	private int ageCategory;
	
	public FormEvent()
	{
		
	}

	public FormEvent(String fName, String lName, String uName, String password,
			String occupation, Boolean isUsCitizen, String taxId, String gender,
			int ageCategory) {
		super();
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

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Boolean getIsUsCitizen() {
		return isUsCitizen;
	}

	public void setIsUsCitizen(Boolean isUsCitizen) {
		this.isUsCitizen = isUsCitizen;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return ageCategory;
	}

	public void setAge(int ageCategory) {
		this.ageCategory = ageCategory;
	}
	
}
