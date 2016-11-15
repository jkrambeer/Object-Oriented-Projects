import java.util.*;
import java.io.*;

abstract public class Advice
{
/*
	Joseph Krambeer
	10-14-14

	This class models advice whether solicitated or not and returns the advice in a sentence structure.

	*Class Variables:
		advice
			a string array that holds
			all possible advice options
			for the created object

	*Constructors:
		Advice(String[])
			this constructs will store the
			passed string array into the
			advice string array

		Advice(File)
			this constructs the advice array
			from reading a sequential file and
			putting all lines with actual
			stuff on them into an array
			which is stored in advice

	*Methods:
		public string getAdvice()
			returns a string with a
			random piece of advice
			within the advice string

		public string getAdviceAsSentence()
			returns a string with the name
			of the advice giver and what the
			advice actually is

		private String[] getAdviceFromFile(File)
			reads a sequential file and processes
			all non-white enteries into a ArrayList
			that is eventually turned to a string
			array and returned.

	*Modification History:
		October 14, 2014
			Original Version
*/

private String[] advice;

public Advice(String[] advice)
{
	if(advice==null){throw new IllegalArgumentException("The parameter passed is null.");}
	this.advice=advice;
}// constructor

public Advice(File inputFile)
{
		if  (inputFile==null )		 {throw new IllegalArgumentException("The file sent is null.");}
		if  (inputFile.isDirectory()){throw new IllegalArgumentException("The file sent is a directory.");}
		if(!(inputFile.exists() ) )  {throw new IllegalArgumentException("The file sent does not exist.");}
		if(!(inputFile.canRead() ) ) {throw new IllegalArgumentException("The file sent cannot be read.");}

		this.advice=getAdviceFromFile(inputFile);

}// constructor

public String getAdviceAsSentence()
{
	return this.getAdviceGiverName()+" says: "+this.getAdvice();
}

public String getAdvice()
{
	return advice[(int)Math.floor( Math.random()*this.advice.length)];
}

private String[] getAdviceFromFile(File inputFile)
{
	try
	{
		BufferedReader     dataFile;
		String 		       dataRecord;//opening file
		Collection<String> collection;
		String[]       	   readData;

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
		dataFile.close();//closing file (ending populating)

		readData = collection.toArray(new String[0]);
		return readData;
	}//try

	catch(IOException ioe)
	{
		throw new RuntimeException("Killed the process: IOException");
	}//catch

}//getAdviceFromFile

abstract public String getAdviceGiverName();

abstract public String getAdviceType();


}//class