package readWriteFiles;

import java.util.ArrayList;
import java.util.Scanner; // Needed for Scanner class

import java.io.*; // Needed for File I/O classes

public class Ex8FileWriteCookies {
	public static void main(String[] args) {
		String filename; // File name
		ArrayList<Cookies> cook = loadData();
		Scanner scan = new Scanner(System.in);

		// Get the filename.
		filename = FileLoc.pickLocOut();

		// Open the file.
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(filename);

			// Get data and write it to the file.
			for (int i = 0; i < cook.size(); i++) {
				Cookies c = cook.get(i);
				// Write the object. Note we are writing the toStringF() that is pipe delimited
				outputFile.println(c.toStringF());
			}

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

	public static ArrayList<Cookies> loadData() {
		ArrayList<Cookies> cook = new ArrayList<Cookies>();
		cook.add(new Cookies("chocolate chip", 2.00, 12));
		cook.add(new Cookies("peanut butter", 3.00, 8));
		cook.add(new Cookies("oatmeal", 2.50, 24));
		cook.add(new Cookies("Oreos", 4.10, 30));
		cook.add(new Cookies("snickerdoodles", 3.25, 24));
		return cook;

	}
}
