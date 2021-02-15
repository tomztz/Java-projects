import java.text.DecimalFormat; 
import java.util.Scanner;

import javax.swing.JOptionPane;

/* SELF ASSESSMENT:  Tianze Zhang
1. Did I use easy-to-understand meaningful variable and CONSTANT names? 
    Mark out of 10:10
    Comment:Yes,I did put unchanged constants such as the tax rate, the average disposable income and the rate to show if the disposable income
    is much more/less of the average into constants called TAX_RATE,AVERAGE_DISPOSABLE_MONTHLY_INCOME,RATE_FOR_MUCH_MORE_OR_MUCH_LESS,using final and static modifiers,
    which is clearly understandable.I also set 0 disposable income to a constant called NO_DISPOSABLEINCOME.
    
    I also put many variables, All variables defined are self explanatory, clear and meaningful.For example,disposableIncome,muchMoreThanAverageIncome,
    etc.
2. Did I format the variable and CONSTANT names properly (in lowerCamelCase and UPPERCASE_WITH_UNDERSCORES)?
    Mark out of 10:10
    Comment:Yes,"TAX_RATE"," TAX_RATE,AVERAGE_DISPOSABLE_MONTHLY_INCOME" and "RATE_FOR_MUCH_MORE_OR_MUCH_LESS"are all in uppercase with words separated by underscores.
    For the variables,I follow the coding standard specified the variable names in lowerCamelCase, for example,disposableIncome,muchMoreThanAverageIncome,
    muchLessThanAverageIncome.
3. Did I indent the code appropriately?
    Mark out of 10:10
    Comment:Yes, i follow the two space indent for the code block, for example, main method relative to class, 
                 code within the methods.
4. Did I read the input correctly from the user using appropriate questions?
    Mark out of 15:15
    Comment:Yes,the questions are asked clearly without any confusion, also, prompted with input data format 
             example. for example, "How much are you paid a month before tax? (please input in two decimal places
             in euro, for example, 4000.00)"
5. Did I computer the disposable income and disposable income percentage correctly, and output it in the correct format?
    Mark out of 15:15
    Comment:Yes, Tested with the sample figures and other inputs, the results,formats and the rounded percentage are all correct.
6. Did I use an appropriate series of if statements to generate the income analysis to the user?
    Mark out of 25:25
    Comment:Yes, I used if and else if statements to output correctly how much/less the user is above/below the average disposable income, 
    I also used an if statement to ensure the disposable income and percentage are not printed when the disposable income is less than or equal to zero.
7. Did I provide the correct output for each possibility in an easy to read format?
    Mark out of 10:10
    Comment:Yes, I tested various inputs to get each of the possible cases, and I got the correct output.
8. How well did I complete this self-assessment?
    Mark out of 5:4
    Comment::During the self-assessment I carefully run through every question and go back to my codes and 
    check every line. I mark myself really strict and provide many evidence in the comment.
Total Mark out of 100 (Add all the previous marks):99
*/
public class DisposableIncome {
	 
  public static final double TAX_RATE = 0.35;
  
  public static final double AVERAGE_DISPOSABLE_MONTHLY_INCOME = 500.00;
  
  public static final double RATE_FOR_MUCH_MORE_OR_MUCH_LESS = 0.50;
  
  public static final double 
    MUCH_MORE_THAN_AVERAGE_INCOME = AVERAGE_DISPOSABLE_MONTHLY_INCOME * (1 + RATE_FOR_MUCH_MORE_OR_MUCH_LESS);
  
  public static final double
    MUCH_LESS_THAN_AVERAGE_INCOME = AVERAGE_DISPOSABLE_MONTHLY_INCOME * (1 - RATE_FOR_MUCH_MORE_OR_MUCH_LESS);
  
  public static final double NO_DISPOSABLEINCOME = 0.00;

  public static void main(String[] args) {
	
    String salaryInput = JOptionPane.showInputDialog("How much are you paid a month before tax? "
	  + "(please input in two decimal places in euro, for example, 4000.00)");
    Scanner salaryInputScanner = new Scanner(salaryInput);
    double salaryBeforeTax = salaryInputScanner.nextDouble();
    salaryInputScanner.close();
	
	String rentOrMortgageInput= JOptionPane.showInputDialog("How much do you pay in rent/mortgage a month?"
	  + "(please input in two decimal places in euro, for example, 1000.00)");
	Scanner rentOrMortgageInputScanner = new Scanner(rentOrMortgageInput);
	double accommodationCosts = rentOrMortgageInputScanner.nextDouble();
	rentOrMortgageInputScanner.close();
	
	String commuteCostInput = JOptionPane.showInputDialog("How much does your commute cost a month?"
	  + "(please input in two decimal places in euro, for example, 500.00)");
	Scanner commuteCostInputScanner = new Scanner(commuteCostInput);
	double  travelCosts = commuteCostInputScanner.nextDouble();
	commuteCostInputScanner.close(); 
	
	String foodSpendInput = JOptionPane.showInputDialog("How much do you spend on food per month?"
	  + "(please input in two decimal places in euro, for example, 800.00)");
	Scanner foodSpendInputScanner = new Scanner(foodSpendInput);
	double  foodCosts = foodSpendInputScanner.nextDouble();
	foodSpendInputScanner.close();
		
	double salaryAfterTax =  salaryBeforeTax - (salaryBeforeTax*TAX_RATE);
	
	double disposableIncome = salaryAfterTax - accommodationCosts - travelCosts - foodCosts;
	
	double salaryPercentage = (disposableIncome / salaryBeforeTax) * 100;
	int slaryPercentageRounded = (int) Math.round(salaryPercentage);
		
	DecimalFormat df = new DecimalFormat("#.00");
	String disposalbeIncomeFormatedToTwoDecimalsPlace = df.format(disposableIncome);
	
	String outputPart1 = "Your monthly disposable income is €" 
	  + disposalbeIncomeFormatedToTwoDecimalsPlace +  " which is " + slaryPercentageRounded + "%"+" of your salary.";
	
	if (disposableIncome <= NO_DISPOSABLEINCOME) {
  	  JOptionPane.showMessageDialog(null, outputPart1 + "\n" + "You have no disposable per month.");
  	  return;
	}
	
    String outputPart2 = "";	
    
	if (disposableIncome > MUCH_MORE_THAN_AVERAGE_INCOME) {
	  outputPart2 = "You have much more than the average disposable per month.";
	} else if (disposableIncome > AVERAGE_DISPOSABLE_MONTHLY_INCOME) {
	  outputPart2 = "You have more than the average disposable per month.";
	}
	
	
	if (disposableIncome == AVERAGE_DISPOSABLE_MONTHLY_INCOME) {
	  outputPart2 = "You have exactly the average disposable per month."; 	
	}
	
	if (disposableIncome < MUCH_LESS_THAN_AVERAGE_INCOME) {
		  outputPart2 = "You have much less than the average disposable per month.";
	} else if (disposableIncome < AVERAGE_DISPOSABLE_MONTHLY_INCOME) {
		  outputPart2 = "You have less than the average disposable per month.";
	}

	JOptionPane.showMessageDialog(null, outputPart1 + "\n" + outputPart2);
  }
  
}                  

                
  
  
