
import java.text.DecimalFormat;
import java.util.Scanner;

/* SELF ASSESSMENT

1. Did I use easy-to-understand meaningful, properly formatted, variable names and CONSTANTS?
       Mark out of 10: 10
       Comment: Yes, I did put the unchanged constant duration and total of months into constants called 
       DURATION,TOTAL_OF_MONTHS, using final and static modifier.I also used many variables such as
       totalNumberOfYears, annualInterestRate, formatted in lowerCamelCase, and they are also meaningful.
2. Did I indent the code appropriately?
       Mark out of 5: 5
       Comment: Yes, i follow the two space indent for the code block, for example, main method relative to class, 
       code within the methods.
3. Did I implement the mainline correctly with a loop which continues using the user says "no" ?
      Mark out of 10: 
       Comment:  Yes, I created a loop which continues when the user enters "yes", but stop when the user answer "no" 
       or anything else.
4. Did I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats ?
      Mark out of 10: 10
       Comment:  Yes, I used Scanner inside the readDoubleFromUser function and returns a value from the user, the value 
       is then stored inside a variable in the main method for later calls in other functions.
5. Did I implement the readDoubleFromUser function correctly and in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
      Mark out of 20: 20
       Comment: Yes, firstly the function is correctly defined, I set it to be public and I want it to return a double
        so I defined it as "public static double readDoubleFromUser(String question),which the question ask to the user is the parameter, and this function is correctly 
        called in the main method, and the number entered by the user is returned, i also used recursion to check weather if the number enter is vaild.
6. Did I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
      Mark out of 20: 20
       Comment: Yes, firstly the function is correctly defined, I set it to be public and I want it to return a double
        so I defined it as "public static double calculateMonthlyRepayment(double principal, double APR),which takes the principle
        and the APR as parameter, and the function is correctly called in the main method, and returns the monthly repayment.
7. Did I implement the calculateMonthsToRepayMortgage function correctly in a manner that can be easilyunderstood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
      Mark out of 20:20 
       Comment:  yes,firstly the function is correctly defined, I set it to be public and I want it to return a integer
        so I defined it as "public static Int calculateMonthsToRepayMortgage(double princible, double APR, double affordableMonthlyRepayment),which takes the principle,APR, and MonthlyRepayment
        and returns the number of months, the function is also correctly called from the main method.
8. How well did I complete this self-assessment?
       Mark out of 5: 4
       Comment: During the self-assessment I carefully run through every question and go back to my codes and 
    check every line. I mark myself really strict and provide many evidence in the comment.
Total Mark out of 100 (Add all the previous marks):99
*/ 
public class MortgageCalculator {

  public static final int DURATION = 20;

  public static final int TOTAL_OF_MONTHS = 12;

  public static double readDoubleFromUser(String question) {
	System.out.println(question);
	
	Scanner input = new Scanner(System.in);

	if (input.hasNextInt() || !input.hasNextDouble()) {

	  return readDoubleFromUser("please enter a value with 2 decimals e.g 200000.00");

	}
	
	double enteredDouble = input.nextDouble();

	if (enteredDouble < 0) {

	  return readDoubleFromUser("please enter a value positive e.g 200000.00");
	}
    
	return enteredDouble;

  }

  public static double calculateMonthlyRepayment(double principal, int duration, double APR) {

	double monthlyRepayment = principal * (APR / 12 / 100) / (1 - Math.pow((1 + APR / 12 / 100), (-duration * 12)));

	DecimalFormat df = new DecimalFormat("#.00");
	String monthlyRepaymentFormatedToTwoDecimalsPlace = df.format(monthlyRepayment);

	return Double.parseDouble(monthlyRepaymentFormatedToTwoDecimalsPlace);

  }

  public static int calculateMonthsToRepayMortgage(double amount, double monthlyRepayment, double APR) {
	double monthlyInterestRate = APR / 12;
	int numberOfMonths = 0;
	
	while (amount > 0) {
	  amount = amount + (amount * (monthlyInterestRate / 100)) - monthlyRepayment;
	  numberOfMonths++;
	}
	
	return numberOfMonths;
  }

  public static void main(String[] args) {
	boolean isFinish = false;
	
	do {

	  System.out.println("Welcome to the mortgage calculator.");
	  
	  double mortgage = readDoubleFromUser("Please enter the mortgage amount:");
	  double annualInterestRate = readDoubleFromUser("Please enter the annual interest rate (APR): ");
	  
	  System.out.println("Assuming a " + DURATION + " year term, " + "the monthly repayments would be "
	      + calculateMonthlyRepayment(mortgage, DURATION,annualInterestRate));

	  double monthlyRepayments = readDoubleFromUser("How much can you afford to pay per month?");

	  int totalNumberOfMonths = calculateMonthsToRepayMortgage(mortgage, monthlyRepayments, annualInterestRate);
	  int totalNumberOfYears = totalNumberOfMonths / TOTAL_OF_MONTHS;
	  int remaindingMonth = totalNumberOfMonths % TOTAL_OF_MONTHS;
	  System.out.println("If you pay " + monthlyRepayments + " per month your mortgage would be paid off in "
	      + totalNumberOfYears + " years and " + remaindingMonth + " months.");

	  System.out.println("Would you like to use the mortgage calculator again (yes/no)?");
	  Scanner inputScanner = new Scanner(System.in);
	  String doContinue = inputScanner.next();
	  if (doContinue.equals("no")) {
		isFinish = false;
	  } else if (doContinue.equals("yes")) {
		isFinish = true;
	  } else {
		System.out.println("As you didn't give a vaild answer, " + "the mortgage calculator will close,byebye.");
		System.exit(-1);
	  }
	  
	} while (isFinish == true);
  }

}
