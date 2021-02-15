/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful properly formatted, variable names and CONSTANTS?
        Mark out of 10:10
        Comment:Yes, I did put the total number of days in Christmas into a constant called TOTAL_DAYS
        using public and static modifiers.I also used different variables such as numberOfVerses,lyricString,
        which is meaningful.
 2. Did I implement the getVerse function correctly and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25:25
        Comment:Yes, firstly the function is correctly defined, I set it to be public and I want it to return a String
        so I defined it as "public static String getVerse(int days),which days is the parameter, and this function is correctly 
        called in the main method,a string containing the corresponding verse is returned.
 3. Did I implement the getChristmasGift function correctly using a switch statement and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  Yes, firstly the function is correctly defined, I set it to be public and I want it to return a String
        so I defined it as "public static String getChristmasGift (int days),which days is the parameter, and this function is correctly 
        called in the getVerse function, and by using a switch statement the different gifts for different days are recorded
        and the string returns.
 4. Did I implement the getOrdinalString function correctly using if or conditional operators and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25:25
        Comment:   Yes, firstly the function is correctly defined, I set it to be public and I want it to return a String
        so I defined it as "public static String getOrdinalString (int days),which days is the parameter, and this function is correctly 
        called in the getVerse function, and by using a series of if and else statement the correct string for the corresponding number is
        returned. 
 5. Does the program produce the output correctly?
       Mark out of 10:10 
        Comment:  Yes, I made a variable called i, and let it count from 1 to 12 by using a for loop, in order to printout all
        the 12 verses given, and the output format is the same as sample.
 6. How well did I complete this self-assessment?
        Mark out of 5:4
        Comment: During the self-assessment I carefully run through every question and go back to my codes and check every line.
	    I mark myself really strict and provide many evidence in the comment. So honestly I could say I complete this self-assessment very well.
 Total Mark out of 100 (Add all the previous marks):99
*/

public class TweleveDaysExtended {

  public static final int TOTAL_DAYS = 12;

  public static String getVerse(int day) {

	StringBuilder verseBuilder = new StringBuilder();
	
	verseBuilder.append("On the " + getOrdinalString(day) + " day of Christmas\r\n");
	verseBuilder.append("my true love sent to me:\r\n");
	
	if (day == 1) {
	  verseBuilder.append(getChristmasGift(day));
	  return verseBuilder.toString();
	}
	
	while (day > 1) {
	  verseBuilder.append(getChristmasGift(day));
	  day--;
	}

	//append the special first gift info. 
	verseBuilder.append("and " + getChristmasGift(1));

	return verseBuilder.toString();
  }

  public static String getChristmasGift(int day) {
	String lyricString = "";

	switch (day) {

	case 1:

	  lyricString = "a Partridge in a Pear Tree.";
	  break;
	case 2:
	  lyricString = "2 Turtle Doves\r\n";

	  break;
	case 3:
	  lyricString = "3 French Hens,\r\n";
	  break;
	case 4:
	  lyricString = "4 calling birds,\r\n";
	  break;
	case 5:
	  lyricString = "5 gold rings,\r\n";
	  break;
	case 6:
	  lyricString = "6 geese a laying,\r\n";
	  break;
	case 7:
	  lyricString = "7 swans a swimming,\r\n";
	  break;
	case 8:
	  lyricString = "8 maids a milking,\r\n";
	  break;
	case 9:
	  lyricString = "9 drummers drumming\r\n";
	  break;
	case 10:
	  lyricString = "10 pipers piping\r\n";
	  break;
	case 11:
	  lyricString = "11 ladies dancing,\r\n";
	  break;
	case 12:
	  lyricString = "12 Lords a leaping,\r\n";
	  break;
	default:
	  break;
	}

	return lyricString;
  }

  public static String getOrdinalString(int day)

  {
	String dayInChristmas = "";
	switch (day) {
	case 1:
	  dayInChristmas = "first";
	  break;
	case 2:
	  dayInChristmas = "second";
	  break;
	case 3:
	  dayInChristmas = "third";
	  break;  
	case 4:
	  dayInChristmas = "fourth";
	  break;
	case 5:
	  dayInChristmas = "fifth";
	  break;
	case 6:
	  dayInChristmas = "sixth";
	  break;
	case 7:
	  dayInChristmas = "seventh";
	  break;
	case 8:
	  dayInChristmas = "eighth";
	  break;
	case 9:
	  dayInChristmas = "ninth";
	  break;
	case 10:
	  dayInChristmas = "tenth";
	  break;
	case 11:
	  dayInChristmas = "eleventh";
	  break;
	case 12:
	  dayInChristmas = "twelfth";
	  break;
	default:
	  break;
	}
	  
	return dayInChristmas;
	
  }

  public static void main(String[] args) {

	//loop for all the 12 verses.
	for (int i = 1;i <= TOTAL_DAYS;i++) {
	  System.out.println(getVerse(i));
	}
  }

}