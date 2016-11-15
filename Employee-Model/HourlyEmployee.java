public class HourlyEmployee extends Employee
{
/*
	Joseph Krambeer
	Date
	Description
*/

private double payRate;
private double hoursWorked;

public HourlyEmployee(String last, String first, String middle, double salaryRate, double hrWorked)
{
	super(last,first,middle);
	this.payRate=salaryRate;
	this.hoursWorked=hrWorked;
}

public HourlyEmployee(String last, String first, double salaryRate, double hrWorked)
{
	this(last,first,"",salaryRate,hrWorked);
}

public HourlyEmployee(String last, double salaryRate, double hrWorked)
{
	this(last,"","",salaryRate,hrWorked);
}


public double getWeeklyPay()
{
	return this.payRate*this.hoursWorked;
}

}//class