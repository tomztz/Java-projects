import java.util.Scanner;

public class IncrementalStatisticss {

	public static void main(String[] args) {
		double average= 0;
		int N =0;
		
		double variance=0;
		
		Scanner inputScanner= new Scanner(System.in);
		String inputNumString=inputScanner.next();
		while(!inputNumString.equals("quit")) {
		System.out.println("Enter a number (or type 'exit'):"); 
	
		int inputNum=Integer.parse(inputNumber);
			N++;
			variance= ((variance*(N-1))+(inputNumber-average)*(inputNumber-average))/N;
			average=(average+(inputNumber-average))/N;
			
			
			
			System.out.println("So far the average is "+average+" and the variance is "+variance);
		}
		else {
			System.out.println("Goodbye");
			exit=false;
		}
		}
	}

}
