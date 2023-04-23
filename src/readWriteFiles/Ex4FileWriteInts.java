package readWriteFiles;

import java.util.Scanner; // Needed for Scanner class
import java.io.*; // Needed for File I/O classes

/**
 * This program writes multiple items per line to a data to a file.
 */

public class Ex4FileWriteInts {
	public static void main(String[] args) {
		String filename;

		// Create a Scanner object for keyboard input.
		Scanner scan = new Scanner(System.in);

		// Get the filename.
		filename = FileLoc.pickLocOut();
		// Open the file.
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(filename);

			int grade = 0;
			// loop and write out the grades to the file, one per line
			while (grade != -999) {
				System.out.println("Grade:  (-999 to end)");
				grade = scan.nextInt();
				if (grade != -999)
					outputFile.println(grade);
			}

			System.out.println("Data written to the file.");
		} catch (IOException ioe) {
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
