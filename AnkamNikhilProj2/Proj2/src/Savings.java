
public class Savings extends Account
{
	double annualInterestRate;
	String name;
	
	public Savings(double annualInterestRate, String name)
	{
		super();
		this.annualInterestRate = annualInterestRate;
		this.name = name;
		
	}

	public Savings(long accountNumber, double accountBalance, double annualInterestRate, String name)
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
	public void setAccountBalance(double newBalance) 
	{
		this.accountBalance = newBalance;	
	}
	
	public void makeDeposit(double amount)
	{
		if(amount >= 10000)
		{
			amount += 5;
			accountBalance += amount;
		}
		
		else
		{
			accountBalance += amount;
		}
	}
	
	public void makeWithdrawal(double amount)
	{
		if(amount <= accountBalance)
		{
			accountBalance -= amount ;
		}
		
		else
			try 
		{
			throw new Exception("overdraft");
			
		}
			catch(Exception e)
		{
				System.out.println("overdraft");
		}
	}
}
