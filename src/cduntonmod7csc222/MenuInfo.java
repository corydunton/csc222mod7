package cduntonmod7csc222;

import java.util.ArrayList;
import java.util.Collections;

public class MenuInfo {

	public static void loadData(ArrayList<Customer> cust, ArrayList<Insurance> ins) {		

	}
	
	public static void printAllCustomers(ArrayList<Customer> cust) {
		for (Customer c : cust) {
			System.out.println(c.toString());
		}
		System.out.println();
	}

	// write a printAllInsurance method that prints out the toString method for
	// all of the insurance policies
	public static void printAllInsurance(ArrayList<Insurance> insure) {
		for (Insurance ins : insure) {
			System.out.println(ins.toString());
		}
		System.out.println();
	}

	// write a printPolicy method that prints the information for the policy
	// number
	// passed in or the statement "That policy does not exist" if it is not
	// present
	public static void printPolicy(ArrayList<Insurance> insure, int num) {
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
	
	public static void clearData(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		
	}
	
	public static void storeData(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		
	}

	public static void readData(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		
	}
	
	public static void addCust(ArrayList<Customer> cust) {
		
	}
	
	public static void addPolicy(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		
	}
}
