package pi;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Pi {



	public static void main(String[] args) {
	String numberOfDigits= JOptionPane.showInputDialog(null, "enter the amount of digits to show");
	Scanner numberOfDigitsScanner = new Scanner(numberOfDigits);
	int digits= numberOfDigitsScanner.nextInt();
	
	double Pi=3.000000;
	double a=2.0;
	double b=3.0;
	double c=4.0;
	double i;
	boolean plusOrMinus=true;
	
	
	 while(digits>0) {
		
		 i=a*b*c;
		if(plusOrMinus==true) {
      Pi= Pi+(4/i);
      digits=digits-1; 
      a=a+2; 
      b=b+2;
      c=c+2;
      plusOrMinus=false;
		}
	    else  {
	    Pi= Pi-(4/i);
	    digits=digits-1; 
	    a=a+2;
	    b=b+2;
	    c=c+2;
	    plusOrMinus=true;
	} 
		  
	}
	JOptionPane.showInputDialog(null,"the value of Pi is"+Pi);
 }                              
}    


