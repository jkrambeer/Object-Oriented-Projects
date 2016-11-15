import java.io.*;
public class ParentalAdvice extends UnsolicitatedAdvice
{
/*
	Joseph Krambeer
	10-14-14

	*Constuctors
		ParentalAdvice(String[])
			passes the UnsolicitatedAdvice
			constructor a string arrray with
			super that is used to construct
			the object

		ParentalAdvice(File)
			passes the UnsolicitatedAdvice
			constructor a file object with
			super that is used to construct
			the object

	*Methods
		getAdviceGiverName()
			returns a string that contains the
			advice giver name which in this
			case if Your Parent

	*Modification History:
		October 14, 2014
			Original Version
*/

public ParentalAdvice(String[] advice)
{
	super(advice);
}//constructor

public ParentalAdvice(File inputFile)
{
	super(inputFile);
}//constructor

public String getAdviceGiverName()
{
	return "Your parent";
}


}//class