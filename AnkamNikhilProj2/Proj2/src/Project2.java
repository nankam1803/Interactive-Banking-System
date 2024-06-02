/*
 * Name: Nikhil Ankam 
 * R#: R01576061
 * 
 * Description:
 * The main purpose of this project is to check bank balance, deposit money or withdraw money and return
 * details whenever asked for. This program uses seven different classes which are implemented in 
 * the main class(i.e. Project2). We take input from a File named "input" and then display the output in the console 
 * as well as another file named "output". Wherever there is an error, the program prints a message "error" and 
 * stops further execution.
 * 
 * Indentation Style: Allman Style
 * Naming convention: Camelcase used
 * 
 * Start date: N/A
 * End date: 04/15/24
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Project2 
{

	public static void main(String[] args) 
	{
		try 
		{
			File file = new File("input.txt");
			PrintWriter writer = new PrintWriter("output.txt");
			Scanner scan = new Scanner(file);
			
			
			while(scan.hasNextLine())
			{
				
				String objectType = scan.nextLine().trim();								//We take input from the next line of the file.
					
				if(objectType.equals("0"))												//If the next line says "0", we exit from the program.
				{
					writer.close();
					System.exit(0);
				}
					
				else
				{
					switch(objectType)
					{
						case "Employee":												
						{
						 String constructorType = scan.nextLine();
						 
						 switch(constructorType)
						 {
									
						 case "1":
							{
							String name = scan.nextLine();
							String address = scan.nextLine();
							String licenseNumber = scan.nextLine();
							String employeeid = scan.nextLine();
							
							if(employeeid.length() > 8)									//Checks if Employee ID is longer than 8 digits
							{
								System.out.println("error");
								writer.println("error");
								writer.close();
								System.exit(0);
							}
							
							//Check for license Number
							
							if (licenseNumber.length() == 8 && Character.isLetter(licenseNumber.charAt(0)) && Character.isLetter(licenseNumber.charAt(1))) 
							{
					            if (Character.isUpperCase(licenseNumber.charAt(0)) && Character.isUpperCase(licenseNumber.charAt(1))) 
					            {
					                for (int i = 2; i < licenseNumber.length(); i++)
					                {
					                    if (!Character.isDigit(licenseNumber.charAt(i))) 
					                    {
					                    		  System.out.println("error");
					                    		  writer.println("error");
					                    		  writer.close();
					                              System.exit(0);
					                    }  					                    
					                }
					             }
					            else
					            {
					            	System.out.println("error");
		                    		writer.println("error");
		                    		writer.close();
					            	System.exit(0);
					            }
					         }
							
							else
							{
								System.out.println("error");
	                    		writer.println("error");
	                    		writer.close();
								System.exit(0);
							}
							
							int employeeID = Integer.parseInt(employeeid);
							
							Employee employee = new Employee(name, address, licenseNumber, employeeID);
						
						 String methodNumber = scan.nextLine();
						
						 while(!methodNumber.equalsIgnoreCase("0"))					//Loops until we find a "0".
						 	{
							 switch(methodNumber)
							 {
							 case "1":														
							 {
								 System.out.println(employee.getName());
								 writer.println(employee.getName());
								 methodNumber = scan.nextLine();					//New method number input.
								 break;
							 } 
							 case "2":
							 {
								 System.out.println(employee.getAddress());
								 writer.println(employee.getAddress());
								 methodNumber = scan.nextLine();
								 break;
							 }
								 
							 case "3":
							 {
								 System.out.println(employee.getLicenseNumber());
								 writer.println(employee.getLicenseNumber());
								 methodNumber = scan.nextLine();
								 break;
							 }
								 
							 case "4":
							 {
								 System.out.printf("%08d\n",employee.getEmployeeID());
								 writer.printf("%08d\n",employee.getEmployeeID());
								 methodNumber = scan.nextLine();
								 break;
							 }
							 
							 case "5":
							 {
								 String name1 = scan.nextLine();
								 employee.setName(name1);
								 methodNumber = scan.nextLine();
								 break;
							 }
							 
							 case "6": 
							 {
								 String newAddress = scan.nextLine();
								 employee.setAddress(newAddress);
								 methodNumber = scan.nextLine();
								 break;
							 }
							 
							 case "7":
							 { 
								 String newLicenseNumber = scan.nextLine();
								 employee.setLicenseNumber(newLicenseNumber);
								 methodNumber = scan.nextLine();
								 break;
							 }
								 
							 case "8":
							 {
								 String employeeidi = scan.nextLine();
								 if(employeeidi.length() > 8)
									{
										System.out.println("error");
										writer.println("error");
										writer.close();
										System.exit(0);
									}
								 else 
								 {
								 int employeeIDI = Integer.parseInt(employeeidi);
								 employee.setEmployeeID(employeeIDI);
								 methodNumber = scan.nextLine();
								 }
								 break;
							 }
							 
							 default:
							 	{
							 		try 
							 		{
							 			throw new Exception("error");
							 		}
							 		catch(Exception e)
							 		{
							 			System.out.println("error");
							 			writer.println("error");
							 			writer.close();
							 			System.exit(0);
							 		}
							 	}
							 }
							}
						 	break;
							}
						 }
						 
						 break;
						}
					
						case "Customer":
						{
						String constructorType  = scan.nextLine();
						switch(constructorType)
						{
							
						case "1":
						{
							String name = scan.nextLine();
							String address = scan.nextLine();
							String licenseNumber = scan.nextLine();
							
							if (licenseNumber.length() == 8 && Character.isLetter(licenseNumber.charAt(0)) && Character.isLetter(licenseNumber.charAt(1))) 
							{
					            // Check if the first two characters are capitalized
					            if (Character.isUpperCase(licenseNumber.charAt(0)) && Character.isUpperCase(licenseNumber.charAt(1))) 
					            {
					                // Check if the remaining characters are digits
					                for (int i = 2; i < licenseNumber.length(); i++)
					                {
					                    if (!Character.isDigit(licenseNumber.charAt(i))) 
					                    {
					                    	System.out.println("error");
				                    		writer.println("error");
				                    		writer.close();
					                    	System.exit(0);
					                    }  					                    
					                }
					             }
					            else
					            {
					            	System.out.println("error");
		                    		writer.println("error");
		                    		writer.close();
					            	System.exit(0);
					            }
					         }
							
							else
							{
								System.out.println("error");
								writer.println("error");
								writer.close();
								System.exit(0);
							}
							
							Customer customer = new Customer(name, address, licenseNumber);
							
							String methodNumber = scan.nextLine();
							while (!methodNumber.equals("0"))
							{
								switch(methodNumber)
								{
								case "1":
									System.out.println(customer.getName());
									writer.println(customer.getName());
									methodNumber = scan.nextLine();
									break;
									
								case "2":
									System.out.println(customer.getAddress());
									writer.println(customer.getAddress());
									methodNumber = scan.nextLine();
									break;
									
								case "3":
									System.out.println(customer.getLicenseNumber());
									writer.println(customer.getLicenseNumber());
									methodNumber = scan.nextLine();
									break;
									
								case "4":
									String thisName = scan.nextLine();
									customer.setName(thisName);
									methodNumber = scan.nextLine();
									break;
									
								case "5":
									String thisAddress = scan.nextLine();
									customer.setAddress(thisAddress);
									methodNumber = scan.nextLine();
									break;
									
								case "6":
									String thisLicenseNumber = scan.nextLine();
									customer.setLicenseNumber(thisLicenseNumber);
									methodNumber = scan.nextLine();
									break;
									
								default:
								  {
									try 
									{
										throw new Exception("error");
									}
									catch(Exception e)
									{
										System.out.println("error");
										writer.println("error");
										writer.close();
										System.exit(0);
									}
									//break;
								  }
							    }
							}
							break;
						}
							
							}
						break;
						}
					
					
					case "Loan":
					{
						String constructorType = scan.nextLine();
						switch(constructorType)
						{
						case "1":
						{
							String name = scan.nextLine();
							Loan loan = new Loan(name);
							
							String methodNumber = scan.nextLine();
							
							while (!methodNumber.equals("0"))
							{
							switch(methodNumber)
							{
							case "1":
								System.out.printf("%.2f\n",loan.getAccountBalance());
								writer.printf("%.2f\n",loan.getAccountBalance());
								methodNumber = scan.nextLine();
								break;
							
							case "2":
								
								System.out.printf("%010d\n",loan.getAccountNumber());
								writer.printf("%010d\n",loan.getAccountNumber());
								methodNumber = scan.nextLine();
								
								break;
								
							case "3":
								System.out.println(loan.getAnnualInterestRate());
								writer.println(loan.getAnnualInterestRate());
								methodNumber = scan.nextLine();
								break;
								
							case "4":
								System.out.println(loan.getNumberOfYears());
								writer.println(loan.getNumberOfYears());
								methodNumber = scan.nextLine();
								break;
								
							case "5":
								System.out.println(loan.getLoanDate());
								writer.println(loan.getLoanDate());
								methodNumber = scan.nextLine();
								break;
							
							case "6":
								System.out.println(loan.getName());
								writer.println(loan.getName());
								methodNumber = scan.nextLine();
								break;
							
							case "7":
								String newAccBalance = scan.nextLine();
								double setAccBalance = Double.parseDouble(newAccBalance);
								loan.setAccountBalance(setAccBalance);
								methodNumber = scan.nextLine();
								break;
								
							case "8":
								String annIntRate = scan.nextLine();
								double setAnnualIntRate = Double.parseDouble(annIntRate);
								loan.setAnnualInterestRate(setAnnualIntRate);
								methodNumber = scan.nextLine();
								break;
								
							case "9":
								String noOfYears = scan.nextLine();
								int numOfYear = Integer.parseInt(noOfYears);
								loan.setNumberOfYears(numOfYear);
								methodNumber = scan.nextLine();
								break;
								
							case "10":
								System.out.printf("%.2f\n", loan.getMonthlyPayment());
								writer.printf("%.2f\n",loan.getMonthlyPayment());
								methodNumber = scan.nextLine();
								break;
								
							case "11":
								System.out.printf("%.2f\n", loan.getTotalPayment());
								writer.printf("%.2f\n",loan.getTotalPayment());
								methodNumber = scan.nextLine();
								break;
								
							default:
							  {
								try 
								{
									throw new Exception("error");
								}
								catch(Exception e)
								{
									System.out.println("error");
									writer.println("error");
									writer.close();
									System.exit(0);
								}
								break;
							  }
							}
							}
							break;
						}
						
						case "2":
						{
							String accNumber = scan.nextLine();
							String accBalance = scan.nextLine();
							String annualIntRate = scan.nextLine();
							String numOfYears = scan.nextLine();
							String name = scan.nextLine();
							
							if(accNumber.length()>10)
							{
								System.out.println("error");
								writer.println("error");
								writer.close();
								System.exit(0);
							}
							
							long accountNumber = Long.parseLong(accNumber);
							double annualInterestRate = Double.parseDouble(annualIntRate);
							double accountBalance = Double.parseDouble(accBalance);
							int numberOfYears = Integer.parseInt(numOfYears);
							
							Loan loan = new Loan(accountNumber, accountBalance, annualInterestRate, numberOfYears, name);
							
							String methodNumber = scan.nextLine();
							
							while (!methodNumber.equals("0"))
							{
							switch(methodNumber)
							{
							case "1":
								System.out.printf("%.2f\n",loan.getAccountBalance());
								writer.printf("%.2f\n",loan.getAccountBalance());
								methodNumber = scan.nextLine();
								break;
							
							case "2":
								System.out.printf("%010d\n",loan.getAccountNumber());
								writer.printf("%010d\n",loan.getAccountNumber());
								methodNumber = scan.nextLine();
								break;
								
							case "3":
								System.out.println(loan.getAnnualInterestRate());
								writer.println(loan.getAnnualInterestRate());
								methodNumber = scan.nextLine();
								break;
								
							case "4":
								System.out.println(loan.getNumberOfYears());
								writer.println(loan.getNumberOfYears());
								methodNumber = scan.nextLine();
								break;
								
							case "5":
								System.out.println(loan.getLoanDate());
								writer.println(loan.getLoanDate());
								methodNumber = scan.nextLine();
								break;
							
							case "6":
								System.out.println(loan.getName());
								writer.println(loan.getName());
								methodNumber = scan.nextLine();
								break;
							
							case "7":
								String newAccBalance = scan.nextLine();
								double setAccBalance = Double.parseDouble(newAccBalance);
								loan.setAccountBalance(setAccBalance);
								methodNumber = scan.nextLine();
								break;
								
							case "8":
								String annIntRate = scan.nextLine();
								double setAnnualIntRate = Double.parseDouble(annIntRate);
								loan.setAnnualInterestRate(setAnnualIntRate);
								methodNumber = scan.nextLine();
								break;
								
							case "9":
								String noOfYears = scan.nextLine();
								int numOfYear = Integer.parseInt(noOfYears);
								loan.setNumberOfYears(numOfYear);
								methodNumber = scan.nextLine();
								break;
								
							case "10":
								System.out.printf("%.2f\n", loan.getMonthlyPayment());
								writer.printf("%.2f\n",loan.getMonthlyPayment());
								methodNumber = scan.nextLine();
								break;
								
							case "11":
								System.out.printf("%.2f\n", loan.getTotalPayment());
								writer.printf("%.2f\n",loan.getTotalPayment());
								methodNumber = scan.nextLine();
								break;
								
							default:
							  {
								try 
								{
									throw new Exception("error");
								}
								catch(Exception e)
								{
									System.out.println("error");
									writer.println("error");
									writer.close();
									System.exit(0);
								}
								
							  }
							}
							}
						break;	
						}
						
						default:
						{
							try
							{
								throw new Exception("error");
							}
							
							catch(Exception e)
							{
								System.out.println("error");
								writer.println("error");
								writer.close();
								System.exit(0);
							}
						}
							 	 
						}
						break;
					}
					
					case "Checking":
					{
						String constructorType = scan.nextLine();
						switch(constructorType)
						{
						 case "1":
						 {
							 String annInterestRate = scan.nextLine();
							 double annualInterestRate = Double.parseDouble(annInterestRate);
							 String name = scan.nextLine();
							 
							 Checking checking = new Checking(annualInterestRate, name);
							 
							 String methodNumber = scan.nextLine();
							 
							 while(!methodNumber.equals("0"))
							 {
								 switch(methodNumber)
								 {
								 case "1":
									 {System.out.printf("%.2f\n",checking.getAccountBalance());
									 writer.printf("%.2f\n",checking.getAccountBalance());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "2":
									 {System.out.printf("%010d\n",checking.getAccountNumber());
									 writer.printf("%010d\n",checking.getAccountNumber());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "3":
									 {String accBalance = scan.nextLine();
									 double newAccBalance = Double.parseDouble(accBalance);
									 checking.setAccountBalance(newAccBalance);
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "4":
									 {System.out.printf("%.2f\n",checking.getAnnualInterestRate());
									 writer.printf("%.2f\n",checking.getAnnualInterestRate());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "5":
									 {System.out.println(checking.getName());
									 writer.println(checking.getName());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "6":
									 {String annIntRate = scan.nextLine();
									 double annualIntRate = Double.parseDouble(annIntRate);
									 checking.setAnnualInterestRate(annualIntRate);
									 break;}
									 
								 case "7":
									 {String amount = scan.nextLine();
									 double amountDeposited = Double.parseDouble(amount);
									 checking.makeDeposit(amountDeposited);
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "8":
									 {String amount2 = scan.nextLine();
									 double amountWithdraw = Double.parseDouble(amount2);
									 if(amountWithdraw > checking.getAccountBalance() + 1)			//If error found, we exit.
									 {
										 System.out.println("overdraft");
										 writer.println("overdraft");
										 writer.close();
										 System.exit(0);
									 }
									 else
									 {
										 checking.makeWithdrawal(amountWithdraw);
									 }
									 methodNumber = scan.nextLine();
									 break;}
									 
								 default:
								 {
									 try
									 {
										 throw new Exception("error");
									 }
									 catch(Exception e)
									 {
										 System.out.println("error");
										 writer.println("error");
										 System.exit(0);
									 }
								 }
								 }
							 }
							 break;
						 }
						 
						 case "2":
						 {
							 String accNo = scan.nextLine();
							 String accBalance = scan.nextLine();
							 String annInterestRate = scan.nextLine();
							 String name = scan.nextLine();
							 
							 if(accNo.length()>10)
							 {
								 System.out.println("error");
								 writer.println("error");
								 writer.close();
								 System.exit(0);
							 }
							 
							 double annualInterestRate = Double.parseDouble(annInterestRate);
							 double accountBalance = Double.parseDouble(accBalance);
							 long accountNumber = Long.parseLong(accNo);
							 
							 Checking checking = new Checking(annualInterestRate, accountBalance, accountNumber, name);
							 String methodNumber = scan.nextLine();
							 
							 while(!methodNumber.equals("0"))
							 {
								 switch(methodNumber)
								 {
								 case "1":
									 {System.out.printf("%.2f\n",checking.getAccountBalance());
									 writer.printf("%.2f\n",checking.getAccountBalance());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "2":
									 {System.out.printf("%010d\n",checking.getAccountNumber());
									 writer.printf("%010d\n",checking.getAccountNumber());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "3":
									 {String accBalance1 = scan.nextLine();
									 double newAccBalance = Double.parseDouble(accBalance1);
									 checking.setAccountBalance(newAccBalance);
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "4":
									 {System.out.printf("%.2f\n",checking.getAnnualInterestRate());
									 writer.printf("%.2f\n",checking.getAnnualInterestRate());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "5":
									 {System.out.println(checking.getName());
									 writer.println(checking.getName());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "6":
									 {String annIntRate = scan.nextLine();
									 double annualIntRate = Double.parseDouble(annIntRate);
									 checking.setAnnualInterestRate(annualIntRate);
									 break;}
									 
								 case "7":
									 {String amount = scan.nextLine();
									 double amountDeposited = Double.parseDouble(amount);
									 checking.makeDeposit(amountDeposited);
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "8":
									 {String amount2 = scan.nextLine();
									 double amountWithdraw = Double.parseDouble(amount2);
									 if(amountWithdraw > checking.getAccountBalance() + 1)
									 {
										 System.out.println("overdraft");
										 writer.println("overdraft");
										 writer.close();
										 System.exit(0);
									 }
									 else
									 {
										 checking.makeWithdrawal(amountWithdraw);
									 }
									 methodNumber = scan.nextLine();
									 break;}
									 
								 default:
								 {
									 try
									 {
										 throw new Exception("error");
									 }
									 catch(Exception e)
									 {
										 System.out.println("error");
										 writer.println("error");
										 System.exit(0);
									 }
								 }
								 }
								 
									 
							 }
							 break;
							 }
							 
						 }
						break;
						}
					
					case "Savings":
					{
						String constructorType = scan.nextLine();
						switch(constructorType)
						{
						 case "1":
						 {
							 String annInterestRate = scan.nextLine();
							 double annualInterestRate = Double.parseDouble(annInterestRate);
							 String name = scan.nextLine();
							 
							 Savings savings = new Savings(annualInterestRate, name);
							 
							 String methodNumber = scan.nextLine();
							 
							 while(!methodNumber.equals("0"))
							 {
								 switch(methodNumber)
								 {
								 case "1":
									 System.out.printf("%.2f\n",savings.getAccountBalance());
									 writer.printf("%.2f\n",savings.getAccountBalance());
									 methodNumber = scan.nextLine();
									 break;
									 
								 case "2":
									 System.out.println(savings.getAccountNumber());
									 writer.println(savings.getAccountNumber());
									 methodNumber = scan.nextLine();
									 break;
									 
								 case "3":
									 String accBalance = scan.nextLine();
									 double newAccBalance = Double.parseDouble(accBalance);
									 savings.setAccountBalance(newAccBalance);
									 methodNumber = scan.nextLine();
									 break;
									 
								 case "4":
									 System.out.printf("%.2f\n",savings.getAnnualInterestRate());
									 writer.printf("%.2f\n",savings.getAnnualInterestRate());
									 methodNumber = scan.nextLine();
									 break;
									 
								 case "5":
									 System.out.println(savings.getName());
									 writer.println(savings.getName());
									 methodNumber = scan.nextLine();
									 break;
									 
								 case "6":
									 String annIntRate = scan.nextLine();
									 double annualIntRate = Double.parseDouble(annIntRate);
									 savings.setAnnualInterestRate(annualIntRate);
									 break;
									 
								 case "7":
									 String amount = scan.nextLine();
									 double amountDeposited = Double.parseDouble(amount);
									 savings.makeDeposit(amountDeposited);
									 methodNumber = scan.nextLine();
									 break;
									 
								 case "8":
									 String amount2 = scan.nextLine();
									 double amountWithdraw = Double.parseDouble(amount2);
									 if(amountWithdraw > savings.getAccountBalance())
									 {
										 System.out.println("overdraft");
										 writer.println("overdraft");
										 writer.close();
										 System.exit(0);
									 }
									 else
									 {
										 savings.makeWithdrawal(amountWithdraw);
									 }
									 methodNumber = scan.nextLine();
									 break;
									 
								 default:
								 {
									 try
									 {
										 throw new Exception("error");
									 }
									 catch(Exception e)
									 {
										 System.out.println("error");
										 writer.println("error");
										 System.exit(0);
									 }
								 }
								 }
							 }
							 break;
						 }
						 
						 case "2":
						 {
							 String accNo = scan.nextLine();
							 String accBalance = scan.nextLine();
							 String annInterestRate = scan.nextLine();
							 String name = scan.nextLine();
							 
							 double annualInterestRate = Double.parseDouble(annInterestRate);
							 double accountBalance = Double.parseDouble(accBalance);
							 long accountNumber = Long.parseLong(accNo);
							 
							 Savings savings = new Savings(accountNumber, accountBalance, annualInterestRate, name);
							 String methodNumber = scan.nextLine();
							 
							 while(!methodNumber.equals("0"))
							 {
								 switch(methodNumber)
								 {
								 case "1":
									 {System.out.printf("%.2f\n",savings.getAccountBalance());
									 writer.printf("%.2f\n ",savings.getAccountBalance());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "2":
									 {System.out.printf("%010d\n",savings.getAccountNumber());
									 writer.printf("%010d\n",savings.getAccountNumber());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "3":
									 {String accBalance1 = scan.nextLine();
									 double newAccBalance = Double.parseDouble(accBalance1);
									 savings.setAccountBalance(newAccBalance);
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "4":
									 {System.out.printf("%.2f\n",savings.getAnnualInterestRate());
									 writer.printf("%.2f\n",savings.getAnnualInterestRate());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "5":
									 {System.out.println(savings.getName());
									 writer.println(savings.getName());
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "6":
									 {String annIntRate = scan.nextLine();
									 double annualIntRate = Double.parseDouble(annIntRate);
									 savings.setAnnualInterestRate(annualIntRate);
									 break;}
									 
								 case "7":
									 {String amount = scan.nextLine();
									 double amountDeposited = Double.parseDouble(amount);
									 savings.makeDeposit(amountDeposited);
									 methodNumber = scan.nextLine();
									 break;}
									 
								 case "8":
									 {String amount2 = scan.nextLine();
									 double amountWithdraw = Double.parseDouble(amount2);
									 if(amountWithdraw > savings.getAccountBalance())
									 {
										 System.out.println("overdraft");
										 writer.println("overdraft");
										 writer.close();
										 System.exit(0);
									 }
									 else
									 {
										 savings.makeWithdrawal(amountWithdraw);
									 }
									 methodNumber = scan.nextLine();
									 break;}
									 
								 default:
								 {
									 try
									 {
										 throw new Exception("error");
									 }
									 catch(Exception e)
									 {
										 System.out.println("error");
										 writer.println("error");
										 System.exit(0);
									 }
								 }
								 }
							 }
							 break;
							 }
							 
						 }
						break;
						}
					
					default:
					{
						 try
						 {
							 throw new Exception("error");
						 }
						 catch(Exception e)
						 {
							 System.out.println("error");
							 writer.println("error");
							 System.exit(0);
						 }
					 }
					
					}
				}
			}
			scan.close();
		}
		
		catch (FileNotFoundException e) 
		{
		System.out.println("error");
		}
	}
}