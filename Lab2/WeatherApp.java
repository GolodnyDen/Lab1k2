package Lab2;

public class WeatherApp extends App {
    public WeatherApp(String appName, int appWeight, double appVersion) {
        super(appName, appWeight, appVersion);
    }

    @Override
    public void opening() {
        System.out.println(getAppName() + " Let's take a look)");
    }
    
    @Override
    public void screenInfo() {
        System.out.println(getAppName() + " Weather right now is:...");
    }
    
}

