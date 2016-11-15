public class JobShareEmployee extends SalaryEmployee
{
/*
	Joseph Krambeer
	Date
	Description
*/

private double percentWorked;

public JobShareEmployee(String last, String first, String middle, double yearSalary, double percentageWorked)
{
	super(last,first,middle,yearSalary);
	this.percentWorked= percentageWorked;
}//five parameter constructor

public JobShareEmployee(String last, String first, double yearSalary, double percentageWorked)
{
	this(last,first,"",yearSalary,percentageWorked);
}//four parameter constructor

public JobShareEmployee(String last, double yearSalary, double percentageWorked)
{
	this(last,"","",yearSalary,percentageWorked);
}//three parameter constructor


public double getPercentWorked(){return this.percentWorked/100;}


}//class