package cduntonmod7csc222;

import java.util.*;

public class TrackInsurance extends MenuInfo {
	public static Scanner scan = new Scanner(System.in);

	// method that runs first
	public static void main(String[] args) throws Exception {
		// make an ArrayList of customers and insurance policies
		ArrayList<Customer> cust = new ArrayList<Customer>();
		// note - the ArrayList below can hold Insurance objects
		// but with inheritance, that includes Auto, Health, Life and Art
		ArrayList<Insurance> ins = new ArrayList<Insurance>();

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

		int choice = 0;
		while (choice >= 0) {
			choice = menu();
			if (choice == -1) {
					
			} else if (choice == 1) {
				printAllCustomers(cust);
			} else if (choice == 2) {
				printAllInsurance(ins);
			} else if (choice == 3) {
				System.out.println("Now lets find the information for a certain policy number");
				System.out.println("What policy number do you want to find?");
				int num = scan.nextInt();
				printPolicy(ins, num);
			} else if (choice == 4) {
				System.out.println("Now let's find all of the policies for a given customer");
				System.out.println("What is the customer id?");
				int custNum = scan.nextInt();
				getCustomer(ins, custNum);
			} else if (choice == 5) {
				sortCustNum(ins);
			} else if (choice == 6) {
				sortPolNum(ins);
			} else if (choice == 7) {
				
			} else if (choice == 8) {
				
			} else if (choice == 9) {
				
			} else if (choice == 10) {
				
			} else if (choice == 11) {
				
			} else if (choice == 999) {
				System.out.println("Bye!!!!!");
				choice = -1;
			}
		} // end while

	}

	public static int menu() {
		System.out.println("Choice:");
		System.out.println("  -1.    Load the fake data");
		System.out.println("   1.    Print all customers (call the toString method)");
		System.out.println("   2.    Print all insurance information (call the toString method)");
		System.out.println("   3.    Given a policy number, print the policy information");
		System.out.println("   4.    Find all of the policies for a given customer");
		System.out.println("   5.    Sort the insurance policy information by customer number");
		System.out.println("   6.    Sort the insurance policy information by policy number");
		System.out.println("   7.    Store the data in text files");
		System.out.println("   8.    Read the data from the text files");
		System.out.println("   9.    Clear all of the data in memory");
		System.out.println("   10.   Add a customer");
		System.out.println("   11.   Add a policy for a current customer");
		System.out.println("   999.  QUIT!!");
		System.out.println("\nCHOICE:");
		int value = scan.nextInt();
		return value;

	}

	// write a printAllCusts method that prints out the toString method for all
	// of the customers
	
}