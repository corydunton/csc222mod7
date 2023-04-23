

package se8DatesAndTime;

import java.time.*;


public class ExLocalTime {
    public static void main(String[] args) {
       LocalTime rightNow = LocalTime.now();
       System.out.println(rightNow.toString());
       // add 4 hours to the current time
       LocalTime later =rightNow.plusHours(4);
       System.out.println(later.toString());
    }
}
