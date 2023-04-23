package exceptions;

import java.text.NumberFormat;
import java.util.Scanner;

public class Cookies {
	
	// start with instance variables (or fields)
	//they must be private	
	private String name;
	private double costEach;
	private int number;
	
	//two constructors are required for our applications
	public Cookies() {	

	}

	public Cookies( String n, double c, int num) {
		name = n;
		costEach = c;
		number = num;
	}
	
	//you always need a toString() method for me
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return name + " cost " + nf.format(costEach) + " each and you ordered " + number;
	}
	

	public String toStringF() {
		return name + "|" + costEach + "|" + number;
	}
	
	//other methods go here	
	public double cost() {
		double amount = costEach * number;
		return amount;
	}

	//then your getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCostEach() {
		return costEach;
	}

	public void setCostEach(double costEach) {
		this.costEach = costEach;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
