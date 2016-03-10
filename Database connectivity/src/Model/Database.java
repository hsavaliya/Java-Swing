package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;



public class Database {
	
	private List<Person> personList;
	private Connection conn;
	
	public Database()
	{
		
		personList = new ArrayList<Person>();
	}

	/*************  		DATABASE CONNECTION METHODS       ********************/
	public void connect() throws Exception
	{
		if(conn!=null)
			return;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new Exception("Driver not found");
		}
		
		String connectionURL = "jdbc:mysql://localhost:3306/swing";
	    conn = DriverManager.getConnection(connectionURL,"root", "root"); 
		System.out.println("Connected:"+conn);
	}
	public void disConnect()
	{
		if(conn!=null)
		{
			try {
				conn.close();
				System.out.println("DisConnected");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Can't close connection");
			}
		}
	}
	
	public void save() throws SQLException{
		
		String sql = "Select count(*) from Users where ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		String inserSQL = "INSERT INTO `Users`(`FirstName`,`LastName`,`UserName`,`Password`,`Occupation`,`IsUSCitizen`,`TaxID`,`Gender`,`Age`,`ID`) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement insertStmt = conn.prepareStatement(inserSQL);
		
		String updateSQL = "Update `Users` set `FirstName`=?,`LastName`=?,`UserName`=?,`Password`=?,`Occupation`=?,`IsUSCitizen`=?,`TaxID`=?,`Gender`=?,`Age`=? where `ID`=?";
		PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
		
		for(Person person: personList)
		{
			int Id= person.getId();
			 String fName= person.getfName();
			 String lName = person.getlName();
			 String uName = person.getuName();
			 String password = person.getPassword();
			 EmploymentCategory occupation = person.getOccupation();
			 Boolean isUsCitizen = person.getIsUsCitizen();
			 String taxId = person.getTaxId();
			 Gender gender = person.getGender();
			 AgeCategory ageCategory = person.getAgeCategory();
			
			
			
			stmt.setInt(1, person.getId());  // first value start from 1 not 0;
			
			ResultSet result =stmt.executeQuery();
			result.next(); // move cursor to first row. INITIALLY IT IS BEFORE FIRST ROW
			
			int count= result.getInt(1); // get result
			if(count==0) // insert data
			{
				int col=1;
				insertStmt.setString(col++, fName);
				insertStmt.setString(col++, lName);
				insertStmt.setString(col++, uName);
				insertStmt.setString(col++, password);
				insertStmt.setString(col++, occupation.name());
				insertStmt.setBoolean(col++, isUsCitizen);
				insertStmt.setString(col++, taxId);
				insertStmt.setString(col++, gender.name());
				insertStmt.setString(col++, ageCategory.name());
				insertStmt.setInt(col++, Id);
				
				insertStmt.executeUpdate();

			}
			else // update
			{
				
				
				updateStmt.setString(1, fName);
				updateStmt.setString(2, lName);
				updateStmt.setString(3, uName);
				updateStmt.setString(4, password);
				updateStmt.setString(5, occupation.name());
				updateStmt.setBoolean(6, isUsCitizen);
				updateStmt.setString(7, taxId);
				updateStmt.setString(8, gender.name());
				updateStmt.setString(9, ageCategory.name());
				updateStmt.setInt(10, Id);
				
				updateStmt.executeUpdate();
			}
		}
		updateStmt.close();
		insertStmt.close();
		stmt.close();
	}
	
	public List<Person> load() throws SQLException{
	
		String sql = "select * from Users order by FirstName";
		Statement  stmt = conn.createStatement();
		
		ResultSet results = stmt.executeQuery(sql);
		personList.clear();
		
		while(results.next())
		{
			 int Id = results.getInt("ID");
			 String fName= results.getString("FirstName");
			 String lName = results.getString("LastName");
			 String uName = results.getString("UserName");
			 String password = results.getString("Password");
			 EmploymentCategory occupation = EmploymentCategory.valueOf(results.getString("Occupation"));
			 Boolean isUsCitizen = results.getBoolean("IsUSCitizen");
			 String taxId = results.getString("TaxID");
			 Gender gender = Gender.valueOf(results.getString("Gender"));
			 AgeCategory ageCategory = AgeCategory.valueOf(results.getString("Age"));
			 personList.add(new Person(Id,fName, lName, uName, password, occupation, isUsCitizen, taxId, gender, ageCategory));
			 
		}
		
		return personList;
	}
	public void select() throws SQLException{
		
		String sql = "Select count(*) from Users where FirstName=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, "jack");
		
		ResultSet result =stmt.executeQuery();
		result.next(); // move cursor to first row. INITIALLY IT IS BEFORE FIRST ROW
		
		int count= result.getInt(1); // get result
		
		System.out.println("Select result:"+ count);
		stmt.close();
	}
	
	
	/*************  		DATABASE CONNECTION METHODS END       ********************/
	
	public void AddPerson(Person p)
	{
		personList.add(p);
	}
	
	public List<Person> getPeople()
	{
		return personList;
	}
	
	
}
