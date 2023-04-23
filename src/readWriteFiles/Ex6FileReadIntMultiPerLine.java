package readWriteFiles;

import java.util.ArrayList;
import java.util.Scanner; // Needed for the Scanner class
import java.util.StringTokenizer;
import java.io.*; // Needed for the File class

/**
 * This program reads data from a file.
 */

public class Ex6FileReadIntMultiPerLine {
	public static void main(String[] args)  {
		// Create a Scanner object for keyboard input.
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();

		// Get the filename.
		String filename = FileLoc.pickLocRead();

		// Open the file.
		File file = new File(filename);
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(file);

			int total = 0;
			int numGrades = 0;
			System.out.print("Grades: ");

			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read the next line.
				String line = inputFile.nextLine();
				// create a StringTokenizer and break the line at the spaces
				// I use the StringTokenizer - more flexible than the Scanner for complex
				// objects
				StringTokenizer st = new StringTokenizer(line, " ,");
				// while the line has more "tokens" or values
				while (st.hasMoreTokens()) {
					// get the next one and convert it to an int
					int grade = Integer.parseInt(st.nextToken().trim());
					al.add(grade);
					System.out.print(grade + " ");
					// add its value to the total
					total = total + grade;
					// increment the number of grades so far
					numGrades++;
				}
			}

			double ave = 1.0 * total / numGrades;
			System.out.println("\nThe average grade was " + ave);

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();
		}
		scan.close();
		System.exit(0);
	}
}
