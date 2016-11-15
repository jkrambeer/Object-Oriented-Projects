import java.io.*;
abstract public class UnsolicitatedAdvice extends Advice
{
/*
	Joseph Krambeer
	10-14-14

	*Constructors:
		UnsolicitatedAdvice(String[])
			this passes the input string to
			the advice constructor with the
			super call in the function

		UnsolicitatedAdvice(File)
			this passes the input file to
			the advice constructor with the
			super call in the function

	*Methods
		getAdviceType()
			returns a string that tells what
			kind of advice this is, and in this
			instance is unsolicitated

	*Modification History:
		October 14, 2014
			Original Version

*/

public UnsolicitatedAdvice(String[] advice)
{
	super(advice);
}//constructor

public UnsolicitatedAdvice(File inputFile)
{
	super(inputFile);
}//constructor

public String getAdviceType()
{
	 return "Unsolicitated";
}

}//class