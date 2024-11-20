package browserManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import webDriver.WebDriverManager;

import java.time.Duration;

public class ChromeDriverManager extends WebDriverManager {

    @Override
    protected void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=es");
        this.webDriver = new ChromeDriver(options);
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}
