
package readWriteObjectsWithMenu;

import java.text.NumberFormat;
import java.time.*;


public class Invoice {
	private Customer cust;
	private double amount;
	private LocalDate date;
	
	public Invoice()
	{
	}
	
	public Invoice( Customer c, double a, LocalDate d)
	{
		cust=c;
		amount=a;
		date=d;
	}
	public String toString()
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return cust.toString() + " has an invoice for " + nf.format(amount) + " on the date of " + date;
	}
	// we need a toStringF method that writes the pipe delimited file 
	// note how we let the customer write itself out by calling its toStringF first
	public String toStringF()
	{
		return cust.toStringF() + "|" + amount + "|" + date.toString();
	}
	
	

	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

		public Customer getCust() {
		return cust;
	}
	
	public void setAmount(double d) {
		amount = d;
	}
	
	public void setCust(Customer customer) {
		cust = customer;
	}

	
}
