package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LoggerManager;

public class LoginPage extends BasePage{

    private static final LoggerManager log = LoggerManager.getInstance();

    @FindBy(id = "user")
    WebElement emailTxb;

    @FindBy(id = "login")
    WebElement continueBtn;

    @FindBy(id = "password")
    WebElement passwordTxb;

    @FindBy(id = "login-submit")
    WebElement logInBtn;
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BasePage logInTrello(String email, String password){
        log.info("Sending keys to log in to the page");
        try {
            emailTxb.sendKeys(email);
            continueBtn.click();
            isElementDisplayed(passwordTxb, 10);
            passwordTxb.sendKeys(password);
            logInBtn.click();
            log.info("Successful Login");
            return new HomePage(this.webDriver) {
            };
        } catch (Exception e){
            log.warn("Fail Login");
            return null;
        }
    }
}
