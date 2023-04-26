package cduntonm7q1;

// This program reads in "The Hill We Climb" poem

// Program should create an ArrayList<String> that stores the poem line by line
// Have it print out the number of lines in the poem
// Next ask the user how many of the lines they want to process
// Then have it print out the first word of this many lines of the poem.
// Make words lower-case

// Need FileDialog for opening txt file
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TheHill {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> poem = new ArrayList<String>();

		// Get filename
		String theHillWeClimb = FileLoc.pickLocRead();

		// Open file
		File file = new File(theHillWeClimb);
		Scanner inputFile = null;

		try {
			inputFile = new Scanner(file);

			// Read lines from file
			while (inputFile.hasNext()) {
				String line = inputFile.nextLine();
				if (!line.isEmpty()) {
					poem.add(line);
				}
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception. Need to exit");
			System.out.println(ioe.getMessage());
			System.exit(0);
		} finally {
			inputFile.close();
		}

		printLines(poem);
		System.exit(0);

	}

	public static void printLines(ArrayList<String> poem) {
		Scanner scan = new Scanner(System.in);
		System.out.println("The number of non-blank lines in the poem: " + poem.size());
		System.out.println("In how many lines do you want to see the first word?");
		int numLines = scan.nextInt();
		System.out.println("First words of the first " + numLines + " lines (lower-case):");
		for (int i = 0; i < numLines; i++) {
			String[] words = poem.get(i).split(" ");
			System.out.print(words[0].toLowerCase() + " ");
		}
	}
}
