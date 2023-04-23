package exceptions;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CookiesFileBad {

	public static void main(String[] args) {
		
		ArrayList<Cookies> inputCooks = inputData();
		print(inputCooks);
		System.exit(0);
		

	}
	
	
	
	public static BufferedReader openRead() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for reading your file", FileDialog.LOAD);
		System.out.println("The dialog box will appear behind Eclipse.  " + 
		      "\n   Choose where you would like to read from.");
		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();

		// create a file instance for the absolute path
		File inFile = new File(dirPath + foName);
		if (!inFile.exists()) {
			System.out.println("That file does not exist");
			System.exit(0);
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inFile));
		} catch (IOException e) {
			System.out.println("You threw an exception. ");
		}
		return in;

	}

	

	public static ArrayList<Cookies> inputData() {
		ArrayList<Cookies> yum = new ArrayList<Cookies>();
		Scanner scan = new Scanner(System.in);
		
		BufferedReader bf = null;
		try {
			// Open the file.
			bf = openRead();

			// read in the first line
			String line = "";
			try {
				line = bf.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//System.out.println("What is the delimiter(s)?");
			//String delim = scan.nextLine();

			// while there is more data in the file, process it
			while (line != null) {    //more lines
				StringTokenizer st = new StringTokenizer(line,"|");
				//while (st.hasMoreTokens()) {    //more items on each line  NOT NEEDED HERE!!

					// this is what you change based on the application
					String name = st.nextToken().trim();
					double cost = Double.parseDouble(st.nextToken().trim());
					int num = Integer.parseInt(st.nextToken().trim());
					Cookies cookies = new Cookies(name, cost, num);
					yum.add(cookies);
				//}
				// read in the next line
				try {
					line = bf.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // end of reading in the data.

		}
		// catch any other type of exception
		catch (Exception e) {
			System.out.println("Other weird things happened");
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (Exception e) {
			}
		}
		return yum;

	}

	
	public static void print(ArrayList<Cookies> cook) {
		for (int i=0;i<cook.size();i++)
			System.out.println(cook.get(i).toString());
	}

}
