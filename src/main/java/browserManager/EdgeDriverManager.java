package browserManager;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import webDriver.WebDriverManager;

import java.time.Duration;

public class EdgeDriverManager extends WebDriverManager {
    @Override
    protected void createWebDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en");
        this.webDriver = new EdgeDriver(options);
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}
