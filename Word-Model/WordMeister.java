import java.io.*;
import java.util.*;

public class WordMeister
{
/*
	Joseph Krambeer
	10-16-14

	An aptly named class by glorious leader Jarvis
	that takes a file and creates a wordlist from it.
*/

private WordList wordMeister;

public WordMeister(File inputFile)
{
	if  (inputFile==null )		 {throw new IllegalArgumentException("The file sent is null.");}
	if  (inputFile.isDirectory()){throw new IllegalArgumentException("The file sent is a directory.");}
	if(!(inputFile.exists() ) )  {throw new IllegalArgumentException("The file sent does not exist.");}
	if(!(inputFile.canRead() ) ) {throw new IllegalArgumentException("The file sent cannot be read.");}

	this.wordMeister = new WordList( getWordsFromFile(inputFile) );//making the new WordList
}//constructor

public WordList[] findAllAnagrams()
{
	int 			   count;
	WordList[] 		   result;
	WordList[]         returned;
	Word[] 	  		   words;
	boolean[]          usedAlready;
	Word[]             temp;

	words = this.wordMeister.getAllWords();
	Arrays.sort(words);

	result = new WordList[words.length]; //making exactly for sure you have enough elements
	usedAlready=new boolean[words.length];//false is not used, true if used, all false atm
	count = 0;

	for(int i=0;i<words.length;i++)
	{
		if( !(usedAlready[i]) )//want to see if true and only do on false
			{
				temp=this.wordMeister.getAnagramsOf(words[i]);
				result[count]=new WordList(temp);

				for(int j=0;j<temp.length;j++)
				{
					usedAlready[Arrays.binarySearch(words,temp[j])]=true;
				}
				count = count+1;
			}//!usedAlready
	}//for loop
	returned= new WordList[count];
	for(int i=0;i<returned.length;i++)
	{
		returned[i]=result[i];
	}
	return returned;
}//findAllAnagrams2



//-----------------PrivateMethods-------------------

private boolean isInPrevious(WordList[] referenceArray, Word referenceWord, int numberOfArrays)
{
	//remove this
	boolean result;
	result=false;
	for(int i=0;i<numberOfArrays && result == false;i++)
	{
		if( referenceArray[i].contains(referenceWord) ){result=true;}
	}
	return result;
}

private Word[] getWordsFromFile(File inputFile)
{
	try
	{
		BufferedReader     dataFile;
		String 		       dataRecord;//opening file
		Collection<String> collection;
		String[]       	   readData;
		Word[]             result;

		dataFile=new BufferedReader(new FileReader(inputFile) );//opening the file

		collection = new ArrayList<String>();
		dataRecord= dataFile.readLine();//priming the read
		while(dataRecord!=null)
		{
			if(dataRecord.trim().length()>0)//will only add if the read data actually has something
			{
				collection.add(dataRecord);
			}
			dataRecord= dataFile.readLine();//another read of data
		}
		dataFile.close();//closing file

		readData = collection.toArray(new String[0]);
		result = new Word[readData.length];

		for(int i=0;i<readData.length;i++)
		{
			result[i] = new Word(readData[i]);//changing collected string to word objects
		}

		return result;
	}//try

	catch(IOException ioe)
	{
		throw new RuntimeException("Killed the process: IOException");
	}//catch

}//getWordsFromFile


}//class