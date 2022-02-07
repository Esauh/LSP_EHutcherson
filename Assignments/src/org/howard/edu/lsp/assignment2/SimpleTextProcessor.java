package org.howard.edu.lsp.assignment2;
import java.util.Scanner;
import java.util.StringTokenizer;  
/**
 * @author Esau Hutcherson
 * @version 1.0
 */

public class SimpleTextProcessor{
	
public static int sum = 0, product = 1; //need to be static the values are not destroyed until the program is ended

/**
 * processInput created to obtain user input and determine the 
 * amount and desired elements wanted to be adding/multiplied along with numbers inputed. 
 * Also determines when the user wants the program to end denotted by the user entering in Goodbye
 */
public static void receiveInput() {
	
Scanner scan = new Scanner(System.in); //Scanner object created

while(true) {
	
	System.out.println("String?");
	
	String value = scan.nextLine(); //user inputed is inserted and put into the string variable named value
	
	if(value.equals("Goodbye")) //If the user enters Goodbye exit/break out of the while loop ended the program
		break;

	else {
		/*
	 	StringTokenizer object created put into the name tokens which is 
	 	used to print out all of the numbers inputed by the user
		 */
		StringTokenizer tokens = new StringTokenizer(value," "); 
		
		sum = 0; // Done so every loop the sum is returned to 0

		product = 1; //Done so evey loop the product is returned to 1

		convertValue(value); //scanString method is called adding the numbers inputed and multiplying them together thus changing sum and product

		System.out.println("Tokens: ");

		while(tokens.hasMoreTokens()) { //while tokens has elements in the object created continue to print out the next element (token) in the object
	
				System.out.println(tokens.nextToken()); 
}

System.out.println("Sum: " + sum);//prints the sum

System.out.println("Product: " + product); //prints the product

}
}
}

/**
 * 
 * @param value parameter given by the processInput function which is the string of the user input
 * scanString created to change the string value of the user input into integers using parseInt 
 */
public static void convertValue(String value) {
	
int number = 0;

int index = 0; 

int begin = 0;

while(true) {
	/*
	 indexOf utilized to find the index wherein the first space is located if no 
	 space is in the string then -1 is returned into index exiting out of the if loop
	 */
	index = value.indexOf(' '); 
	
	if(index == -1)
		break;
	
	else {
		/*
  		number is assigned to the first value (token) in the user input as the index corresponds 
  		to each space which denotes a new token/number. parseInt is needed to convert the string
  		into integer values and can be added and multiplied 
		 */
		number = Integer.parseInt(value.substring(begin, index)); 
		
		sum += number;
		
		product *= number;
}

/*
 value changed a substring beginning at one space after the index which is 
 the user inputed space to denote a new token and ending at the end of the string
 length needs to not be decremented by one to allow the ending space to be included 
 allowing the while and if loop to be broken out of
*/
	value = value.substring(index + 1, value.length()); 

}
number = Integer.parseInt(value); //takes the user input turns it into a int and passes it into number

sum += number; //increments sum by number

product *= number;//multiplies product by number (product started at 1)

}
/**
 * 
 * @param args 
 * main function to run the above methods 
 */
public static void main(String args[]) {
	
receiveInput();

}

}