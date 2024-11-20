package steps.hooks;

import browserManager.ChromeDriverManager;
import commons.Config;
import commons.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.HomePage;
import pages.LoginPage;
import pages.board.BoardPage;
import pages.board.MenuBoardPage;

public class Hooks {
    private TestContext testContext;
    private String title = "this board";

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void beforeScenario(){
        testContext.webDriverManager = new ChromeDriverManager();
        testContext.setValue("email", Config.getEmail());
        testContext.setValue("password", Config.getPassword());
        testContext.setValue("webUrl", Config.getUrl());
    }

    @Before("@EditBoard")
    public void beforeCreateBoard(){
        LoginPage loginPage = new LoginPage(testContext.webDriverManager.getWebDriver());
        HomePage homePage = new HomePage(testContext.webDriverManager.getWebDriver());
        MenuBoardPage menuBoardPage = new MenuBoardPage(testContext.webDriverManager.getWebDriver());
        testContext.webDriverManager.goTo(testContext.getValue("webUrl"));
        loginPage.logInTrello(testContext.getValue("email"), testContext.getValue("password"));
        homePage.create();
        homePage.createBoard();
        menuBoardPage.setName(title);
        menuBoardPage.createBoard();
    }

    @After
    public void afterClose(){
        testContext.webDriverManager.close();
    }

    @After("@CreateBoard or @EditBoard")
    public void afterDeleteBoard(){
        BoardPage boardPage = new BoardPage(testContext.webDriverManager.getWebDriver());
        boardPage.deleteBoard();
    }
}
