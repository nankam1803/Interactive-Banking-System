public class Checking extends Account {

	double annualInterestRate;
	String name;
	
	public Checking(double annualInterestRate, String name)
	{
		super();
		this.annualInterestRate = annualInterestRate;
		this.name = name;	
	}
	
	public Checking(double annualInterestRate, double accountBalance, long accountNumber, String name)
	{
		this.annualInterestRate = annualInterestRate;
		this.accountBalance = accountBalance;
		this.accountNumber = accountNumber;
		this.name = name;	
	}
	
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAnnualInterestRate(double annualInterestRate)
	{
		this.annualInterestRate = annualInterestRate;
	}
	
	@Override
	public void setAccountBalance(double accountBalance)
	{
		this.accountBalance = accountBalance;
	}
	
	public void makeDeposit(double amount)
	{
		accountBalance += amount;
	}
	
	public void makeWithdrawal(double amount) 
	{
		if(amount <= accountBalance + 1)
		{
			accountBalance--;
			accountBalance -= amount;
		}
		
		else {
			try 
		{
			throw new Exception("overdraft");
			
		}
			catch(Exception e)
		{
				System.out.println("overdraft");
		}}
	}
}
