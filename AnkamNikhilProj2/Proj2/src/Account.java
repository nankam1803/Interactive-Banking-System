public abstract class Account {

	long accountNumber;
	double accountBalance;
	
	public Account()
	{
		accountBalance = 0;
		accountNumber = (long) (Math.random() * 10000000000L);
		String formattedNumber = String.format("%010d", accountNumber);  //Formats the account number to 10 digits by adding leading zeros
		accountNumber = Long.parseLong(formattedNumber);
	}
	
	public Account(long accountNumber, double accountBalance) 
	{
	    this.accountNumber = accountNumber;
	    this.accountBalance = accountBalance;
	}

	public double getAccountBalance() 
	{
	    return accountBalance;
	}

	public long getAccountNumber() 
	{
	    return accountNumber;
	}

	public abstract void setAccountBalance(double newBalance);
}
