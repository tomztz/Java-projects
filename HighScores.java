import java.util.Arrays;
import java.util.Scanner;

public class HighScores {
	
	public static int[] initialiseHighScores(int maintainScore) {
		int[] scores= new int [maintainScore];
		for (int i=0;i<scores.length;i++) {
			scores [i]= 0;
		}
		return scores;
	}
	
	public static boolean higherThan(int [] highScoreList,int newScore) {
		
		for (int j=0;j<highScoreList.length;j++) {
			if(newScore>highScoreList[j]) {
				return true;
			}
			
		
			
		}
		return false;
		
	}
	public static int[] insertScore(int[] highScoreList,int newScore) {
		int currentNumber=0;
		
			 for(int z=0;z<highScoreList.length;z++) {
				 if(newScore>highScoreList[z]) {
					 currentNumber=highScoreList[z];
					 highScoreList[z]=newScore;
					 newScore=currentNumber;
					 
				 }
			 }
			 return highScoreList;
			
		
		
		}
	
	public static void printHighScores(int[] highScoreList) {
		System.out.println("The high scores are");
		for(int n=0;n<highScoreList.length;n++) {
			System.out.print(highScoreList[n]+",");
		}
		
	}

	public static void main(String[] args) {
		System.out.println("please enter the amount of scores you want to maintain");
		Scanner input= new Scanner(System.in);
		int numberOfScoresMaintain=input.nextInt();
		
		int[] initialList=initialiseHighScores(numberOfScoresMaintain);
		int[] newArray= {};
		
		while(true){
			System.out.println("enter the next score or enter quit");
			Scanner input1=new Scanner(System.in);
			if (!input1.hasNextInt()) {
				break;
			}
			int nextScore=input1.nextInt();
			boolean isHighScore=false;
			isHighScore=higherThan(initialList,nextScore);
			if (isHighScore==true) {
				
				newArray=insertScore(initialList,nextScore);
				
			}
			printHighScores(newArray);
			
		}

	}

}
