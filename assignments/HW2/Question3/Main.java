import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        System.out.println("Enter a string to check if it is a palindrome");

        Scanner input = new Scanner(System.in);
        String word = null;

        if (input.hasNext()) {
            word = input.next().toLowerCase();
        }

        if (isPalindrome(word)) 
            System.out.println("The word \"" + word +"\" is a palindrome.");
        else 
            System.out.println("The word \"" + word +"\" is not a palindrome.");
        
        input.close();
    }

    private static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length()/2; i++) {
            if (!(word.charAt(i) == word.charAt(word.length() - 1 - i)))
                return false;
        }

        return true;
    }
} 