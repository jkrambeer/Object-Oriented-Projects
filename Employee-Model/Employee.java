abstract public class Employee implements Comparable<PayInformation>, Cloneable, PayInformation
{
/*
	Joseph Krambeer
	Date
	Description
*/

private Name name;

public Employee(String last, String first, String middle)
{
	if(last==null || first==null || middle==null){throw new IllegalArgumentException("A passed parameter is null");}
	this.name= new Name(last,first,middle);
}

public int compareTo(Employee other)
{
	//use last names 1st, then if the same: compare first names, if same: finally check middle names
	int difference;
	difference = this.name.getLastName().compareTo(other.name.getLastName());
	if(difference==0){difference=this.name.getFirstName().compareTo(other.name.getFirstName());}//only is same last
	if(difference==0){difference=this.name.getMiddleName().compareTo(other.name.getMiddleName());}//only if same first
	return difference;
}

public int compareTo(PayInformation other)
{
	return this.getFullName().compareTo(other.getFullName());
}

public Object clone() throws CloneNotSupportedException
{
	Employee object;
	Name clone;
	object=(Employee)super.clone();
	clone = new Name(this.name.getLastName(),this.name.getFirstName(),this.name.getMiddleName() );
	//the new name object is made so that the clone and the original can't change the other's mutable name object
	object.name= clone;
	return object;
}

public String getFullName()
{
	return this.name.getFullName();
}

abstract public double getWeeklyPay();

}//class