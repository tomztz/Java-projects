import java.util.Scanner;

public class DigitFrequency {
	public static void countDigitFrequencies( int number, int[] frequencies ) {
		int digit=0;
		while (number>0) {
			digit=number%10;
			number=number/10;
		
						
		frequencies[digit]++;
		}
		
		
		
	}
	public static void printDigitFrequencies( int[] frequencies ) {
		for(int j=0; j<frequencies.length;j++) {
			if(frequencies[j]!=0) {
				System.out.print(j);
				System.out.print("("+frequencies[j]+")");
			}
		}
		
	}
	public static void main(String[] args) {
		int[] testArray= new int[10];
		
		int subTotal=0;
		while(true) {
		System.out.println(  "Enter a number>");
		Scanner input=new Scanner(System.in);
		if(!input.hasNextInt()) {
			break;
		}
		int num=input.nextInt();
		countDigitFrequencies(num,testArray);
	
		printDigitFrequencies( testArray);
		}
		
	}

}
