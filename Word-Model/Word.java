import java.util.*;

public class Word implements Comparable<Word>
{
/*
	Joseph Krambeer
	10-8-14

	A model of an English word and the various aspects of words

	*Class Variables:
		word
			A string that holds an English
			word that is a validly constructed.

	*Constructors:
		Word(String word)
			a function that takes a string
			and checks to see if the string
			is a valid English word, trims
			whitespaces and then makes the
			model of a word.

	*Methods:

		public boolean contains(String input, boolean exactOrder)
			returns a boolean based on if the
			passed string is contained in the
			word object and checks for order
			with an input boolean of true
			and doesn't care about order
			if the input boolean if false

		public String getWord()
			Returns the word referenced
			Word object as a string.

		public String getLetterSet()
			returns a string that contains
			a copy of the letters that
			are contained within the reference
			word, and these letters only
			appear one time in the string.

		public boolean isAnagramOf(Word other)
			returns a boolean depending on if
			the referenced word is a boolean
			of the the input word. Returns
			false for words that are exactly
			the same.

		public boolean isEqualTo(Word/String other, boolean isCaseSensetive)
			checks a word or a string against
			another variable of the same type
			and tells if they are the equal.
			If case sensetivity not specified
			it is set to be case sensetive.

		public int numberOf()
			counts the number of passed elements
			like apostrophes, vowels, characters,
			hyphens, and consonants in referenced
			word. Uses countThese() function.

		public Word reverse()
			returns a word that is a reverse of
			the word object that was referenced.

		public boolean sameLetterSetAs(Word other)
			returns a boolean based on if the two
			words are constructed of the same
			letter set or not.

	*Modification History:
		October 6th, 2014
			Original Version

		October 16th, 2014
			Removed need to have vowels when making
			word, words can now be anagrams of themselves,
			added function contains to check if a string
			is contained in a word whether in order passed
			or not in order passed.

*/

private String  word;
private int[]   letterCount;
private int     bitMap;

public Word(String word)
{
	String copy;
	int    loc;
	int[]  array;

	if(word==null)
	{
		throw new IllegalArgumentException("The parameter passed is null.");
	}

	word.trim();

	if(word.length()==0)
	{
		throw new IllegalArgumentException("The parameter passed has 0 non-white characters.");
	}

	if(word.substring(0,1)==("-") || word.substring(word.length()-1,word.length()).equals("-"))
	{
		throw new IllegalArgumentException("Word cannot start or end with a hyphen");
	}

	if(word.indexOf("--")>=0)
	{
		throw new IllegalArgumentException("There cannot be two consecutive hyphens in a word");
	}

	if(word.indexOf("''")>=0)
	{
		throw new IllegalArgumentException("There cannot be two consecutive apostrophes in a word");
	}

	this.word=word.trim();

	if( (this.word.length() ) > (numberOfVowels()+numberOfConsonants()+numberOfHyphens()+numberOfApostrophes() ) )
	{
		throw new IllegalArgumentException("Words can only contain symbols from the alphabet or hyphens");
	}

	// note the new additions in state and functionality in constructor

	array = new int[26];
	copy=this.word.toLowerCase();
	this.bitMap=0;

	for(int i=0;i<copy.length();i++)
	{
		loc="abcdefghijklmnopqrtuvwxyz".indexOf(copy.charAt(i));
		if(loc<array.length && loc>=0){array[loc]=array[loc]+1;}
		this.bitMap=this.bitMap|(1<<loc);
	}

	this.letterCount = array;

}//constructor to build the private word

public int compareTo(Word other)//implementing compareTo
{
	return (this.getWord()).compareTo(other.getWord());//this could be improved still
}

public boolean contains(String input)
{
	return contains(input,true);
}//contains

public boolean contains(String input, boolean exactOrder)
{
	boolean result;
	if(exactOrder)
	{
		result = false;
		if(this.getWord().toLowerCase().indexOf(input.toLowerCase())>=0){result=true;}
	}//exactOrder
	else
	{
		result = true;
		for(int i=0;i<input.length();i++)
		{
			if(this.getWord().toLowerCase().indexOf(input.substring(i,i+1).toLowerCase())<0 ){result=false;}
		}
	}//else
	return result;
}//contains

public String getWord(){return this.word;}//getWord

public String getLetterSet()
{
	//returning a string that has char contained within the word appearing one time
	String letterSet;

	letterSet="- '";//set to find things that aren't letters
	for(int i=0;i<this.getWord().length();i++)
	{
		if(letterSet.indexOf( this.getWord().substring(i,i+1).toLowerCase() )<0)
		{
			letterSet=letterSet+ this.getWord().substring(i,i+1).toLowerCase();//adds only things it does not find in letterSet
		}
	}
	return letterSet.substring(3,letterSet.length() );//to take away things that aren't letters
}//getLetterSet

public boolean isAnagramOf(Word other)
{
	//checking a word to see if it is an anagram of the parameter word -edited make not of this in comments
	if(other==null){throw new IllegalArgumentException("The parameter passed is null.");}

	boolean  anagram;
    anagram = true;
    if(this.bitMap==other.bitMap)
    {
		if(areSameLength(this.word,other.word))
		{
				if( !(Arrays.equals(this.letterCount,other.letterCount)) ){anagram=false;}
		}//sameLength
		else
		{
			anagram = false;
		}
	}//bitMap
	else
	{
		anagram = false;
	}

	return anagram;
}//isAnagramOf

public boolean isEqualTo(Word other, boolean isCaseSensetive)
{
	//testing to see if two Words are identical, can be case sensetive/insensetive
	if(other==null){throw new IllegalArgumentException("word.isEqualTo: parameter is null");}

	int identical;

	if(isCaseSensetive)
	{
		identical = this.getWord().compareTo(other.getWord());
	}
	else
	{
		identical = this.getWord().compareToIgnoreCase(other.getWord());
	}
	return (identical==0);
}//isEqualTo (main function)

public boolean isEqualTo(String other, boolean isCaseSensetive)
{
	//testing to see if two Strings are identical, can be case sensetive/insensetive
	Word otherWord;
	boolean result;
	if(other==null){throw new IllegalArgumentException("word.isEqualTo: parameter is null");}
	try
		{
			otherWord=new Word(other);
			result = isEqualTo(otherWord, isCaseSensetive);
		}
	catch(IllegalArgumentException iae){result=false;}//if illegalArgumentException thrown during construction it will just set it false
	return result;
}//isEqualTo (secondary String method)

public boolean isEqualTo(Word other)
{
	if(other==null){throw new IllegalArgumentException("word.isEqualTo: parameter is null");}
	return this.isEqualTo(other, true);
}//isEqualTo

public boolean isEqualTo(String other)
{
	if(other==null){throw new IllegalArgumentException("word.isEqualTo: parameter is null");}
	return this.isEqualTo(other, true);
}//isEqualTo

public boolean isPalindrome()
{
	//checking to see if a word is the same reversed as it is normally
	boolean palindrome;
	palindrome=true;
	for(int i = 0;i<getWord().length();i++)
	{
		if(this.getWord().charAt(i)!=this.getWord().charAt(numberOfCharacters()-1-i) ){palindrome=false;}
	}
	return palindrome;

}//isPalindrome

public int numberOfApostrophes(){return countThese("'");}//numberOfApostrophes

public int numberOfCharacters(){return this.getWord().length();}//numberOfCharacters

public int numberOfConsonants(){return countThese("bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ");}//numberOfConsonants

public int numberOfHyphens(){return countThese("-");}//numberOfHyphens

public int numberOfVowels(){return countThese("aeiouyAEIOUY");}//numberOfVowels

public Word reverse()
{
	//reversing a word variable
	Word   result;
	String reverse;

	reverse = "";
	for(int i = 0;i<getWord().length();i++)
	{
		reverse = reverse + getWord().charAt( numberOfCharacters()-i-1 );
	}
	result = new Word(reverse);
	return result;
}//reverseLetterOrder

public boolean sameLetterSetAs(Word other)
{
	//checking if the reference Word and the passed word contain the same letterset -edited make note of this
	if(other==null){throw new IllegalArgumentException("sameLetterSetAs: parameter is null");}

	return (this.bitMap==other.bitMap);
}//sameLetterSetAs (probably can improve too)


//----PrivateMethods------

private int countThese(String countThis)
{
	//counting the passed string and returning how many times it appears
	if(countThis==null){throw new IllegalArgumentException("word.isEqualTo: parameter is null");}

	int    count;
	String word;

	word = this.getWord();
	count = 0;
	for(int i=0;i<word.length();i++)
	{
		if(countThis.indexOf(word.charAt(i))>=0)
		{
			count=count+1;
		}
	}//this loops ups count when what you were looking for was found in the referenced word
	return count;
}//countThese

private boolean areSameLength(String input1, String input2)
{
	//added in make note of this
	String firstWord;
	String secondWord;

	firstWord= "";
	secondWord= "";
	for(int i=0;i<input1.length();i++)
	{
		if( "-'".indexOf(input1.substring(i,i+1))>=0){firstWord=firstWord+input1.substring(i,i+1);}
	}
	for(int i=0;i<input2.length();i++)
	{
		if("-'".indexOf(input2.substring(i,i+1))>=0){secondWord=secondWord+input2.substring(i,i+1);}
	}
	return ( firstWord.length()==secondWord.length()  );
}//areSameLength

private int countThis(String countThis,String checkThis)
{
	//counting the passed string and returning how many times it appears
	if(countThis==null){throw new IllegalArgumentException("word.isEqualTo: parameter is null");}

	int    count;

	count = 0;
	for(int i=0;i<checkThis.length();i++)
	{
		if(countThis.indexOf(checkThis.charAt(i))>=0)
		{
			count=count+1;
		}
	}//this loops ups count when what you were looking for was found in the referenced word
	return count;
}//countThis

}//class