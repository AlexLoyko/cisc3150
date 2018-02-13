import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static final String [] months = {
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    };

    static final int [] daysInMonth = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    static final String [] weekdayNames = {
        "Sunday", 
        "Monday", 
        "Tuesday", 
        "Wednesday", 
        "Thursday", 
        "Friday", 
        "Saturday"
    };

    public static void main(String [] args) {
        int year = 0;
        int intendedDay = 0;
        boolean isLeap;

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the year for which you want the calendar: ");

        try {
            if (input.hasNextInt())
                year = input.nextInt();    
            else 
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Integer is expected for the \"year\". Next time input an integer.");
            return;
        } catch (Exception e2) {
            System.out.println("Something went wrong! We apologize for any inconvenience.");
            return;
        }

        if (year < 0) {
            System.out.println("Sorry, this is a practical application, not a history class assistant. If you wish to have the support for the years before the common era, please open an issue on Github or create a pull request.");
            return;
        } else if (year > 2100) {
            System.out.println("Stop messing around! The years after 2100 will be enabled in 2051. Enjoy your life NOW!");
            return;
        }

        isLeap = year % 4 == 0 ? true : false;

        System.out.println("Enter one of the following to specify the day of the week on which January 1st fell in the year you want to see a calendar for.");
       
        for (int i = 0; i < weekdayNames.length; i++) {
            System.out.println("For \"" + weekdayNames[i] + "\" enter \'" + i + "\'");
        }

        try {
            if (input.hasNextInt())
                intendedDay = input.nextInt();
            else 
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Integer is expected for the \"day of week field\". You were given a list of possible values. Stick to them next time.");
            return;
        } catch (Exception e2) {
            System.out.println("Something went wrong! We apologize for any inconvenience.");
            return;
        }

        for (int i = 0; i < months.length; i++) {
            Month month = new Month(intendedDay, months[i], isLeap && i == 1 ? daysInMonth[i] + 1 : daysInMonth[i]);
            month.display(year);
            intendedDay = (intendedDay + (isLeap && i == 1 ? daysInMonth[i] + 1 : daysInMonth[i])) % 7;
        }

        input.close();
    }
}