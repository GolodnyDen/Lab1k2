package Lab2;

public class Info {
    public static void main(String[] args) {
        Game game = new Game("World of Warcraft", 120,12.51);
        game.opening();
        game.screenInfo();

        SocialApp social = new SocialApp("View", 15, 3.22);
        social.opening();
        social.screenInfo();

        WeatherApp weather = new WeatherApp("MoscowCloudY", 2,7.17);
        weather.opening();
        weather.screenInfo();

        System.out.println("Total apps were opened: " + App.getTotalApps());
    }
    
}
