import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(",");

        System.out.println("Enter a bunch of comma-separated tokens and each of them will get printed on a different line");

        while (input.hasNext()) {
            System.out.println(input.next());
        }
    }
}