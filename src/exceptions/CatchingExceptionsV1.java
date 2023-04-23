package exceptions;

import java.util.Scanner;

public class CatchingExceptionsV1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // scanner for input

		System.out.print("Please enter an integer numerator: ");
		int num = scanner.nextInt();
		System.out.print("Please enter an integer denominator: ");
		int denom = scanner.nextInt();

		int result = num / denom;
		System.out.println("Answer of " + num + "/" + denom + "=" + result);
	}

}
