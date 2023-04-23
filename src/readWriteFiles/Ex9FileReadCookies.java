package readWriteFiles;

import java.util.ArrayList;
import java.util.Scanner; // Needed for the Scanner class
import java.util.StringTokenizer;
import java.io.*; // Needed for the File class

/**
 * This program reads data from a file.
 */

public class Ex9FileReadCookies {
	public static void main(String[] args) {
		// Create a Scanner object for keyboard input.
		Scanner scan = new Scanner(System.in);
		// create your ArrayList for storing the data
		ArrayList<Cookies> cookies = loadData();
		printCookies(cookies);
		scan.close();
		System.exit(0);

	}

	public static ArrayList<Cookies> loadData() {
		ArrayList<Cookies> cookies = new ArrayList<>();
		// Get the filename.
		String filename = FileLoc.pickLocRead();

		// Open the file.
		File file = new File(filename);
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(file);

			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read the next line.
				String line = inputFile.nextLine();
				// create a StringTokenizer and break the line at the | symbols
				StringTokenizer st = new StringTokenizer(line, "|");
				// we know that the line looks like chocolate chip|2.0|12
				// we need to get each field, make the object, and then add it to the ArrayList
				String type = st.nextToken();
				double cost = Double.parseDouble(st.nextToken().trim());
				int num = Integer.parseInt(st.nextToken().trim());
				Cookies c = new Cookies(type, cost, num);
				cookies.add(c);
			}

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();
		}
		

		return cookies;

	}

	public static void printCookies(ArrayList<Cookies> c) {
		System.out.println("Here are your cookies:");
		for (int i = 0; i < c.size(); i++)
			System.out.println(c.get(i).toString());
	}
}
