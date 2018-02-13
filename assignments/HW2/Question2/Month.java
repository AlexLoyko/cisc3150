import java.util.Collection;
import java.util.Collections;

public class Month {
    private static final String DAYS_OF_WEEK_HEADER_LINE = "Su Mo Tu We Th Fr Sa";
    private static final int HEADER_LINE_WIDTH = DAYS_OF_WEEK_HEADER_LINE.length();

    private String name;
    private int firstOfMonthOnWeekday;
    private int numberOfDays;

    public Month (int firstOfMonthOnWeekday, String name, int numberOfDays) {
        this.firstOfMonthOnWeekday = firstOfMonthOnWeekday;
        this.name = name;
        this.numberOfDays = numberOfDays;
    }

    public void display(int year) {
        int numSpacesInMonthName = (HEADER_LINE_WIDTH - (name.length() + Integer.toString(year).length() + 1))/2;
        String paddingLeft = String.join("", Collections.nCopies(numSpacesInMonthName," "));

        System.out.println(paddingLeft + name + " " + year);
        System.out.println(DAYS_OF_WEEK_HEADER_LINE);

        String initialPadding = String.join("", Collections.nCopies(this.firstOfMonthOnWeekday, "   "));
        System.out.print(initialPadding);

        int delim = firstOfMonthOnWeekday;
        for (int i = 1; i <= numberOfDays; i++) {
            System.out.printf("%2s", i);
            if (delim % 7 == 6)
                System.out.print("\n");
            else 
                System.out.print(" ");
            
            delim++;
        }
        if (!(delim % 7 == 0))
            System.out.println();
        System.out.println();

    }
}