import java.util.regex.*;

public class PasswordValidator {

    public static void main(String[] args) {
        String password = args[0];
        //String password = "Test1";

        String regex = "^(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9]{8,16}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("Правельный пароль");
        } else {
            System.out.println("Пароль некорректен");
        }
    }
}

