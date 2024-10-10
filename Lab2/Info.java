package Lab2;

public class Info {
    public static void main(String[] args) {
        Game game = new Game("World of Trolls", 120,12.51);
        game.opening();
        game.screenInfo();

        SocialApp social = new SocialApp();
        social.opening();
        social.screenInfo();

        Update update = new Update();
        update.opening();
        update.screenInfo();

        WeatherApp weather = new WeatherApp("MoscowCloudY", 2,7.17);
        weather.opening();
        weather.screenInfo();
        System.out.println(weather.getTotalApps());

        System.out.println("Total apps were opened: " + App.getTotalApps());

    }
    
}
