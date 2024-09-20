import java.util.Scanner;

public class PalindromeCheck {

    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input a string
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        // Check if the string is a palindrome
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase to handle case-insensitivity
        str = str.replaceAll("\\s+", "").toLowerCase();

        // Initialize pointers at the start and end of the string
        int left = 0;
        int right = str.length() - 1;

        // Check each character from both ends
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // It's a palindrome
    }
}
