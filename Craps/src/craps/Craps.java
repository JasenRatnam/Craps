// Programer: Jasen Ratnam
// Date: 2016-11-04
// Assignment 4_A
/* Purpose: Write an interactive program to play games of craps and then print
            out the scores for the games played.*/

package craps;
import java.util.Random;
import java.util.Scanner;
public class Craps 
{   
    public static void main(String[] args) 
    {
        //pre iniatilize values
        int random1;                //save random number from dice 1
        int random2;                //save random number from dice 2
        final int MAX_RANGE = 6;    //save max number of dice possible
        final int MIN_RANGE = 1;    //save min number of dice possible
        int winpoint = 0;           //save point to have to win
        int point = 0;              //point in every loop
        final int ROUND_WIN1 = 7;   //value to have to win in first round
        final int ROUND_WIN2 = 11;  //value to have to win in first round
        final int ROUND_LOSE1 = 2;  //value to have to lose in first round
        final int ROUND_LOSE2 = 3;  //value to have to lose in first round
        final int ROUND_LOSE3 = 12; //value to have to lose in first round
        String answer;              //answer entered for round replay
        int you = 0;                //your score
        int me = 0;                 //my score
        boolean play = true;               // play another round
        String divider = "-----------------------------------"; //dividing line
     
       //start game
       //while(play == true)// game loop for one round
        do
       {
            Random rand = new Random();
            Scanner input = new Scanner(System.in);
            
            //first roll of game
            System.out.println("Here is how you roll ... Good luck!");
            System.out.println(divider); // print divider
            
            //save random numbers of both dice
            random1 = rand.nextInt(MAX_RANGE) + MIN_RANGE; 
            random2 = rand.nextInt(MAX_RANGE) + MIN_RANGE; 
            
            //add both values to create point to win
            winpoint = (random1 + random2);
            
            //print rolled numbers
            System.out.println("You rolled " + random1 + " + " + random2 + " = " + 
                                winpoint);
            //if you win in the first round
            if (winpoint == ROUND_WIN1 || winpoint == ROUND_WIN2 )
            {
                System.out.println("You win!");
                you++;
            }
            //if you lose in first round
            else if (winpoint == ROUND_LOSE1 || winpoint == ROUND_LOSE2 || winpoint == ROUND_LOSE3)
            {
                System.out.println("The house wins !");
                me++;
            }
            //continu rolling until point is same as win point or 7
            else
            {
                System.out.println("Your point is (" + winpoint + ")"); // display win pooint
                // start loop for arriving at win point or 7
                while(point != 7 && point != winpoint)
                {
                    random1 = rand.nextInt(MAX_RANGE) + MIN_RANGE; 
                    random2 = rand.nextInt(MAX_RANGE) + MIN_RANGE; 
                    //add both values
                    point = (random1 + random2);
                    //print rolled numbers
                    System.out.println("You rolled " + random1 + " + " + random2 + " = " + 
                                         point);
                }
                if(point == ROUND_WIN1)
                {
                    System.out.println("The house wins !");
                    me++;
                }
                else
                {
                    System.out.println("You win!");
                    you++;
                }
            }
            System.out.println(divider);  
            do
            {
                System.out.println("Another round (yes/no)? "); //ask user for another round
                answer = input.next().toLowerCase();//save first character inputed in lowercase
                if (answer.equals("yes")) // if yes than continu
                {
                    play = true;
                }
                else if (answer.equals("no")) //if no than stop and display results
                {
                    play = false;
                    System.out.println("Scores:");
                    System.out.println("------");
                    System.out.println("You won " + you + " times");
                    System.out.println("The house won " + me + " times");
                    System.out.println();
                    //return;
                }
                else //if wrong input
                {
                    System.out.println("Bad answer \"" + answer +"\"");
                }
            }while((!"no".equals(answer)) && (!"yes".equals(answer))); // do
       }while(play);        //(play == true);
    }
    
}
