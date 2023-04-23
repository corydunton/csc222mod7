/**
 * robustInput.java
 * Accepts two inputs (integer and double) and handles abnormal input gracefully
 * Created by philip alexander on 4-3-2009 
 */
package robustInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RobustInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int myInt;
		double myDouble;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Gimme an int");
		
		while (true) {
			try {
				myInt = scan.nextInt();
				System.out.println("Hello!");
				break;
			}
			catch(InputMismatchException ex) {
				System.out.println("Bad Input!  Try again");
				scan.nextLine();
			}
		}

		
		System.out.println("You entered for the int: " + myInt);

		
		System.out.println("Gimme a double");
		
		while (true) {
			try {
				myDouble = scan.nextDouble();
				break;
			}
			catch(Exception ex) {
				System.out.println("Bad Input!  Try again");
				scan.nextLine();
			}
		}

		
		System.out.println("You entered for the double: " + myDouble);
	}
}