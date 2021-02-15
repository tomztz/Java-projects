/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5:5
       Yes,I did put unchanged constants such as the total days for Christmas into a constant called TOTAL_DAYS,
       using final and static modifiers.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5:5
      	Yes,the constant TOTAL_DAYS is all in upper case with words separated by underscores and its also meaningful.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 10:10
        Yes, all variables defined are self explanatory, clear and meaningful.For example,dayInChristmas,lyricString
    etc.I also follow the coding standard specified the variable names in lowerCamelCase, for example,dayInChristmas,lyricString.
   4. Did I indent the code appropriately?
       Mark out of 10:10
       Yes, i follow the two space indent for the code block, for example, main method relative to class, 
       code within the methods.
   5. Did I use an appropriate loop (or loops) to produce the different verses?
       Mark out of 20: 20
       Yes, I used a for loop to set the initial value of dayInChristmas to one and add 1 for each time to access all
       the 12 different verses in the lyric.
   6. Did I use a switch to build up the verses?
       Mark out of 25: 25
       Yes, I used a switch statement to print out all the verses and form them using 12 different cases. 
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))?
       Mark out of 10: 10
       Yes, firstly, I decided to put the first two sentences outside the switch statement as they are always the same, 
       secondly, I created a string which restore the sentences from the last verse and I add the new sentence to the start
       of the string to avoid duplication.
   8. Does the program produce the correct output?
       Mark out of 10: 10
       Yes, the format of the output lyric is exactly the same format of the sample, and the content is the same as
       the lyric I searched from google.
   9. How well did I complete this self-assessment?
       Mark out of 5:4
       During the self-assessment I carefully run through every question and go back to my codes and 
    check every line. I mark myself really strict and provide many evidence in the comment.
   Total Mark out of 100 (Add all the previous marks):99
*/
public class TwelveDayOfChristmas {

	public static final int TOTAL_DAYS = 12;

	public static void main(String[] args) {

		String noDayInChristmas = " ";
		String lyricString = " ";
		for (int dayInChristmas = 1; dayInChristmas <= TOTAL_DAYS; dayInChristmas++) {
			if (dayInChristmas == 1) {
				noDayInChristmas = "first";
			}
			if (dayInChristmas == 2) {
				noDayInChristmas = "second";
			}
			if (dayInChristmas == 3) {
				noDayInChristmas = "third";
			}
			if (dayInChristmas == 4) {
				noDayInChristmas = "fourth";
			}
			if (dayInChristmas == 5) {
				noDayInChristmas = "fifth";
			}
			if (dayInChristmas == 6) {
				noDayInChristmas = "sixth";
			}
			if (dayInChristmas == 7) {
				noDayInChristmas = "seventh";
			}
			if (dayInChristmas == 8) {
				noDayInChristmas = "eighth";
			}
			if (dayInChristmas == 9) {
				noDayInChristmas = "ninth";
			}
			if (dayInChristmas == 10) {
				noDayInChristmas = "tenth";
			}
			if (dayInChristmas == 11) {
				noDayInChristmas = "eleventh";
			}
			if (dayInChristmas == 12) {
				noDayInChristmas = "twelfth";
			}

			System.out.println("On the " + noDayInChristmas + " day of Christmas");
			System.out.println("my true love sent to me:");

			switch (dayInChristmas) {
			case 1:

				System.out.println("a Partridge in a Pear Tree.");
				break;
			case 2:
				lyricString = "2 Turtle Doves\r\n" + "and a Partridge in a Pear Tree. ";
				System.out.println(lyricString);
				break;
			case 3:
				lyricString = "3 French Hens,\r\n" + lyricString;
				System.out.println(lyricString);
				break;
			case 4:
				lyricString = "4 calling birds,\r\n" + lyricString;
				System.out.println(lyricString);
				break;
			case 5:
				lyricString = "5 gold rings,\r\n" + lyricString;
				System.out.println(lyricString);
				break;
			case 6:
				lyricString = "6 geese a laying,\r\n" + lyricString;
				System.out.println(lyricString);
				break;
			case 7:
				lyricString = "7 swans a swimming,\r\n" + lyricString;
				System.out.println(lyricString);
				break;
			case 8:
				lyricString = "8 maids a milking,\r\n" + lyricString;
				System.out.println(lyricString);
				break;
			case 9:
				lyricString = "9 drummers drumming\r\n" + lyricString;
				System.out.println("9 drummers drumming");
				break;
			case 10:
				lyricString = "10 pipers piping\r\n" + lyricString;
				System.out.println(lyricString);
				break;
			case 11:
				lyricString = "11 ladies dancing,\r\n" + lyricString;
				System.out.println(lyricString);
				break;
			default:
				lyricString = "12 Lords a leaping,\r\n" + lyricString;
				System.out.println(lyricString);
				System.out.println("and a partridge in a peer tree.");
				break;
			}
		}
	}

}
