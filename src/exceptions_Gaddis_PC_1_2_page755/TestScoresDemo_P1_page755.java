package exceptions_Gaddis_PC_1_2_page755;


public class TestScoresDemo_P1_page755
{
   public static void main(String[] args)
   {
      // An array with test scores.
      // Notice that element 3 contains an invalid score.
      double[] badScores = {97.5, 66.7, 88.0, 101.0, 99.0 };

      // Another array with test scores.
      // All of these scores are good.
      double[] goodScores = {97.5, 66.7, 88.0, 100.0, 99.0 };
      
      // Create a TestScores object initialized with badScores.
      try
      {
         TestScores_P1_page755 tBad = new TestScores_P1_page755(badScores);
         // The following statement should not execute.
         System.out.println("The average of the bad scores is " +
                            tBad.getAverage());
      }
      catch (IllegalArgumentException e)
      {
         System.out.println("Invalid score found.\n" + e.getMessage());
      }
   
      // Create a TestScores object initialized with goodScores.
      try
      {
         TestScores_P1_page755 tGood = new TestScores_P1_page755(goodScores);
         System.out.println("The average of the good scores is " +
                            tGood.getAverage());
      }
      catch (IllegalArgumentException e)
      {
         System.out.println("Invalid score found.\n" + e.getMessage());
      }
   }
}
