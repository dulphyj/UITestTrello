package steps;

import commons.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.board.BoardPage;

public class BoardSteps {
    private TestContext testContext;
    private BoardPage boardPage;

    public BoardSteps(TestContext testContext){
        this.testContext = testContext;
        boardPage = new BoardPage(testContext.webDriverManager.getWebDriver());
    }

    @Then("the user can see {string} in the board title")
    public void theUserCanSeeInTheBoardTitle(String title) {
        String actualTitle = boardPage.getBoardName();
        Assert.assertEquals(title, actualTitle, "The Titles are not the same");
    }

    @And("the user can see the content of the board page")
    public void theUserCanSeeTheContentOfTheBoardPage() {
        Assert.assertTrue(boardPage.getContentBoard(), "The Board Content is not displayed");
    }

    @Given("The user is on the board page {string}")
    public void theUserIsOnTheBoardPage(String title) {
        Assert.assertEquals(boardPage.getBoardName(), title, "Titles are not the same");
    }

    @When("the user click on the board title")
    public void theUserClickOnTheBoardTitle() {
        boardPage.clickBoardName();
    }

    @And("the user enter the {string} of the board")
    public void theUserEnterTheOfTheBoard(String title) {
        boardPage.editBoardName(title);
    }
}
