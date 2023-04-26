package cduntonmod7csc222;

// "extends" = inherits from
// So-- AutoInsurance gets all of the fields and methods from the Insurance class
// and can add or override any that it wants
public class AutoInsurance extends Insurance {

	// we add one field - the number of cars
	private int numCars;

	// full constructor - but since the full constructor for the Insurance class
	// sets customer, we pass it to that constructor.
	// super = "class above me"
	public AutoInsurance(Customer cust, int cars) {
		super(cust);
		numCars = cars;
		calcRate();
	}

	// empty constructor
	public AutoInsurance() {
	}

	// constructor for reading from a file
	public AutoInsurance(Customer cust, int polNum, double yrRate, int numC) {
		super(cust, polNum, yrRate);
		numCars = numC;

	}

	// we were required to write a complete calcRate method by the abstract method
	// in the
	// Insurance class. Must have the exact same signature
	public void calcRate() {
		yearlyRate = 500 * numCars;
	}

	// we override the toString method from the Insurance class
	public String toString() {
		return super.toString() + (" for auto insurance. The number of cars are " + numCars + ".");
	}
	
	public String toStringF() {
		return "AUT|" + super.toStringF() + "|" + numCars;
	}


	// getters and setters - only for the fields added by this class
	public int getNumCars() {
		return numCars;
	}

	public void setNumCars(int numCars) {
		this.numCars = numCars;
	}

}
