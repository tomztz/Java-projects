import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
/* SELF ASSESSMENT

1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

       Mark out of 5:5
       Comment:  Yes,I follow the coding standard specified the variable names in lowerCamelCase,
       for example,alphabetChiper.

2. Did I indent the code appropriately?

       Mark out of 5:5
       Comment:  Yes, i follow the two space indent for the code block, 
       for example, main method relative to class, code within the methods.

3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

      Mark out of 20:20
       Comment: Yes, firstly the function is correctly defined, I set it to be public and I want it to return a char array
        so I defined it as "public static char[] creatChipher(char[]alphabetChipher),which the normal alphabet is the parameter, and this function is correctly 
        called in the main method.
4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

      Mark out of 20: 20
       Comment:Yes, firstly the function is correctly defined, I set it to be public and I want it to return a char array,
        so I defined it as "public static char[] encrypt(char[]testChar,char[]alphabet,char[]chipherText),which take three char arrays as parameter, and this function is correctly 
        called in the main method.

5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

      Mark out of 20:20  
       Comment:Yes, firstly the function is correctly defined, I set it to be public and I want it to return a char array,
        so I defined it as "public static char[] decrypt(char[]encryptVersion,char[]alphabet,char[]chipherText),which take three char arrays as parameter, and this function is correctly 
        called in the main method.

6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

      Mark out of 25 :25
       Comment:Yes,it is repeatedly asking the user to type in a string until the user types quit, 
       the encrypted text is showed first and followed by the decrypted text.

7. How well did I complete this self-assessment?

       Mark out of 5:4
       Comment:During the self-assessment I carefully run through every question and go back to my codes and 
    check every line. I mark myself really strict and provide many evidence in the comment.

Total Mark out of 100 (Add all the previous marks):99

*/ 
public class Cipher {
	
	public static final int  LETTERS_AND_SPACE = 27;
	
	public static char[] creatChipher(char[]alphabetChipher) {
		
		
		Random rand = new Random();
		for(int index=0;index<LETTERS_AND_SPACE;index++) {
			
			int randomIndex = rand.nextInt(alphabetChipher.length);
			char temp=alphabetChipher[index];
			alphabetChipher[index]= alphabetChipher[randomIndex];
			alphabetChipher[randomIndex]=temp;
			
				}
			
		return alphabetChipher;
	}
	
	public static char[] encrypt(char[]testChar,char[]alphabet,char[]chipherText) {
		
		
		String alphabetString= new String(alphabet);
		for(int index1=0;index1<testChar.length;index1++) {
			
			testChar[index1]=chipherText[alphabetString.indexOf(testChar[index1])];
		}
		return testChar;
	}
	
	public static char[] decrypt(char[]encryptVersion,char[]alphabet,char[]chipherText){
		
		
		
		String chiphertextString=new String(chipherText);
		for (int index1=0;index1<encryptVersion.length;index1++) {
			encryptVersion[index1]=alphabet[chiphertextString.indexOf(encryptVersion[index1])];
		}
		return encryptVersion;
	}

		
		

	public static void main(String[] args) {
		while(true) {
		String input=JOptionPane.showInputDialog("enter a word to get decrypted or enter quit");
		Scanner testStringScanner=new Scanner(input);
		
		String testString=testStringScanner.next();
		String testStringLowerCase=testString.toLowerCase();
		
		if(testStringLowerCase.equals("quit")) {
			break;
		}
		
		String alphabet="abcdefghijklmnopqrstuvwxyz ";
		char[] alphabetArray=alphabet.toCharArray();
		char[] alphabetArray1=alphabetArray.clone();
		char[] testArray=testStringLowerCase.toCharArray();
		char[] chipherArray=creatChipher(alphabetArray1);
		
		char[] encryptArray=encrypt(testArray,alphabetArray,chipherArray);
		String encryptVersion=new String(encryptArray);
		JOptionPane.showInputDialog(null,encryptVersion);
		char[] decryptArray=decrypt(encryptArray,alphabetArray,chipherArray);
		String decryptVersion=new String(decryptArray);
		JOptionPane.showInputDialog(null,decryptVersion);
		}
	}

}
