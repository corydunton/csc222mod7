package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CatchingExceptionsV1a {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // scanner for input
		int num;
		try {
			System.out.print("Please enter an integer numerator: ");
			num = scanner.nextInt();
			System.out.print("Please enter an integer denominator: ");
			int denom = scanner.nextInt();

			int result = num / denom;
			System.out.println("Answer of " + num + "/" + denom + "=" + result);
		} catch (ArithmeticException ae) {
			System.out.println("You tried to divide by zero!");
		} catch (InputMismatchException ime) {
			System.out.println("You did not enter an integer!");
			ime.printStackTrace();
		} catch (Exception e) {
			System.out.println("You threw something else!");
		}
		// program continues....
		System.out.println("This line runs regardless");

	}

}
