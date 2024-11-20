package factory;

import browserManager.ChromeDriverManager;
import browserManager.EdgeDriverManager;
import browserManager.FireFoxDriverManager;
import webDriver.WebDriverManager;

public class FactoryManager {
    private static WebDriverManager webDriverManager;
    public WebDriverManager factoryManager(String browser) throws  Exception{
        switch (browser){
            case ("Chrome"):
                webDriverManager = new ChromeDriverManager();
                return webDriverManager;
            case ("FireFox"):
                webDriverManager = new FireFoxDriverManager();
                return webDriverManager;
            case ("Edge"):
                webDriverManager = new EdgeDriverManager();
                return webDriverManager;
            default: throw new Exception("browser not found");
        }
    }
}
