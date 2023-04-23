
package readWriteObjectsWithMenu;

import java.io.*;
import java.time.LocalDate;

import java.util.*;

public class TokenizerInvoice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Invoice> inv = new ArrayList<Invoice>();
		int ans = 0;
		while (true) {
			menu();
			System.out.println("CHOICE:");
			ans = scan.nextInt();
			if (ans == 1) {
				// load up some fake data
				inv = loadData();
			}

			if (ans == 2) {
				// write a text file
				writeText(inv);
			}

			if (ans == 3) {
				// read a text file
				inv.clear();
				inv = readText();
			}

			if (ans == 4) {
				// print out the array list
				print(inv);
			}
			if (ans == 5) {
				// clear out all of the data
				inv.clear();
			}

			if (ans == 6) {
				System.out.println("See you later!");
				scan.close();
				System.exit(0);
			}

		}
	}

	public static void menu() {
		System.out.println("\n1.  Prime the data");
		System.out.println("2.  write a text file");
		System.out.println("3.  read from a text file");
		System.out.println("4.  print out the array list");
		System.out.println("5.  clear out all of the data");
		System.out.println("6.  exit\n");
	}

	public static ArrayList<Invoice> loadData() {
		// put some fake data into an ArrayList
		ArrayList<Invoice> inv = new ArrayList<Invoice>();
		Customer c1 = new Customer("Mouse", "Mickey");
		Customer c2 = new Customer("Mouse", "Minnie");
		Customer c3 = new Customer("Duck", "Donald");
		Invoice i = new Invoice(c1, 56000, LocalDate.of(2021, 10, 1));
		Invoice i2 = new Invoice(c2, 3000, LocalDate.of(2021, 11, 12));
		Invoice i3 = new Invoice(c3, 50000, LocalDate.of(2021, 9, 12));
		inv.add(i);
		inv.add(i2);
		inv.add(i3);
		return inv;
	}

	public static void writeText(ArrayList<Invoice> al) {
		String filename = FileLoc.pickLocOut();

		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(filename);

			// Get data and write it to the file.
			for (int i = 0; i < al.size(); i++) {
				Invoice in = al.get(i);
				// Write the object. Note we are writing the toStringF() that is pipe delimited
				outputFile.println(in.toStringF());
			}

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			outputFile.close();
		}

	}

	public static ArrayList<Invoice> readText() {
		ArrayList<Invoice> inv = new ArrayList<>();
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
				// create a StringTokenizer instance that will break the line apart at each | or
				// / symbols
				// NOTE: the second parameter is the symbols used to separate fields
				StringTokenizer t = new StringTokenizer(line, "|/-");

				// check to see if it is the next customer number that we wrote at the end of
				// the file
				// if it is, set the static num field to this value
				// but anything read from a text file is text so we must convert it to the
				// correct
				// data type (int). Also trim off any blanks or the conversion will blow up

				// the line in the text file looks like Mickey|Mouse|201 and will be broken into
				// three parts
				// Now get each token and put it in a variable
				String first = t.nextToken().trim();
				String last = t.nextToken().trim();
				int id = Integer.parseInt(t.nextToken().trim());
				// create a Customer instance for the data
				Customer c = new Customer(last, first, id);
				// read in the invoice amount
				double amt = Double.parseDouble(t.nextToken().trim());
				// get the information for the date
				int year = Integer.parseInt(t.nextToken().trim());
				int mon = Integer.parseInt(t.nextToken().trim());
				int day = Integer.parseInt(t.nextToken().trim());
				// create a Day instance
				LocalDate d = LocalDate.of(year, mon, day);
				// now create a invoice instance
				Invoice iv = new Invoice(c, amt, d);

				// add the instance to the ArrayList
				inv.add(iv);

			}
		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();
		}

		return inv;

	}

	// method to print out the ArrayList of customers. Note the two ways to print it
	public static void print(ArrayList<Invoice> al) {

		System.out.println("The invoice information: ");
		for (int i = 0; i < al.size(); i++) {
			Invoice inv = (Invoice) al.get(i);
			System.out.println(inv.toString());
		}

	}

}
