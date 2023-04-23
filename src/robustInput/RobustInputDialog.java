package robustInput;

import java.util.ArrayList;
import javax.swing.*;

public class RobustInputDialog {
	public static void main(String[] args) 
    {
	//How do you check to see that at least something was entered.	
		boolean bad = true;
		while (bad) {			
			
			
				String first = JOptionPane.showInputDialog("Input a string:");
				// Note - the line below shows that if you hit "cancel" it is equivalent to null
				// But null is NOT a null pointer.
				// So we check that it is not null and is not blank.
				// so if you do a try/catch like in the next example, it does not work
				System.out.println(first);
				if(first!=null && !first.equals(""))
					bad = false;
			
		}
		
		// This does NOT work.
		 bad = true;
		while (bad) {			
			
			try {
				String name2 = JOptionPane.showInputDialog("Input a string:");
				bad = false;
			} catch (NullPointerException np) {
				JOptionPane.showMessageDialog(null,
						"You must enter something.  Press OK to try again");
			}
		}
		
		
		
		// For a number entry that you are parsing, you do want the NullPointer exception
		// because it is being thrown from the parseDouble() method
		bad=true;		
		while(bad)
		{
			String hrsStr = JOptionPane.showInputDialog("Give me a double:");
			try {
				double hrs = Double.parseDouble(hrsStr);
				bad = false;
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,
						"Invalid number.  Press OK to try again");
			} catch (NullPointerException np) {
				JOptionPane.showMessageDialog(null,
						"You must enter something.  Press OK to try again");
			}
		}
		System.out.println("All data is valid!");
			
}
	
}
