abstract public class SolicitatedAdvice extends Advice
{
/*
	Joseph Krambeer
	10-14-14

	This class is the parent class to MagicEightBall and
	MagicPirateBall

	*Constructors:
		SolicitatedAdvice(String[])
			this passes the input string to
			the advice constructor with the
			super call in the function

	*Methods
		getAdviceType()
			returns a string that tells what
			kind of advice this is, and in this
			instance is solicitated

	*Modification History:
		October 14, 2014
			Original Version
*/

public SolicitatedAdvice(String[] advice)
{
	super(advice);
}//constructor

public String getAdviceType()
{
	 return "Solicitated";
}

}//class