package exceptions_Gaddis_PC_1_2_page755;

public class TestScores_P1_page755
{
   // Variable to reference an array holding test scores
   private double[] scores;
   
  
      
   public TestScores_P1_page755(double[] s) throws IllegalArgumentException
   {
      // Create an array to hold the scores passed
      // as an argument.
      scores = new double[s.length];
      
      // Copy the scores passed as an argument into
      // the new array. Check for illegal values as
      // they are copied.
      for (int i = 0; i < s.length; i++)
      {
         if (s[i] < 0 || s[i] > 100)
            throw new IllegalArgumentException("Element: " + i + " Score: " + s[i]);
         else
            scores[i] = s[i];
      }
   }
   
   
   public double getAverage()
   {
      double total = 0.0;  // Accumulator
      
      // Accumulate the sum of the scores.
      for (int i = 0; i < scores.length; i++)
         total += scores[i];
      
      // return the average.
      return (total / scores.length);
   }
}