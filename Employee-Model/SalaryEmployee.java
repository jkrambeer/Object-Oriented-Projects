public class SalaryEmployee extends Employee
{
/*
	Joseph Krambeer
	Date
	Description
*/

private double annualSalary;

/*
public SalaryEmployee(double yearSalary, String theCompany)
*/

public SalaryEmployee(String last, String first, String middle, double yearSalary)
{
	super(last,first,middle);
	this.annualSalary=yearSalary;
}// four parameter constructor

public SalaryEmployee(String last, String first, double yearSalary)
{
	this(last,first,"",yearSalary);
}// three parameter constructor

public SalaryEmployee(String last,double yearSalary)
{
	this(last,"","",yearSalary);
}// two parameter constructor


public double getPercentWorked(){return 1;}

public double getWeeklyPay(){return this.annualSalary*this.getPercentWorked()/52;}

}//class