package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoggerManager;

import java.time.Duration;

public abstract class BasePage {

    private static final LoggerManager log = LoggerManager.getInstance();
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public String getTitle(){
        try{
            getWebDriverWait(30);
            log.info("Get title");
            return this.webDriver.getTitle();
        } catch (Exception e){
            log.warn("Timed out waiting for page to load");
            return null;
        }
    }

    protected WebDriverWait getWebDriverWait(int timeoutSeconds){
        log.info("Starting wait of " + timeoutSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutSeconds));
        return wait;
    }

    protected boolean isElementDisplayed(WebElement webElement, int timeInSeconds){
        log.info("starting wait for webElement");
        try {
            WebElement newWebElement = getWebDriverWait(timeInSeconds).until(ExpectedConditions.visibilityOf(webElement));
            log.info("Successful wait");
            return newWebElement.getSize().getWidth() > 0 && newWebElement.getSize().getHeight() > 0;
        } catch (TimeoutException e) {
            log.warn("The wait has exceeded the expected wait time");
        } catch (Exception e) {
            log.warn("An unexpected error occurred while waiting for the webElement.");
        }
        return false;
    }

    protected boolean isElementDisplayed(By by, int timeoutInSeconds){
        try {
            log.info("starting wait for element");
            WebElement newWebElement = getWebDriverWait(timeoutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
            log.info("Successful wait");
            return newWebElement.getSize().getWidth() > 0 && newWebElement.getSize().getHeight() > 0;
        } catch (TimeoutException e) {
            log.warn("The wait has exceeded the expected wait time");
        } catch (Exception e) {
            log.warn("An unexpected error occurred while waiting for the element.");
        }
        return false;
    }

    protected boolean isElementClickable(WebElement webElement, int timeInSeconds){
        log.info("starting wait for Element clickable");
        try {
            WebElement newWebElement = getWebDriverWait(timeInSeconds).until(ExpectedConditions.elementToBeClickable(webElement));
            log.info("Successful wait");
            return newWebElement.getSize().getWidth() > 0 && newWebElement.getSize().getHeight() > 0;
        } catch (TimeoutException e) {
            log.warn("The wait has exceeded the expected wait time. Element might not be clickable.");
        } catch (StaleElementReferenceException e) {
            log.warn("The element is no longer attached to the DOM.");
        } catch (Exception e) {
            log.warn("An unexpected error occurred while waiting for the element.");
        }
        return false;
    }
}
