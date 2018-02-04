import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            if (input.hasNextInt()) 
                System.out.println(input.nextInt());
            else if (input.hasNextDouble())
                System.out.println(input.nextDouble());
            else 
                input.next(); // if not a number, just step over it
        }
    }
}