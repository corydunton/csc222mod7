package readWriteFiles;
import java.util.Scanner;   // Needed for Scanner class
import java.io.*;           // Needed for File I/O classes

/**
   This program writes data to a file.
*/

public class Ex1FileWriteString
{
   public static void main(String[] args) throws IOException
   {
	   String filename;      // File name
	   String friendName;    // Friend's name
	   int numFriends;       // Number of friends
      // Create a Scanner object for keyboard input.
      Scanner scan = new Scanner(System.in);
      
      // Get the number of friends.
      System.out.print("How many friends do you have? ");
      numFriends = scan.nextInt();

      // Consume the remaining newline character.
      scan.nextLine();
      
      // Get the filename.
     filename = FileLoc.pickLocOut();

      // Open the file.
      PrintWriter outputFile = new PrintWriter(filename);

      // Get data and write it to the file.
      for (int i = 0; i < numFriends; i++)
      {
         // Get the name of a friend.
         System.out.print("Enter the name of friend " +
                          "number " + (i+1) + ": ");
         friendName = scan.nextLine();

         // Write the name to the file.
         outputFile.println(friendName);
      }

      // Close the file.
      outputFile.close();
      System.out.println("Data written to the file.");
      scan.close();
      System.exit(0);
   }
}
