package Lab2;

public class Game extends App {

    public Game(String appName, int appWeight, double appVersion) {
        super(appName, appWeight, appVersion);
    }

    @Override
    public void opening() {
        System.out.println(getAppName() + " ...loading...");
    }
    
    @Override
    public void screenInfo() {
        System.out.println(getAppName() + " Game mode on!!!");
    }
}
