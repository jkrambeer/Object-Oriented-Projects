public class Name
{
/*
	Joseph Krambeer
	Date
	Description
*/

private String lastName;
private String firstName;
private String middleName;

public Name(String last, String first, String middle)
{
	if(last==null || first==null || middle==null){throw new IllegalArgumentException("A passed parameter is null");}
	this.lastName=last;
	this.firstName=first;
	this.middleName=middle;
}//three parameter constructor

public Name(String last, String first)
{
	this(last,first,"");
}//two parameter constructor

public Name(String last)
{
	this(last,"","");
}//one parameter constuctor

public String getFullName()
{
	return this.lastName+", "+this.firstName+" "+this.middleName;
}

public String getLastName()
{
	String copy;
	copy = this.lastName;
	return copy;
}

public String getFirstName()
{
	String copy;
	copy = this.firstName;
	return copy;
}

public String getMiddleName()
{
	String copy;
	copy = this.middleName;
	return copy;
}

public void changeLastName(String newName){this.lastName=newName;}

public void changeFirstName(String newName){this.firstName=newName;}

public void changeMiddleName(String newName){this.middleName=newName;}



}//class