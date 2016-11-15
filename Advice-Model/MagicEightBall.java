public class MagicEightBall extends SolicitatedAdvice
{
/*
	Joseph Krambeer
	10-14-14

	This class models a MagicEightBall and gives
	responses like it was a MagicEightBall™

	*Constructors:
		MagicEightBall()
			a no parameter constuctor that when
			calls passes a string array of
			magic-eight-ball responses to the
			SolicitatedAdvice constructor
			with its super call.

	*Methods
		public String getAdviceGiverName()
			returns a string that respresents
			the name of the advice giver which
			in this case is MagicEightBall

	*Modification History:
		October 14, 2014
			Original Version

*/

public MagicEightBall()
{

	super(      new String[]{
 				new String("It is certain"),
  				new String("It is decidedly so"),
  				new String("Without a doubt"),
  				new String("Yes definitely"),
  				new String("You may rely on it"),
  				new String("As I see it, yes"),
  				new String("Most likely"),
  				new String("Outlook good"),
  				new String("Yes"),
  				new String("Signs point to yes"),
  				new String("Reply hazy try again"),
  				new String("Ask again later"),
  				new String("Better not tell you now"),
  				new String("Cannot predict now"),
				new String("Concentrate and ask again"),
				new String("Don't count on it"),
				new String("My reply is no"),
				new String("My sources say no"),
				new String("Outlook not so good"),
				new String("Very doubtful") } );
}//constructor

public String getAdviceGiverName()
{
	return "The MagicEightBall";
}

}//class