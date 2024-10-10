package Lab2;

public abstract class App {
    // Поля
    private String appName;
    private int appWeight;
    private double appVersion;

    //Статическое поле подсчета приложений
    private static int totalApps = 0;
    
    //Конструктор по умолчанию
    public App() {
        
        this.appName = "V-chat";
        this.appWeight = 12;
        this.appVersion = 1.7;

        //Увеличиваем счетчик приложений
        totalApps++;
    }

    //Конструктор
    public App(String appName, int appWeight, double appVersion) {
        
        this.appName = appName;
        this.appWeight = appWeight;
        this.appVersion = appVersion;
        
        //Увеличиваем счетчик приложений
        totalApps++;
    }

    // Статический метод 
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