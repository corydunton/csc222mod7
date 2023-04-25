package cduntonm7q1;

// This program reads in "The Hill We Climb" poem.

// Program should create an ArrayList<String> that stores the poem line by line.
// Have it print out the number of lines in the poem
// Next ask the user how many of the lines they want to process
// Then have it print out the first word of this many lines of the poem.
// Make words lower-case


// Need FileDialog for saving txt file
import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import readWriteFiles.FileLoc;

public class TheHill {
	


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> string = new ArrayList<String>();
		// Get filename
		String theHillWeClimb = FileLoc.pickLocRead();
		// Open file
		File file = new File(theHillWeClimb);
		Scanner inputFile = null;
		int counter = 0;
		
		try {
			inputFile = new Scanner(file);
			
			// Read lines from file
			while (inputFile.hasNext()) {
				String line = inputFile.nextLine();
				if (!line.isEmpty()) {
					string.add(line);
					System.out.println(line);
					counter++;
				}
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception. Need to exit");
			System.out.println(ioe.getMessage());
			System.exit(0);
		} finally {
			inputFile.close();
		}
		
		System.exit(0);
	}
}
