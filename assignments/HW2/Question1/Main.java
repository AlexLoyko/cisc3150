import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        System.out.println("Please enter the height of the pyramid");

        Scanner input = new Scanner(System.in);

        int height = 0;

        try {
            if (input.hasNextInt()) {
                height = input.nextInt();
            } else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            System.out.println("You did not input an integer! Type in an integer next time!");
        }

        int maxNumberWidth = Integer.toString(height).length();

        // calculate the width it takes to show the numbers + spaces between them for the last line
        int lineWidth = (2 * height - 1) * (maxNumberWidth  + 1);

        for (int i = 1; i <= height; i++) {
            // same idea as for the above comment but per line
            int currLineWidth = (2 * i - 1) * (maxNumberWidth + 1);

            // a neat way to create a string consisting of n copies of a given string in Java 8
            // from https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java

            System.out.print(String.join("", Collections.nCopies((lineWidth - currLineWidth)/2, " ")));
            
            for (int t = 1, j = 1; j <= 2 * i - 1; t += j++ < i ? 1 : -1) {
                System.out.printf("%" + maxNumberWidth + "s", t);
                System.out.print(" ");
            }

            System.out.print("\n");
        }

        input.close();
    }
}