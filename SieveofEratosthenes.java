import java.util.Scanner;

/* SELF ASSESSMENT 
1.  createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes,the function is correctly defined, the function is set to public and returns an integer array, 
it takes a number and creates an array from 2 to that number, so I set the parameter to a number, therefore the 
method is set as public static int[] createSequence(int num).
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5 
Comment:Yes, inside the function I created an int array called sequence and set it to the size num-1,because the 
number starts from 2 to the final number passed in the function.
Did I return the correct item?
Mark out of 5:5
Comment:Yes, the correct sequence of numbers are returned and appeared correctly when running.
2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes,the function is correctly defined, the function is set to public and doesn't return anything,the sequence 
of numbers and the divisor are passed as parameter,therefore the method is set as public static void crossOutHigherMultiples
(int[] sequence, int x).
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment:Yes, at the beginning inside the function, I checked if the array is null or not.
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:Yes, every elements inside the array is divided by the number passed in the method using a for loop,
and if it could be fully divide by the number it would be set to zero.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment:Yes, when running in main I used two for loops to pass in one prime number bellow the square root of 
the number which user entered in this function, and the correct item is crossed out. 
3.  sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes,the function is correctly defined, the function is set to public and returns an int array with all
the prime numbers only, and takes in an integer as parameter, so its defined as public static int[] sieve(int num).
Did I make calls to other methods?
Mark out of 5:5
Comment:Yes, I created a new array by calling the createSequence method, to create a new sequence of number,then I called
the crossOutHigherMultiples to cross out each prime number's multiple.      
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment:Yes, all the prime numbers are crossed out and the prime numbers only sequence are printed out in console.
4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes,the function is correctly defined, the function is set to public and returns a String, with all the multiples
of the numbers are set in a square bracket,and an integer array is passed as parameter, so it is set to public static String 
sequenceToString(int[] newSequence).
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: Yes, at the start of the function I used an if statement to check if the array passed is null, and if a 
null array is passed it would return null.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment:Yes, I create an original sequence by the createSequence array, and I referenced to the crossed out array
with 0s replaced by the multiples of prime numbers, and every time reached a zero, the number in the original sequence
will be replaced with a square bracket with the number inside.    
5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:Yes,the function is correctly defined, the function is set to public and returns a String, with all the non-prime
numbers crossed out,it has an integer array parameter so I set the function as public static String nonCrossedOutSubseqToString(int[] finalSequence)         
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:Yes, I used an if statement which check if the array is null.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:Yes,I created an array with all non-prime parts replaced by zeros using the sieve function,and then
I removed every zero in the array which contains only the prime numbers.
6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5
Comments:Yes, I used a Scanner to ask for input,  I used a hasNextInt() method to check for invalid input and
an error message will be print out.
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:  Yes,I called  createSquence,crossOutHigherMultiples, sequenceToString,and nonCrossedOutSubseqToString 
functions.
Did I print the output as shown in the question?  
Mark out of 5:5
Comment: Yes, the entire sequence is first printed and then the sequence with all the multiples of the first prime number(2)
and the second etc with square brackets and finally the prime numbers only sequence will be print out.
7.  Overall
Is my code indented correctly?
Mark out of 4:4
Comments:Yes, i follow the two space indent for the code block, for example, main method relative to class, 
                 code within the methods.
Do my variable names make sense?
Mark out of 4:4
Comments:Yes,variables such as index,newSequence orginalSequence etc all make sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:3
Comments:Yes, all my variables and method names are in lowerCammelCase,for example,newSequence,createSequence,
my class name is also the same as the file name.
   Total Mark out of 100 (Add all the previous marks): 99
*/


public class SieveofEratosthenes {

	public static int[] createSequence(int num) {

		int sequence[] = new int[num - 1];

		for (int index = 2; index <= num; index++) {

			sequence[index - 2] = index;
		}

		return sequence;

	}

	public static void crossOutHigherMultiples(int[] sequence, int x) {

		if (sequence != null) {

			for (int index1 = x-2; index1 < sequence.length; index1++) {

				if (sequence[index1] % x == 0 && sequence[index1] != x) {
					sequence[index1] = 0;
				}
			}

		}
	}

	public static int[] sieve(int num) {

		int[] numSequence = createSequence(num);

		for (int currentNumber = 2; currentNumber <= Math.sqrt(num); currentNumber++) {
			if(numSequence[currentNumber-2]!=0) {
				crossOutHigherMultiples(numSequence, currentNumber);
				
				System.out.println(sequenceToString(numSequence));
			}
	
		}
		return numSequence;
	}


	public static String sequenceToString(int[] newSequence) {
		
		
			if(newSequence!=null) {
			String stringArray = "";
			int[] originalSequence = createSequence(newSequence.length + 1);

			for (int index3 = 0; index3 < newSequence.length; index3++) {
				if (index3 == newSequence.length - 1) {
					if (newSequence[index3] != 0) {
						stringArray = stringArray + newSequence[index3];
						return stringArray;
					} else {
						stringArray = stringArray + "[" + originalSequence[index3] + "]";
						return stringArray;
					}
				}
				if (newSequence[index3] != 0) {

					stringArray = stringArray + newSequence[index3] + ",";
				} else {
					stringArray = stringArray + "[" + originalSequence[index3] + "]" + ",";
				}

			}
			
			return stringArray;}
			return null;
			
		}
	

	public static String nonCrossedOutSubseqToString(int[] finalSequence) {
		String stringArray = "";
		if(finalSequence!=null) {
		
		for (int index4 = 0; index4 < finalSequence.length; index4++) {
			if (finalSequence[index4] != 0) {

				if (index4 != finalSequence.length - 1) {
					stringArray = stringArray + finalSequence[index4] + ",";

				} else {
					stringArray = stringArray + finalSequence[index4];
					return stringArray;
				}
			}
		}
	
		}
		return stringArray;
	}
	
	public static void main(String[] args) {
		System.out.println("enter a number above 2");
		Scanner input = new Scanner(System.in);
		if (!input.hasNextInt()) {
			System.out.println("please enter a vaild integer");
		}
		int num = input.nextInt();

		int[] sequence = createSequence(num);
		for (int index5 = 0; index5 < sequence.length; index5++) {
			System.out.print(sequence[index5]);
			if (index5 != sequence.length - 1)
				System.out.print(",");
		}

		System.out.println();

		int[] processedSequence = sieve(num);
		
		
		System.out.println(nonCrossedOutSubseqToString(processedSequence));

	}
}
