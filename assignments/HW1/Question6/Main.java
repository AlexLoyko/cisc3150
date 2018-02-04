import java.util.Scanner; 
import java.util.Arrays;

public class Main {
    private static double calcDistance(Point pt1, Point pt2) {
        return Math.sqrt(Math.pow(pt2.getX() - pt1.getX(), 2) + Math.pow(pt2.getY() - pt1.getY(), 2));
    }

    public static void main(String [] args) {
        String [] templates = {
            "first",
            "second"
        };

        Scanner input = new Scanner(System.in);
        
        Point [] centers = new Point[2];
        double [] radii = new double[2];
        int count = 0;

        System.out.println("Enter the center of the first circle as \"x-coord y-coord\":");

        while(input.hasNext()) {
            centers[count] = new Point(input.nextDouble(), input.nextDouble());

            System.out.println("Enter the radius of the "+ templates[count] +" circle:");

            radii[count] = input.nextDouble();

            if (count == 1) {
                Arrays.sort(radii);

                double distance = calcDistance(centers[0], centers[1]);
                double radiiSum = radii[0] + radii[1];

                if (distance > radiiSum)
                    System.out.println("The two circles are separate.");
                else if (distance == radiiSum)
                    System.out.println("The two circles are touching.");
                else if (distance <= radii[1] - radii[0])
                    System.out.println("One of the circles contains another.");
                else 
                    System.out.println("The two circles overlap.");

                count = 0;
            } else 
                count++;

            System.out.println("Enter the center of the " + templates[count] + " circle as \"x-coord y-coord\":");
        }
    }
}