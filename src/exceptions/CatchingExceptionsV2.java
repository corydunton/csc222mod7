package exceptions;

import java.util.*;

public class CatchingExceptionsV2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // scanner for input
		boolean correctData = false;

		while (!correctData) {
			try // read two numbers and calculate quotient
			{
				System.out.print("Please enter an integer numerator: ");
				int num = scanner.nextInt();
				System.out.print("Please enter an integer denominator: ");
				int denom = scanner.nextInt();

				int result = num / denom;
				System.out.println("Answer of " + num + "/" + denom + "="
						+ result);
				correctData = true; // input has good data
			} // end try
			catch (InputMismatchException iME) {
				System.err.println("\nException: " + iME);
				scanner.nextLine(); // discard input so user can try again
				System.out.println("The input must be integers. Try again.\n");
			} // end catch
			catch (ArithmeticException aE) {
				System.err.println("\nException: " + aE);
				System.out
						.println("You cannot divide by zero. Please try again.\n");
			} // end catch
		} // end do...while
	} // end main
} // end class CatchingExceptions

