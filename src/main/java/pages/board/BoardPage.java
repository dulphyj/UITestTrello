package pages.board;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.HomePage;

public class BoardPage extends BasePage {
    @FindBy (css = "div[class=\"board-main-content\"]")
    WebElement contentBoard;
    @FindBy(css = "div[data-testid=\"board-name-container\"]")
    WebElement boardNameBtn;
    @FindBy(css = "input[data-testid=\"board-name-input\"]")
    WebElement boardNameTxt;
    @FindBy(css = "button[class=\"frrHNIWnTojsww GDunJzzgFqQY_3 bxgKMAm3lq5BpA HAVwIqCeMHpVKh SEj5vUdI3VvxDc\"]")
    WebElement boardOptionBtn;
    @FindBy(css = "a[class=\"board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board\"]")
    WebElement closeBoardOptionBtn;
    @FindBy(css = "input[class=\"js-confirm full nch-button nch-button--danger\"]")
    WebElement closeBoardBtn;
    @FindBy(css = "button[data-testid=\"close-board-delete-board-button\"]")
    WebElement deleteBoardBtn;

    public BoardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean getContentBoard(){
        isElementDisplayed(contentBoard, 10);
        return contentBoard.isDisplayed();
    }

    public String getBoardName(){
        return boardNameBtn.getText();
    }

    public void clickBoardName(){
        boardNameBtn.click();
    }
    public void editBoardName(String name){
        getWebDriverWait(5);
        boardNameTxt.sendKeys(name);
        boardNameTxt.sendKeys(Keys.ENTER);
    }

    public HomePage deleteBoard(){
        boardOptionBtn.click();
        isElementClickable(closeBoardOptionBtn, 5);
        closeBoardOptionBtn.click();
        isElementClickable(closeBoardBtn, 5);
        closeBoardBtn.click();
        isElementClickable(deleteBoardBtn, 5);
        deleteBoardBtn.click();
        return new HomePage(this.webDriver);
    }
}


