import java.util.regex.*;

public class IPAddressValidator {

    public static void main(String[] args) {
        String ipAddress = "149.001.183.44";

        String regex = "^([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.([0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.([0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])$";
     
       Matcher matcher = Pattern.compile(regex).matcher(ipAddress);
        if (matcher.matches()) {
            System.out.println("IP-адрес корректен.");
        } else {
            System.out.println("IP-адрес некорректен.");
        }
    }
}  



