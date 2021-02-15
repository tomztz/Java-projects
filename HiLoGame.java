import java.util.Random;
import java.util.Scanner;
/* SELF ASSESSMENT
1. Did I use appropriate CONSTANTS instead of numbers within the code?
    Mark out of 5:5
    Comment:Yes, I did put unchanged constant the maximum value for a card into a constant using public and static modifiers. 
2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
    Mark out of 5:5
    Comment:Yes, the using of full normal words like MAX_NUMBER is clearly understandable.  
3. Did I use easy-to-understand meaningful variable names?
    Mark out of 10:10
    Comment:Yes,all variables defined are self explanatory, clear and meaningful.For example,"currentCaed","CardChoose"
    "cardGreaterThanTen".
4. Did I format the variable names properly (in lowerCamelCase)?
    Mark out of 5:5
    Comment: Yes,I follow the coding standard specified the variable names in lowerCamelCase, for example,"currentCaed","CardChoose".
5. Did I indent the code appropriately?
    Mark out of 10:10
    Comment: Yes, i follow the two space indent for the code block, for example, main method relative to class, code within the methods.
6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose?
    Mark out of 20: 20
    Comment: Yes,I used a while loop to allow them to guess 4 times and check if they win or lose. 
7. Did I check the input to ensure that invalid input was handled appropriately?
    Mark out of 10: 10
    Comment: Yes,I used an if and else system that allows the comparison will only start if either higher lower or equal is entered.
    otherwise, it will inform the user to put a valid input and continue on with the rest of the guessing.
8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)?
    Mark out of 10: 10
    Comment: Yes, both the first card and the currentCard is produced by a random generator.
9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King?
    Mark out of 10: 10
    Comment: Yes, the cards are correctly output using if else if and else statement.
10. Did I report whether the user won or lost the game before the program finished?
    Mark out of 10:10
    Comment: Yes, if the user gets four correct answer the user will be informed (count=0), but if not they will also be informed.
11. How well did I complete this self-assessment?
    Mark out of 5:4
    Comment: During the self-assessment I carefully run through every question and go back to my codes and 
    check every line. I mark myself really strict and provide many evidence in the comment.
Total Mark out of 100 (Add all the previous marks):99
*/
public class HiLoGame {

	public static final int MAX_NUMBER = 14;

	public static void main(String[] args) {

		int numberOfTimes = 4;
		String cardGreaterThanTen = "";
		int count=0;
		Random RAND = new Random();
		int cardChoose = RAND.nextInt(MAX_NUMBER) + 1;

		while (numberOfTimes > 0) {
			int currentCard = RAND.nextInt(MAX_NUMBER) + 1;

			if (cardChoose == 11) {
				cardGreaterThanTen = "J";
			} else if (cardChoose == 12) {
				cardGreaterThanTen = "Q";
			} else if (cardChoose == 13) {
				cardGreaterThanTen = "K";
			} else if (cardChoose == 14) {
				cardGreaterThanTen = "A";
			} else if (cardChoose <= 0 || cardChoose == 1) {
				System.exit(2);
			}

			if (cardChoose < 10 && cardChoose > 1) {
				System.out.println("The card is a " + cardChoose);
				System.out.println("Do you think the next card will be higher, lower or equal?");
			} else {
				System.out.println("The card is a " + cardGreaterThanTen);
				System.out.println("Do you think the next card will be higher, lower or equal?");
			}

			Scanner inputScanner = new Scanner(System.in);
			String usersGuess = inputScanner.next();

			if (usersGuess.equals("higher") || usersGuess.equals("equal") || usersGuess.equals("lower")) {

				if (usersGuess.equals("higher") && currentCard > cardChoose) {
					numberOfTimes--;

				} else if (usersGuess.equals("equal") && currentCard == cardChoose) {
					numberOfTimes--;
					;
				} else if (usersGuess.equals("lower") && currentCard < cardChoose) {
					numberOfTimes--;
					;
				} else {
					System.out.println("Sorry, you are wrong");
					numberOfTimes--;
					count++;
					
				}
			} else {
				System.out.println("please enter a vaild guess.(higher equal or lower)");
				continue;
			}
			cardChoose = currentCard;

		}
		if(count==0) {
			System.out.println("Congratulations.  You got them all correct.");
		} 
		else {
			System.out.println("Sorry, you lose the game as you didnt get four correct answers in a row.");
		}

		
	}
}
	


