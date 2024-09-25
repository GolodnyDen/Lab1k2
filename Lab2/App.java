package Lab2;

public abstract class App {
    // Поля
    private String appName;
    private int appWeight;
    private double appVersion;

    //Статическое поле подсчета приложений
    private static int totalApps = 0;
    
    //Конструктор
    public App(String appName, int appWeight, double appVersion) {
        
        this.appName = appName;
        this.appWeight = appWeight;
        this.appVersion = appVersion;
        
        //Увеличиваем счетчик приложений
        totalApps++;
    }

    // Статический метод подсчета
    public static int getTotalApps() {
        return totalApps;
    }

    // Абстрактный метод
    abstract void opening();
    abstract void screenInfo();

    // Геттеры и сеттеры
    public String getAppName() {
        return appName;
    }
    
    public void setAppName(String appName) {
        this.appName = appName;
    }
    
    public int getAppWeight() {
        return appWeight;
    }
    
    public void setAppWeight(int appWeight) {
        this.appWeight = appWeight;
    }
    
    public double getAppVersion() {
        return appVersion;
    }
    
    public void setAppVersion(double appVersion) {
        this.appVersion = appVersion;
    }

}