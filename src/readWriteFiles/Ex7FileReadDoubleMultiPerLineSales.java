package readWriteFiles;

import java.util.Scanner; // Needed for the Scanner class
import java.util.StringTokenizer;
import java.io.*; // Needed for the File class
import java.text.NumberFormat;

/**
 * This program reads data from a file.
 */

public class Ex7FileReadDoubleMultiPerLineSales {
	public static void main(String[] args)  {
		// Create a Scanner object for keyboard input.
		Scanner scan = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getCurrencyInstance();

		// Get the filename.
		String filename = FileLoc.pickLocRead();

		// Open the file.
		File file = new File(filename);
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(file);

			double totalSales = 0;

			System.out.print("Your sales: ");

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
					double value = Double.parseDouble(st.nextToken().trim());
					System.out.print(nf.format(value) + " ");
					// add its value to the total
					totalSales = totalSales + value;
				}
			}

			System.out.println("\nThe total sales were " + nf.format(totalSales));

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
