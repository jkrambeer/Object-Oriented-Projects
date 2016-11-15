import java.io.*;
public class FortuneCookie extends UnsolicitatedAdvice
{
/*
	Joseph Krambeer
	10-14-14

	*Constuctors
		FortuneCookie(String[])
			passes the UnsolicitatedAdvice
			constructor a string arrray with
			super that is used to construct
			the object

		FortuneCookie(File)
			passes the UnsolicitatedAdvice
			constructor a file object with
			super that is used to construct
			the object

	*Methods
		getAdviceGiverName()
			returns a string that contains the
			advice giver name which in this
			case if Fortune-Cookie

	*Modification History:
		October 14, 2014
			Original Version
*/

public FortuneCookie(String[] advice)
{
	super(advice);
}//constructor

public FortuneCookie(File inputFile)
{
	super(inputFile);
}//constructor

public String getAdviceGiverName()
{
	return "Fortune-Cookie";
}


}//class