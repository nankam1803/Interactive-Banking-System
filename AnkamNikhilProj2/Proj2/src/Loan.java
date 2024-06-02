import java.util.Date;

public class Loan extends Account{
	
	double annualInterestRate;
	int numberOfYears;
	String name;
	Date loanDate;
	
	public Loan(String name)
	{
		super();
		this.name = name;
		loanDate = new Date();
	}
	
	public Loan(long accountNumber, double accountBalance, double annualInterestRate, int numberOfYears, String name) {
        // super(accountNumber, accountBalance); // Call the constructor of the parent class
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.name = name;
        this.loanDate = new Date(); 
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public String getName() {
        return name;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    // Override the setAccountBalance() method from the parent class
    @Override
    public void setAccountBalance(double newBalance) {
        this.accountBalance = newBalance;
    }

    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double numberOfPayments = numberOfYears * 12;
        double monthlyPayment = getAccountBalance() * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        return monthlyPayment;
    }
    
    public double getTotalPayment()
    {
    	double totalPayment = getMonthlyPayment() * numberOfYears * 12;
    	return totalPayment;
    }
}