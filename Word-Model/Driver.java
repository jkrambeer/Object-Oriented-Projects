import java.io.*;
public class Driver
{
 /*
   Patrick L. Jarvis
   September 23, 2014

  Test out the Word class a bit

 */

 public static void main ( String[] args )
 {
	 WordMeister temp;
	 WordList[]  test;
	 long startTime;
	 long endTime;
	 long startTime2;
	 long endTime2;

	 temp= new WordMeister(new File("InputFiles/DictionaryWords.txt"));

	 System.out.println("Start");
	 startTime=System.currentTimeMillis();
	 test= temp.findAllAnagrams();
	 endTime=System.currentTimeMillis();
	 System.out.println("Time was for string implementation: "+(endTime-startTime)+"ms" );

 }// main

 }// class