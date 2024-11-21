public class Palindrome {
    public static void main(String[] args) {
        String theString = "madam";
        
        if (isPalindrome(theString)) {
            System.out.println(theString + " is a palindrome.");
        } else {
            System.out.println(theString + " is not a palindrome.");
        }
    }

    public static String reverseString(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        return s.equals(reversed);
    }
}
