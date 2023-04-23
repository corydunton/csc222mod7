
package se8DatesAndTime;

import java.time.*;
import java.time.temporal.ChronoUnit;


public class ExLocalDate {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today.toString());
        //toString prints in the format of 2014-06-28
        LocalDate birthday = LocalDate.of(1999, Month.MARCH, 22);
        // note that you can use the Month enumeration
        System.out.println(birthday.toString());
        //note you can use the number of the month - one based (used to be zero based)
        LocalDate birthday2 = LocalDate.of(1999,3,22);
        System.out.println(birthday2.toString());
        // you can get the day of the week  
        System.out.println("The day of the week is " + today.getDayOfWeek());
        // you can get the day of the year
        System.out.println("Today is the " + today.getDayOfYear()+ "th day of this year");
        // you can get the Period between the two dates.
        System.out.println("This person has been alive for " + birthday.until(today, ChronoUnit.DAYS) + " days");
        // you can add a number of days, weeks, months or years
        today.plusDays(2);
        today.plusMonths(2);
        today.plusWeeks(2);
        today.plusYears(2);
        // you can subtract a number of days, weeks, months or years
        today.minusDays(2);
        today.minusMonths(2);
        today.minusWeeks(2);
        today.minusYears(2);
        // you can change a piece of the date.  
        
    }
    
}
