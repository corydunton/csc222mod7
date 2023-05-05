package cduntonmod7csc222;

import java.io.*;
import java.util.*;
import cduntonm7q1.FileLoc;

public class MenuInfo {

	public static void loadData(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);
		ins.clear();
		cust.clear();
		// create some fake customers (used for testing the program)
		Customer c = new Customer("Duck", "Donald");
		Customer c1 = new Customer("Mouse", "Minnie");
		Customer c2 = new Customer("Mouse", "Mickey");
		Customer c3 = new Customer("Brown", "Charlie");

		// add the customers to the array list
		cust.add(c3);
		cust.add(c2);
		cust.add(c1);
		cust.add(c);

		// make and add some insurance policies to the ArrayList
		ins.add(new AutoInsurance(c, 2));
		ins.add(new AutoInsurance(c1, 3));
		ins.add(new HealthInsurance(c, 5));
		ins.add(new HealthInsurance(c2, 1));
		ins.add(new LifeInsurance(c, 30000, 65));
		ins.add(new LifeInsurance(c1, 400000, 34));

		// add your ArtInsurance instances here
		ins.add(new ArtInsurance(c1, "Mona Lisa", 500000));
		ins.add(new ArtInsurance(c, "The Starry Night", 400000));
		ins.add(new ArtInsurance(c, "The Last Supper", 390000));
		ins.add(new ArtInsurance(c1, "The Scream", 450000));
		ins.add(new ArtInsurance(c2, "Girl with a Pearl Earring", 350000));

		System.out.println("\nFake data loaded.");
		scan.nextLine();
	}

	public static void printAllCustomers(ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);
		if (cust.size() == 0) {
			System.out.println("\nThere are no customers. Press enter.");
			scan.nextLine();
		} else {
			for (Customer c : cust) {
				System.out.println(c.toString());
			}
			System.out.println("\nPress enter to see the menu.");
			scan.nextLine();
		}
	}

	// write a printAllInsurance method that prints out the toString method for
	// all of the insurance policies
	public static void printAllInsurance(ArrayList<Insurance> insure) {
		Scanner scan = new Scanner(System.in);
		for (Insurance ins : insure) {
			System.out.println(ins.toString());
		}
		System.out.println("\nPress enter to see the menu.");
		scan.nextLine();
	}

	// write a printPolicy method that prints the information for the policy
	// number
	// passed in or the statement "That policy does not exist" if it is not
	// present
	public static void printPolicy(ArrayList<Insurance> insure, int num) {
		Scanner scan = new Scanner(System.in);
		boolean exists = false;

		for (Insurance ins : insure) { // start for
			if (ins.getPolicyNumber() == num) {
				System.out.println(ins.toString());
				exists = true;
			}
		} // end for

		if (!exists) {
			System.out.println("*** That policy does not exist. ***");
		}

		System.out.println("\nPress enter to see the menu.");
		scan.nextLine();
	}

	// write a getCustomer method that prints the information for all of the
	// policies for a given customer
	// that customer number is passed in. If none, have it print
	// "There are no policies for that customer"
	public static void getCustomer(ArrayList<Insurance> insure, int num) {
		Scanner scan = new Scanner(System.in);
		boolean exists = false;

		for (Insurance ins : insure) { // start for
			if (ins.getCustomer().getId() == num) {
				System.out.println(ins.toString());
				exists = true;
				continue;
			}
		}
		if (!exists) {
			System.out.println("*** There are no policies for that customer. ***\n");
		}
		System.out.println("\nPress enter to see the menu.");
		scan.nextLine();
	}

	// write a method that sorts the policies by customer number
	// this one is tougher since you can not use the Collections.sort() method
	// permanently changes the order of the list
	public static void sortCustNum(ArrayList<Insurance> insure) {
		Scanner scan = new Scanner(System.in);
		for (int out = insure.size() - 1; out > 1; out--) {
			for (int in = 0; in < out; in++) {
				Insurance ins = insure.get(in);
				Insurance ins2 = insure.get(in + 1);
				int custId1 = ins.getCustomer().getId();
				int custId2 = ins2.getCustomer().getId();

				if (custId2 < custId1) {
					insure.set(in, ins2);
					insure.set(in + 1, ins);
				}
			}
		}
		System.out.println("\nSuccesfully sorted policies by customer number. Press enter.");
		scan.nextLine();
	}

	// write a method that sorts the policies by policy number
	// look at the example in the search_sort package
	// permanently changes the order of the list
	public static void sortPolNum(ArrayList<Insurance> insure) {
		Scanner scan = new Scanner(System.in);
		Collections.sort(insure);
		System.out.println("\nSuccesfully sorted policies by policy number. Press enter.");
		scan.nextLine();
	}

	public static void storeData(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);
		String fileName = FileLoc.pickLocOut();
		PrintWriter outputFile = null;

		try {
			outputFile = new PrintWriter(fileName);

			// Get data and write it to the file
			for (int i = 0; i < cust.size(); i++) {
				outputFile.println(cust.get(i).toString());
			}
			for (int i = 0; i < ins.size(); i++) {
				outputFile.println(ins.get(i).toString());
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception. Need to exit.");
			System.out.println(ioe.getMessage());
			System.exit(0);
		} finally {
			outputFile.close();
		}

		System.out.println("\nPress enter.");
		scan.nextLine();
	}

	public static void readData() { // what's the use of the ArrayLists?
		Scanner scan = new Scanner(System.in);
		// Get filename
		String data = FileLoc.pickLocRead();

		// Open file
		File file = new File(data);
		Scanner inputFile = null;

		try {
			inputFile = new Scanner(file);

			// Read lines from file
			while (inputFile.hasNext()) {
				String line = inputFile.nextLine();
				System.out.println(line);
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception. Need to exit");
			System.out.println(ioe.getMessage());
			System.exit(0);
		} finally {
			inputFile.close();
		}

		System.out.println("\nPress enter to see the menu.");
		scan.nextLine();
	}

	public static void clearData(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);
		ins.clear();
		cust.clear();
		System.out.println("\nData cleared succesfully. Press enter.");
		scan.nextLine();
	}

	public static void addCust(ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Customer first name: ");
		String first = scan.nextLine();
		System.out.println("Customer last name: ");
		String last = scan.nextLine();
		Customer c = new Customer(last, first);
		cust.add(c);
		System.out.println("\nCustomer added succesfully. Press enter.");
		scan.nextLine();
	}

	public static void addPolicy(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);
		int custSelect = 0;
		boolean invalid = true;
		while (invalid) {
			System.out.println("Which customer?");

			for (int i = 0; i < cust.size(); i++) {
				System.out.println(i + 1 + ":\t" + cust.get(i).toString());
			}
			custSelect = scan.nextInt();
			scan.nextLine();
			custSelect -= 1;

			if (custSelect > cust.size()) {
				System.out.println("Invalid choice");
				invalid = true;
			} else {
				invalid = false;
			}
		}

		boolean invalid2 = true;
		while (invalid2) {
			System.out.println("What type of policy? (A) Auto, (R) Art, (H) Health, or (L) Life?");
			String polSelect = scan.nextLine();

			if (polSelect.equalsIgnoreCase("A")) {
				System.out.println("How many cars do you have?");
				int numCars = scan.nextInt();
				ins.add(new AutoInsurance(cust.get(custSelect), numCars));
				invalid2 = false;
			}

			else if (polSelect.equalsIgnoreCase("R")) {
				System.out.println("What is the description of the piece?");
				String desc = scan.nextLine();
				System.out.println("What is its value?");
				int val = scan.nextInt();
				ins.add(new ArtInsurance(cust.get(custSelect), desc, val));
				invalid2 = false;
			}

			else if (polSelect.equalsIgnoreCase("H")) {
				System.out.println("How many dependents do you have?");
				int numDependents = scan.nextInt();
				ins.add(new HealthInsurance(cust.get(custSelect), numDependents));
				invalid2 = false;
			}

			else if (polSelect.equalsIgnoreCase("L")) {
				System.out.println("How much insurance would you like?");
				int amount = scan.nextInt();
				System.out.println("What is your age?");
				int age = scan.nextInt();
				ins.add(new LifeInsurance(cust.get(custSelect), amount, age));
				invalid2 = false;
			}

			else {
				System.out.println("Invalid choice.");
				invalid2 = true;
			}
		}
		scan.nextLine();
		System.out.println("Policy added succesfully. Press enter.");
		scan.nextLine();
	}
}
