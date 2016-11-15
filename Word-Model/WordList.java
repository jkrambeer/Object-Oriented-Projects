import java.util.*;

public class WordList
{
/*
	Joseph Krambeer
	10-8-14

	A class for modeling a list of words and comparing them to other words

	*Class Variables:
		words
			an array that holds a reference
			to many Word objects.

	*Constructors:
		WordList()
			creates a wordList of zero length
			if not input was given to the
			constructor.

		WordList(Word[] words)
			creates a new array of Words and
			stores them into the WordList
			array if they are not null.

	*Methods:
		private Word[] getWords()
			returns the wordList associated
			with the referenced object.

		public void addWord(Word word)
			adds passed word into the
			referenced wordList array
			by expanding it and adding
			the word at the end of the array.

		public boolean contains(Word word)
			returns a boolean based on
			if the wordList has a certain
			word contained in it.

		public Word[] getAllWord()
			returns a copy of the current
			words variable that cannot
			change the words variable.

		public Word[] getAnagramsOf(Word word)
			returns a word array of words
			that are anagrams of the passed
			word.

		public Word[] getLongestWords()
			returns the word(s) that are
			longest in length within the
			wordList object that was
			referenced.

		public Word[] getShortestWords()
			returns the word(s) that are
			shortest in length within the
			wordList object that was
			referenced.

		public Word[] getWordsOfLength(int desiredLength)
			returns a Word array of words
			whose length that are equal
			to the input int of desiredlength.

		public Word[] getWordsWithSameLetterSetAs(Word word)
			returns all words in the words
			array that return true when their
			letterset is compared against the
			input word's letterset.

		public int size()
			returns an integer that indicates
			the length of the wordList object.

		*Modification History:
			October 6th, 2014
				Original Version

*/

private Word[] words;

public WordList()
{
	this(new Word[0]);

}//constructor to build the private wordList (setting to zero length array)

public WordList(Word[] words)
{
	if(words==null){throw new IllegalArgumentException("The parameter passed is null.");}
	this.words=new Word[words.length];
	for(int i=0;i<words.length;i++)
	{
		if(words[i]==null){throw new IllegalArgumentException("The parameter "+i+" is null.");}
		this.words[i]=words[i];
	}
}//constructor to build the private wordList (actually building list array)

private Word[] getWords(){return this.words;}

public void addWord(Word word)
{
	//adding another Word to the end of a WordList
	if(word==null){throw new IllegalArgumentException("The parameter passed is null.");}

	Word newArray[];
	newArray= new Word[size()+1];
	for(int i =0;i<size();i++)
	{
		newArray[i]=this.words[i];
	}
	newArray[newArray.length-1]=word;
	this.words=newArray;
}//addWord

public boolean contains(Word word)
{
	//checking if a wordList has contains the passed word
	if(word==null){throw new IllegalArgumentException("The parameter passed is null.");}

	boolean found;
	found = false;
	for(int i =0;i<size() && found==false; i++)
	{
		if(this.words[i].isEqualTo(word,false)){found=true;}
	}
	return found;
}//contains

public Word[] getAllWords()
{
	//returning a copy of the wordList -edited make note of this

	return Arrays.copyOf(this.words, this.size());

}//getAllWords

public Word[] getAnagramsOf(Word other)
{
	//returning an array of Words that are anagrams of the passed Word -edited make note of this
	if(other==null){throw new IllegalArgumentException("The parameter passed is null.");}

	Collection<Word> collection;

	collection=new Vector<Word>();
	for(int i=0;i<words.length;i++)
	{
		if(other.isAnagramOf(this.words[i])){collection.add(this.words[i]);}
	}

	return (collection.toArray(new Word[0]));
}//getAnagramsOf

public Word[] getLongestWords()
{
	//returns an array of the longest words in the wordList
	int    count;
	int    maxLength;
	Word[] result;
	Word[] wordList;

	wordList= getWords();
	maxLength = 0;
	for(int i=0;i<wordList.length;i++)
	{
		maxLength = Math.max(maxLength, wordList[i].numberOfCharacters() );
	}
	count = 0;
	for(int i=0;i<wordList.length;i++)
	{
		if(wordList[i].numberOfCharacters()==maxLength){count=count+1;}
	}
	result = new Word[count];
	count = 0;
	for(int i=0;i<wordList.length;i++)
	{
		if(wordList[i].numberOfCharacters()==maxLength)
		{result[count]=wordList[i]; count=count+1;}
	}
	return result;
}//getLargestWords

public Word[] getShortestWords()
{
	//returns an array of the shortest words in the wordList
	int    count;
	int    minLength;
	Word[] result;
	Word[] wordList;

	wordList= getWords();
	minLength = wordList[0].numberOfCharacters();
	for(int i=0;i<wordList.length;i++)
	{
		minLength = Math.min(minLength, wordList[i].numberOfCharacters());
	}
	count = 0;
	for(int i=0;i<wordList.length;i++)
	{
		if(wordList[i].numberOfCharacters()==minLength){count=count+1;}
	}
	result = new Word[count];
	count = 0;
	for(int i=0;i<wordList.length;i++)
	{
		if(wordList[i].numberOfCharacters()==minLength)
		{result[count]=wordList[i]; count=count+1;}
	}
	return result;
}//getShortestWords

public Word[] getWordsOfLength(int desiredLength)
{
	//returns an array of Words whose length are exactly the same as desirelength
	if(desiredLength <0){throw new IllegalArgumentException("The parameter passed is less than zero.");}

	int    count;
	Word[] result;
	Word[] wordList;

	wordList= getWords();
	count = 0;
	for(int i=0;i<wordList.length;i++)
	{
		if(wordList[i].numberOfCharacters()==desiredLength){count=count+1;}
	}
	result = new Word[count];
	count = 0;
	for(int i=0;i<wordList.length;i++)
	{
		if(wordList[i].numberOfCharacters()==desiredLength)
		{result[count]=wordList[i]; count=count+1;}
	}
	return result;
}//getWordsOfLength

public Word[] getWordsWithSameLetterSetAs(Word other)
{
	//returning a word array of words that are composed of the same letters as the input word
	if(other==null){throw new IllegalArgumentException("The parameter passed is null.");}

	int    count;
	Word[] sameLetterSet;

	count=0;
	for(int i=0;i<words.length;i++)
	{
		if( other.sameLetterSetAs(words[i]) ){count=count+1;}
	}
	sameLetterSet=new Word[count];
	count=0;
	for(int i=0;i<words.length;i++)
	{
		if( other.sameLetterSetAs(words[i]) ){sameLetterSet[count]=words[i];count=count+1;}
	}
	return sameLetterSet;
}//getWordsWithSameLetterSetAs

public int size(){return words.length;}//returning array size



}//class