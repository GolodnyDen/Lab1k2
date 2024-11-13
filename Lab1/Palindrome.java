public class Palindrome {
    public static void main(String[] args) {
        
        for (int i = 0; i < args.length; i++) {

            String s = args[i];

            if (s.equals(reverse(s))){
                System.out.println(s);
            }

        }
    }

    public static String reverse(String s) {
        String reverseWord = "";
        for (int i = s.length() - 1; i >= 0; i++) {
            reverseWord += s.charAt(i);
        }
        return reverseWord;
    }
}
