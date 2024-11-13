import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Не имей 100 рублй а имей 100 друзей";
        Pattern pattern = Pattern.compile("\\d*(\\.\\d+)?");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
