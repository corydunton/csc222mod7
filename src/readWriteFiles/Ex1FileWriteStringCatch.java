package readWriteFiles;

import java.util.Scanner; // Needed for Scanner class
import java.io.*; // Needed for File I/O classes

/**
 * This program writes data to a file.
 */

public class Ex1FileWriteStringCatch {
	public static void main(String[] args) {
		String filename; // File name
		String friendName; // Friend's name
		int numFriends; // Number of friends
		// Create a Scanner object for keyboard input.
		Scanner scan = new Scanner(System.in);

		// Get the number of friends.
		System.out.print("How many friends do you have? ");
		numFriends = scan.nextInt();

		// Consume the remaining newline character.
		scan.nextLine();

		// Get the filename.
		filename = FileLoc.pickLocOut();
		
		// Open the file.
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(filename);
			// Get data and write it to the file.
			for (int i = 0; i < numFriends; i++) {
				// Get the name of a friend.
				System.out.print("Enter the name of friend " + "number " + (i + 1) + ": ");
				friendName = scan.nextLine();

				// Write the name to the file.
				outputFile.println(friendName);
			}

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			outputFile.close();
		}
		scan.close();
		System.exit(0);
	}
}
