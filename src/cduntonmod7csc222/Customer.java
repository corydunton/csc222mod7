package cduntonmod7csc222;

/**
 * Customer class used to describe a Customer object
 * 
 * @author db2admin
 *
 **/

public class Customer implements Comparable<Customer> {

	// three private fields
	/**
	 * used to hold the Customer's last name
	 */
	private String last;
	/**
	 * used to hold the Customer's first name
	 */
	private String first;
	/**
	 * a unique Customer id - generated by the program
	 */
	private int id;
	/**
	 * a static variable used to make Customer numbers unique NOTE: this should be
	 * private unless you need to access it from another class We will not need that
	 * here---but will need to do so if you were writing and reading files, so I
	 * made it public in case that extension was needed
	 */
	public static int num = 200;

	/**
	 * Full Constructor - used to create a new customer Creates a new unique id for
	 * them
	 * 
	 * @param custLast  - Customer last name
	 * @param custFirst - Customer first name
	 */

	public Customer(String custLast, String custFirst) {
		last = custLast;
		first = custFirst;
		id = num;
		num++;
	}

	/**
	 * empty constructor but still creates a unique id for them
	 * 
	 */
	public Customer() {
		id = num;
		num++;
	}

	/**
	 * used for reading back from a file where id is already set read the id - do
	 * not create a new one
	 * 
	 * @param custLast  - Customer last name
	 * @param custFirst - Customer first name
	 * @param idNum     - Customer ID
	 * 
	 */

	public Customer(String custLast, String custFirst, int idNum) {
		last = custLast;
		first = custFirst;
		id = idNum;

	}

	/**
	 * used to convert the object to a String output
	 * 
	 * @see java.lang.Object#toString()
	 */

	public String toString() {
		return first + " " + last + ",Id=" + id;
	}

	/**
	 * used for writing to a file
	 * 
	 * @return String
	 */
	public String toStringF() {
		return first + "|" + last + "|" + id;
	}

	/**
	 * used to define how to compare two Customer objects
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 **/
	public int compareTo(Customer c) {

		if ((c.getLast() + c.getFirst()).compareTo(getLast() + getFirst()) > 0)
			return 1;
		else if ((c.getLast() + c.getFirst()).compareTo(getLast() + getFirst()) < 0)
			return -1;
		else
			return 0;

	}

	/**
	 * used to get the first name
	 * 
	 * @return a String that is the first name
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * used to get the id
	 * 
	 * @return a String that is the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * used to get the last name
	 * 
	 * @return a String that is the last name
	 */
	public String getLast() {
		return last;
	}

	/**
	 * used to set the first name
	 * 
	 * @param String - the first name
	 */
	public void setFirst(String string) {
		first = string;
	}

	/**
	 * used to set the id
	 * 
	 * @param int - that is the id
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * used to set the last name
	 * 
	 * @param string that is the last name
	 */
	public void setLast(String string) {
		last = string;
	}

}
