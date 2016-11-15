public class Consultant implements Comparable<PayInformation>, PayInformation, Cloneable
{
/*
	Joseph Krambeer
	Date
	Description
*/

private String company;
private double annualPay;

public Consultant(String companyName, double annualPay)
{
	if(companyName==null){throw new IllegalArgumentException("Message 'ere");}
	this.company=companyName;
	this.annualPay= annualPay;
}//three parameter constructor

public Object clone() throws CloneNotSupportedException
{
	return (Consultant)super.clone();
}

public String getFullName()
{
	String copy;
	copy = this.company;
	return copy;
}

public double getWeeklyPay()
{
	return this.annualPay/52;
}

public int compareTo(PayInformation other)
{
	return this.getFullName().compareTo(other.getFullName());
}


}//class