public class Palindrome {
    public static void main(String[] args) {
        String input = "racecar";
        if (input.length() != 5){
            System.out.println(false);
        } else {
        System.out.println(input.equals(reverseString(input)));

        }
        

    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
