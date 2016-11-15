import java.io.*;
public class AdviceGenerator
{



 //  Hers's the main that will just test out the MagicEightBall
/* public static void main (String[] args) throws IOException
 {
  Advice advice;

  advice = new MagicEightBall();
  while(askYesOrNo("\nDo you want some advice? "))
  {
   System.out.println("\n >>> "+advice.getAdviceAsSentence());
  } // while
   System.out.println("Thanks for playing.");
 } // main

 //  Here's the main that will test out all the advice givers
*/
 public static void main (String[] args) throws IOException
 {

  Advice[] solicitedAdvice   = { new MagicEightBall(), new MagicPirateBall() };
  Advice[] unSolicitedAdvice = { new FortuneCookie(new File("E:/Cisc 230/Advice Model/AdviceTexts/FortuneCookieAdvice.txt")), new ParentalAdvice(new File("E:/Cisc 230/Advice Model/AdviceTexts/ParentalAdvice.txt")) };
  Advice   advice;

  while(askYesOrNo("\nDo you want some advice? "))
  {
   if(askYesOrNo("Do you want solicited advice? "))
   {
    advice = solicitedAdvice[(int) (Math.random()*solicitedAdvice.length)];
   }
   else
   {
    advice = unSolicitedAdvice[(int) (Math.random()*unSolicitedAdvice.length)];
   }
   System.out.println("\n >>> "+advice.getAdviceAsSentence());
  }
  System.out.println("Thanks for playing.");
 } //main


 private static boolean askYesOrNo(String prompt) throws IOException
 {
  // ask the user a question. return true if response
  // is yes, false if no.

  String         answer;
  BufferedReader keyboard;

  keyboard = new BufferedReader ( new InputStreamReader ( System.in ) );

  do
  {
   System.out.print(prompt);
   answer = keyboard.readLine().trim();
   if(answer.equalsIgnoreCase("y")) { answer = "yes"; }
   if(answer.equalsIgnoreCase("n")) { answer = "no"; }
  }
  while(!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No"));


  return answer.equalsIgnoreCase("Yes");
 }

}