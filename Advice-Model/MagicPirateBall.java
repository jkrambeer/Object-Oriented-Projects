public class MagicPirateBall extends MagicEightBall
{
/*
	Joseph Krambeer
	10-14-14

	A class to model the cutting edge new
	invention of the MagicPirateBall™

	*Class Variables
		prefix
			an unchanging string array that
			holds all the pirate talk used
			as a prefix when making the
			MagicPirateBall

		suffix
			an unchanging string array that
			holds all the pirate talk used
			as a suffix when making the
			MagicPirateBall

	*Constuctors
		MagicPirateBall
			a no parameter constuctor that calls
			the MagicEightBall constructor with super

	*Methods
		public String getAdvice()
			this returns the advice held within the
			advice variable as a string with the
			addition of pirate talk prefixes and suffixes

		public String getAdviceGiverName()
			returns a string that is the name of the advice
			giver, which in this case is MagicPirateBall

		private String getPirateTalk()
			returns a 2 element String array whose first
			element is the pirate prefix and the second
			element is the pirate suffix. The elements
			are chosen randomly

	*Modification History:
		October 14, 2014
			Original Version

*/

private static final String[] prefix= new String[]{
				new String("Aaarrrrghhh. "),
  				new String("Yarrrg me matey. "),
  				new String("Swab the poopdeck. "),
  				new String("Draw ye scimitars. "),
  				new String("Yer gonna walk da plank. "),
				new String("Yohoho and a bottle of rum. ") };

private static final String[] suffix = new String[]{
				new String(" *Generic explicitives*."),
  				new String(" Yaaaarg."),
  				new String(" Matey."),
  				new String(" Aaaaaaarrrghhhh."),
  				new String(" What do you mean the rums gone?"),
				new String(" Aaaaaaaaaaarrrrrrrgghhhhhhh.") };



public MagicPirateBall()
{
	super();
}//constructor

public String getAdvice()
{
	return getPirateTalk()[0] + super.getAdvice()+ "." + getPirateTalk()[1];
}//getAdvice

public String getAdviceGiverName()
{
	return "The MagicPirateBall";
}//getAdviceGiverName

private String[] getPirateTalk()
{
	return new String[]{prefix[(int)Math.floor(Math.random()*prefix.length)],suffix[(int)Math.floor(Math.random()*suffix.length)]};
}//getPirateTalk



}//class