package cduntonmod7csc222;

public class ArtInsurance extends Insurance {
	
	String description;
	double value;
	
	public ArtInsurance(Customer cust, String desc, double worth) {
		super(cust);
		description = desc;
		value = worth;
		calcRate();
	}
	
	public ArtInsurance() {
		
	}
	
	// full constructor if reading from a file
	public ArtInsurance(Customer cust, int polNum, double yrRate, String desc, double worth) {
		super(cust, polNum, yrRate);
		description = desc;
		value = worth;
	}
	
	public void calcRate() {
		yearlyRate = .025 * value;
		
	}
	
	// to String. Let the Insurance class print out its fields and let this class
	// print out new fields
	// we override the toString method from the Insurance class
	public String toString() {
		return super.toString() + " for art insurance. The art work is "
				+ description + ", and the value is " + value + ".";
	}
	
	public String toStringF() {
		return "ART|" + super.toStringF() + "|" + value;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}


}
