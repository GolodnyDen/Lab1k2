package Lab2;

public class SocialApp extends App {

    public SocialApp() {
        super();
    }

    @Override
    public void opening() {
        System.out.println(getAppName() + " Searching for new messages...");
    }
    
    @Override
    public void screenInfo() {
        System.out.println(getAppName() + " Active chats...");
    }
    
}