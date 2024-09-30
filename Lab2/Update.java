package Lab2;

public class Update extends SocialApp{
    public Update() {
        super();
    }
    @Override
    public void opening() {
        System.out.println(getAppName() + " Serching for a new update...");
    }
    
    @Override
    public void screenInfo() {
        System.out.println(getAppName() + " Downloding last version...");
    }
    
}

