package pages.board;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.LoggerManager;

public class MenuBoardPage extends BasePage {

    private final LoggerManager log = LoggerManager.getInstance();
    @FindBy(css = "input[data-testid=\"create-board-title-input\"]")
    WebElement boardTitleTxt;
    @FindBy(css = "button[data-testid=\"create-board-submit-button\"]")
    WebElement createBoardBtn;
    public MenuBoardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setName(String name){
        boardTitleTxt.sendKeys(name);
    }

    public BoardPage createBoard(){
        try {
            isElementClickable(createBoardBtn, 30);
            createBoardBtn.click();
            log.info("Button found");
            return  new BoardPage(this.webDriver);
        } catch (Exception e){
            log.warn("Button not found");
            return null;
        }
    }
}
