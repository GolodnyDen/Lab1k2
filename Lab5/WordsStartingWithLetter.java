import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsStartingWithLetter {
    public static void main(String[] args) {
        String text = "You will not pass! There is no way to go!";
        char startingLetter = 'w';
        String regex = "\\b" + startingLetter + "\\w*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
                System.out.println(matcher.group());
        }
    }
}
