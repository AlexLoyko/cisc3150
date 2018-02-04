import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter the radius of circle to calculate the area. \nTo exit, use your operating system's EOF command shortcut.");

        while (input.hasNext()) {
            double radius;

            if (input.hasNextDouble()) {
                radius = input.nextDouble();
                if (radius > 0) {
                    double area = Math.PI * Math.pow(radius, 2);
                    System.out.print("The area of a circle with radius of " + radius + " is ");
                    System.out.printf("%.2f\n", area);
                } else {
                    System.out.println("Invalid input of \"" + radius + "\". Radius should be greater than 0 !");
                }
            } else {
                System.out.println("Invalid input of \"" + input.next() + "\". Your input should be a positive number!");
            }

            System.out.println("\nEnter the radius of circle to calculate the area. \nTo exit, use your operating system's EOF command shortcut.");
        }
    }
}