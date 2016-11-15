import java.util.*;

public class Driver
{
/*
	Joseph Krambeer
	Date
	Description
*/

public static void main(String[] args)
{
	PayInformation[] test2 = new PayInformation[]{new JobShareEmployee("Smith",30000,10),
												  new JobShareEmployee("Smith","Will","Bobby",45750,90),
												  new JobShareEmployee("Smith","Will","Zechariah",52000,90),
									 			  new JobShareEmployee("Smith","Will",20000,90),
											 	  new Consultant("Smith Inc.",13000),
											 	  new Consultant("Bob Inc.",14500),
											 	  new Consultant("Smith Inc.",10000),
											 	  new SalaryEmployee("Longsman","Jeff","Ugh",24000),
											 	  new SalaryEmployee("Jarad","Billy",36000),
											 	  new HourlyEmployee("Doe","John",17.50,40),
											 	  new HourlyEmployee("Doe","John","Smith",19.50,30)};
	//sorting needs to be implemented, overload compareTo so you can compare the objects


	PayInformation[] copy;

	Arrays.sort(test2);//el problemo

	copy = test2.clone();

	System.out.println("Orignal Sorted");
	for(int i=0;i<test2.length;i++)
	{
			System.out.println(test2[i].getFullName());
			System.out.println("$"+test2[i].getWeeklyPay());
			//System.out.println();
	}

	System.out.println();
	test2[0]= test2[0] = new JobShareEmployee("Smith","Jumbo","Jet",30000,10);
	System.out.println("Copy");
	for(int i=0;i<copy.length;i++)
	{
				System.out.println(copy[i].getFullName());
				System.out.println("$"+copy[i].getWeeklyPay());
	}

	System.out.println();
	System.out.println("Orignal Modified");
	for(int i=0;i<test2.length;i++)
	{
				System.out.println(test2[i].getFullName());
				System.out.println("$"+test2[i].getWeeklyPay());
	}

}//main



}//class