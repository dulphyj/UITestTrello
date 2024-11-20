package commons;

import factory.FactoryManager;
import webDriver.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    public WebDriverManager webDriverManager;
    private Map<String, Object> context;

    public TestContext(){
        context = new HashMap<>();
    }


    public void setValue(String key, Object value){
        context.put(key, value);
    }

    public <T> T getValue(String key){
        return (T) context.get(key);
    }

    public WebDriverManager selectBrowser(String browser_){
        try {
            FactoryManager factoryManager = new FactoryManager();
            webDriverManager = factoryManager.factoryManager(browser_);
            return webDriverManager;
        }catch (Exception e){
            System.out.println("Browser not found");
            return null;
        }
    }
}
