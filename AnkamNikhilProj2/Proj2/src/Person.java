
public abstract class Person {

	String licenseNumber;
	String name;
	String address;
	
	public String getName()								
	{
		return name;
	}

	public String getLicenseNumber()
	{
		return licenseNumber;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setLicenseNumber(String licenseNumber)
	{
		this.licenseNumber = licenseNumber;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
}
