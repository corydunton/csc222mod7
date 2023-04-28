package cduntonmod7csc222;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import cduntonm7q1.FileLoc;

public class MenuInfo {

	public static void loadData(ArrayList<Customer> cust, ArrayList<Insurance> ins) {		

	}
	
	public static void printAllCustomers(ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);
		for (Customer c : cust) {
			System.out.println(c.toString());
		}
		System.out.println();
		System.out.println("Press enter to see the menu.");
		scan.nextLine();
	}

	// write a printAllInsurance method that prints out the toString method for
	// all of the insurance policies
	public static void printAllInsurance(ArrayList<Insurance> insure) {
		Scanner scan = new Scanner(System.in);
		for (Insurance ins : insure) {
			System.out.println(ins.toString());
		}
		System.out.println();
		System.out.println("Press enter to see the menu.");
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
		
		System.out.println("Press enter to see the menu.");
		scan.nextLine();
	}

	// write a getCustomer method that prints the information for all of the
	// policies for a given customer
	// that customer number is passed in. If none, have it print
	// "There are no policies for that customer"
	public static void getCustomer(ArrayList<Insurance> insure, int num) {
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
	}	
	
	// write a method that sorts the policies by customer number
	// this one is tougher since you can not use the Collections.sort() method
	// permanently changes the order of the list
	public static void sortCustNum(ArrayList<Insurance> insure) {

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
	}

	// write a method that sorts the policies by policy number
	// look at the example in the search_sort package
	// permanently changes the order of the list
	public static void sortPolNum(ArrayList<Insurance> insure) {
		Collections.sort(insure);
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
		
		System.out.println();
		System.out.println("Your file has been written. Press enter to see the menu.");
		scan.nextLine();
	}

	public static void readData(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
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
		
		System.out.println();
		System.out.println("Press enter to see the menu.");
		scan.nextLine();
	}
	
	public static void clearData(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		ins.clear();
		cust.clear();
	}
	
	public static void addCust(ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Customer first name: ");
		String first = scan.nextLine();
		System.out.println("Customer last name: ");
		String last = scan.nextLine();
		Customer c = new Customer(last, first);
		cust.add(c);
	}
	
	public static void addPolicy(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		
		
		// Need to work on this method.
		// polSelect is not working properly in the if statements
		// also need booleans to loop if invalid response
		
		
		
		Scanner scan = new Scanner(System.in);
		boolean invalid = true;
		int custSelect = 0;
		while (invalid) {
			System.out.println("Which customer?");
	
			for (int i = 0; i < cust.size(); i++) {
				System.out.println(i+1 + ":\t" + cust.get(i).toString());
			}
			custSelect = scan.nextInt();
			scan.nextLine();
			
			if (custSelect > cust.size()+1) {
				System.out.println("Invalid choice");
				invalid = true;
			}
			else {
				invalid = false;
			}
		}
		
		boolean invalid2 = true;
		while (invalid2) {
			System.out.println("What type of policy? (A) Auto, (R) Art, (H) Health, or (L) Life?");
			String polSelect = scan.nextLine();
			polSelect = polSelect.toLowerCase();
			
			if (polSelect == "a") {
				System.out.println("How many cars do you have?");
				int numCars = scan.nextInt();
				//scan.nextLine();
				ins.add(new AutoInsurance(cust.get(custSelect), numCars));
				invalid2 = false;
			}
			
			else if (polSelect == "r") {
				System.out.println("What is the description of the piece?");
				String desc = scan.nextLine();
				System.out.println("What is its value?");
				int val = scan.nextInt();
				//scan.nextLine();
				ins.add(new ArtInsurance(cust.get(custSelect), desc, val));
				invalid2 = false;
			}
			
			else if (polSelect == "h") {
				System.out.println("How many dependents do you have?");
				int numDependents = scan.nextInt();
				//scan.nextLine();
				ins.add(new HealthInsurance(cust.get(custSelect), numDependents));
				invalid2 = false;
			}
			
			else if (polSelect == "l") {
				System.out.println("How much insurance would you like?");
				int amount = scan.nextInt();
				System.out.println("What is your age?");
				int age = scan.nextInt();
				//scan.nextLine();
				ins.add(new LifeInsurance(cust.get(custSelect), amount, age));
				invalid2 = false;
			}
			
			else {
				System.out.println("Invalid choice.");
				invalid2 = true;
			}
		}
	}
}
