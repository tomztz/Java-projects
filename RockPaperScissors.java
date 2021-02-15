
import java.util.Random;
import java.util.Scanner;

/* SELF ASSESSMENT
   1. Did I use appropriate easy-to-understand, meaningful variables and CONSTANTS within the code? 
       Mark out of 10:10
       Comment:Yes,I did put unchanged constants such as the total number of games to be played and the max number for the computer generate by random into constants called "NUMBER_OF_TIMES","MAX_NUMBER",using final and static modifiers,
which is clearly understandable.

I also put many variables, All variables defined are self explanatory, clear and meaningful.For example,
computerScore,userScore,computerChoose etc.
   2. Did I format the variable and CONSTANT names appropriate (in lowerCamelCase and UPPERCASE)?
       Mark out of 5:5
       Comment:Yes,"NUMBER_OF_TIMES","MAX_NUMBER",are all in uppercase with words separated by underscores.
    For the variables,I follow the coding standard specified the variable names in lowerCamelCase, for example,,computerScore
    userScore.
   3. Did I generate the computer's choice in each game correctly using a Random number generator?
       Mark out of 10:10
       Comment:Yes, the computer's choice was generated randomly using a Random number generator, and for each round the computer 
       outputs a random value to compare with the user's.
   4. Did I input the user's choice in each game correctly?
       Mark out of 10:10
       Comment:Yes, the user was asked to enter their choice after the sentence "Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors):" ,
       and the input the user enter was stored in a variable"rockPaperScissoirsUser" to be compare with the computer choice later.   
   5. Did I correctly compare the choices and update the score appropriately?
       Mark out of 20:20
       Comment:Yes, I compare the score by subtracting the computers choice by the user's, there are only three possibilities for the computer to win,
       which is computer 2(paper)and the user 1(rock), or computer 3(scissors), user 2(paper), or computer 1(rock) or user 3(scissors), which means if 
       computer choice minus the users choice should only be 1 or -2 for a computer to win. And if the subtraction gives zero it's draw, otherwise, the user
       wins. And I used "computerScore++" and "userScore++" to update the score after each comparison.
   6. Did I inform the user of who won each game (and why) correctly?
       Mark out of 10:10
       Comment:Yes, just below the generator there is an if,else if,and else statement to store the computers choices in a string,
       and the string was print out each time after the game.
   7. Did I use an appropriate for loop to allow the player to play 5 games?  There should be only one loop.
       Mark out of 20: 20
       Comment:Yes, I only use one loop,and it allows the player to play 5 games by adding 1 to the variable "numberOfTimes" each time,which was initiated to zero
       and the loop was stopped until its equal to 5.
   8. Did I output the final scores correctly after the 5 games were played. 
       Mark out of 10: 10
       Comment:Yes, I tested the code many times and I counted the times for the computer to win and the user. The score outputs correctly
       each time.
   9. How well did I complete this self-assessment?
       Mark out of 5:4
       Comment:During the self-assessment I carefully run through every question and go back to my codes and 
    check every line. I mark myself really strict and provide many evidence in the comment.
   Total Mark out of 100 (Add all the previous marks):99
*/
public class RockPaperScissors {

  public static final int MAX_NUMBER = 3;

  public static final int NUMBER_OF_TIMES = 5;

  public static void main(String[] args) {
    int computerScore = 0;
    int userScore = 0;

    Random rand = new Random();
    Scanner rockPaperScissorsInputScanner = new Scanner(System.in);
    String computerChoose = "";

    for (int i = 0; i < NUMBER_OF_TIMES; i++) {
      
      int rockPaperScissorsComputer = rand.nextInt(MAX_NUMBER) + 1;

      System.out.print("Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors):");

      int rockPaperScissorsUser = rockPaperScissorsInputScanner.nextInt();

      if (rockPaperScissorsComputer == 1) {
        computerChoose = "rock";
      } else if (rockPaperScissorsComputer == 2) {
        computerChoose = "paper";
      } else if (rockPaperScissorsComputer == 3){
        computerChoose = "scissors";
      } else {
          System.out.println("System generated wrong random number:" + rockPaperScissorsComputer);
          System.exit(1);
      }

      int result = rockPaperScissorsComputer - rockPaperScissorsUser;

      // See comment 5 for explanation.
      if (result == 1 || result == -2) {
        computerScore++;
        System.out.println("You lost this round as I chose " + computerChoose);
      } else if (rockPaperScissorsComputer == rockPaperScissorsUser) {
        System.out.println("This round was a draw as I chose " + computerChoose + " too");
      } else {
                userScore++;
                System.out.println("You won this round as I chose " + computerChoose);
      }

    }
    
    System.out.println("The final score was Computer: " + computerScore + " User: " + userScore);

    rockPaperScissorsInputScanner.close();
  }

}
