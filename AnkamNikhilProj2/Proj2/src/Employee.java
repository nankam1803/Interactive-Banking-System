
public class Employee extends Person {

	int employeeID;
	
	public Employee(String name, String address, String licenseNumber, int employeeID)
	{
		this.licenseNumber = licenseNumber;
		this.name = name;
		this.address = address;
		this.employeeID = employeeID;
	}
	
	public int getEmployeeID()
	{
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID; 
		//String formattedNumber = String.format("%08d", employeeID);
		//employeeID = Integer.parseInt(formattedNumber);
	}
	
	
}
