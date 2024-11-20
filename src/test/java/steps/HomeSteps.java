package steps;

import commons.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.board.MenuBoardPage;

public class HomeSteps {
    private TestContext testContext;
    private HomePage homePage;
    private MenuBoardPage menuBoardPage;

    public HomeSteps(TestContext testContext){
        this.testContext = testContext;
        homePage = new HomePage(testContext.webDriverManager.getWebDriver());
        menuBoardPage = new MenuBoardPage(testContext.webDriverManager.getWebDriver());
    }

    //Login Steps
    @Then("the user sees the home content")
    public void theUserSeesTheBoardContent() {
        Assert.assertTrue(homePage.isContentHomePageDisplayed());
    }

    @And("the user sees {string} as the title of the home page")
    public void theUserSeesAsTheTitleOfTheHomePage(String title) {
        homePage = new HomePage(testContext.webDriverManager.getWebDriver());
        Assert.assertEquals(homePage.getTitle(), title);
    }

    //Board Steps
    @When("the user click create button")
    public void theUserClickCreateButton() {
        homePage.create();
    }

    @And("the user click create board button")
    public void theUserClickCreateBoardButton() {
        homePage.createBoard();
    }

    @And("the user sees a menu displayed and in board title enters the {string} and click create button")
    public void theUserSeesAMenuDisplayedAndInBoardTitleEntersTheAndClickCreateButton(String title) {
        menuBoardPage.setName(title);
        menuBoardPage.createBoard();
    }
}
