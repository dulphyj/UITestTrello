package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "div[class=\"home-container\"]")
    WebElement content;
    @FindBy(css = "button[data-testid=\"header-create-menu-button\"]")
    WebElement createBtn;
    @FindBy(css = "button[data-testid=\"header-create-board-button\"]")
    WebElement createBoardBtn;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isContentHomePageDisplayed(){
        return content.isDisplayed();
    }

    public void create(){
        isElementDisplayed(content, 5);
        createBtn.click();
    }

    public void createBoard(){
        isElementClickable(createBoardBtn, 10);
        createBoardBtn.click();
    }
}
