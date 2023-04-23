package readWriteFiles;

import java.util.Scanner; // Needed for the Scanner class
import java.io.*; // Needed for the File class

/**
 * This program reads data from a file.
 */

public class Ex5FileReadInts {
	public static void main(String[] args) {
		// Create a Scanner object for keyboard input.
		Scanner scan = new Scanner(System.in);

		// Get the filename.
		String filename = FileLoc.pickLocRead();

		// Open the file.
		File file = new File(filename);
		Scanner inputFile = null;
		int total = 0;
		int numGrades = 0;
		try {
			inputFile = new Scanner(file);

			
			System.out.println("Grades:");

			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read the next int. The Scanner class can directly read it as an int
				int grade = inputFile.nextInt();
				System.out.print(grade + " ");
				total = total + grade;
				numGrades++;
			}

			
		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();
		}
		
		double ave = 1.0 * total / numGrades;
		System.out.println("The average grade was " + ave);
		scan.close();
		System.exit(0);
	}
}
