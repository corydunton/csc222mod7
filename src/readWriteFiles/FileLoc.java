package readWriteFiles;

import java.awt.FileDialog;
import java.awt.Frame;


public class FileLoc {

	public static void main(String[] args) {
		System.out.println("Methods for picking locations for reading and writing files");
		System.out.println("Pick the location for output");
		String out = pickLocOut();
		System.out.println(out);
		System.out.println("The location for writing the file will be : " + out);
		
		System.out.println("Pick the location for input");
		String in = pickLocRead();
		System.out.println(in);
		System.out.println("The location for reading the file will be : " + in);
	}
	
	public static String pickLocOut() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for writing your file", FileDialog.SAVE);
		System.out.println("The dialog box might appear behind Eclipse.  " + 
			      "\n   Choose where you would like to write your data.");
		
		
		foBox.setVisible(true);
		foBox.toFront();
		foBox.setAlwaysOnTop(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();
		String name = dirPath + foName;
		
		return name;
	}
	
	public static String pickLocRead() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog fiBox = new FileDialog(f, "Pick location for reading your file", FileDialog.LOAD);
		System.out.println("The dialog box might appear behind Eclipse.  " + 
			      "\n   Choose where you would like to read for your data.");
		fiBox.setVisible(true);
		fiBox.toFront();
		// get the absolute path to the file
		String fiName = fiBox.getFile();
		String dirPath = fiBox.getDirectory();

		// create a file instance for the absolute path
		String name = dirPath + fiName;
		return name;
	}

}
