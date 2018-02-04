import java.util.Random;

public class Main {
    public static void main(String [] args) {
        String [] months = {
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

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randomMonth = rand.nextInt(12) + 1;
            System.out.println("Our random month this time is " + months[randomMonth-1]);
        }
    }
}