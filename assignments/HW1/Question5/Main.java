import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static double calcDistance(Point pt1, Point pt2) {
        return Math.sqrt(Math.pow(pt2.getX() - pt1.getX(), 2) + Math.pow(pt2.getY() - pt1.getY(), 2));
    }

    public static void main(String [] args) {
        String [] templates = {
            "first",
            "second",
            "third"
        };

        Scanner input = new Scanner(System.in);

        int count = 0;
        System.out.println("Enter the first 2D point as \"x-cood y-coord\":");

        Point [] points = new Point[3];
        double [] sides = new double[3];

        while (input.hasNext()) {
            points[count] = new Point(input.nextDouble(), input.nextDouble());

            if (count == 2) {
                count = 0;
                
                // calculate the side lengths
                sides[0] = calcDistance(points[0], points[1]);
                sides[1] = calcDistance(points[0], points[2]);
                sides[2] = calcDistance(points[1], points[2]);

                // sort the array of side lengths so the first 2 would always correspond to the smaller two sides
                Arrays.sort(sides);
                
                // only need to check if the smaller two sides combined are strictly greater than the third
                if (sides[0] + sides[1] <= sides[2]) 
                    System.out.println("You can not form a real triangle from the inputed 3 points.");
                else 
                    System.out.println("The inputed 3 points form a real triangle.");
            } else  
                count++;

                System.out.println("Enter the " + templates[count] + " 2D point as \"x-cood y-coord\":");
        }
    }
}