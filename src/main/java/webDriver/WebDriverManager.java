package webDriver;

import org.openqa.selenium.WebDriver;
import utils.LoggerManager;

public abstract class WebDriverManager {

    private static final LoggerManager log = LoggerManager.getInstance();
    protected WebDriver webDriver;
    protected abstract void createWebDriver();

    public WebDriver getWebDriver() {
        if(webDriver == null){
            log.info("Creating WebDriver instance");
            this.createWebDriver();
        }
        return webDriver;
    }

    public void goTo(String url){
        getWebDriver().get(url);
    }

    public void close(){
        getWebDriver().quit();
    }
}
