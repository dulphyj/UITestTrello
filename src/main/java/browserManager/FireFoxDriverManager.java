package browserManager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import webDriver.WebDriverManager;

import java.time.Duration;

public class FireFoxDriverManager extends WebDriverManager {
    @Override
    protected void createWebDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=es");
        this.webDriver = new FirefoxDriver(options);
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
}
