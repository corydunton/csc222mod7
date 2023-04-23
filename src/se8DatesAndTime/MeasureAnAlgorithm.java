

package se8DatesAndTime;

import java.time.*;

public class MeasureAnAlgorithm {
    public static void main(String[] args) {
        Instant start = Instant.now();
        //call your algorithm here
        countdown();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start,end);
        long millis = timeElapsed.toMillis();
        System.out.println("That took " + millis + " milliseconds");       
    }

    private static void countdown() {
        for (int i=0;i<1000000000;i++)
            ;
    }
    
    
}
