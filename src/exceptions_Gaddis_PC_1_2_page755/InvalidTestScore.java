package exceptions_Gaddis_PC_1_2_page755;


public class InvalidTestScore extends Exception
{
   
   public InvalidTestScore()
   {
      super("Invalid test score");
   }
   
      
   public InvalidTestScore(int element, double score)
   {
      super("Element: " + element + " Invalid Score: " + score);
   }
}
