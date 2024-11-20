package steps;

import commons.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    private TestContext testContext;
    private LoginPage loginPage;

    public LoginSteps(TestContext testContext){
        this.testContext = testContext;
        loginPage = new LoginPage(testContext.webDriverManager.getWebDriver());
    }

    @Given("the user opens a web browser on Login page")
    public void theUserOpensAWebBrowserOnLoginPage() {
        testContext.webDriverManager.goTo(testContext.getValue("webUrl"));
    }

    @When("the user logs into Trello with Atlassian")
    public void theUserLogsIntoTrelloWithAtlassian() {
        loginPage.logInTrello(testContext.getValue("email"), testContext.getValue("password"));
    }


    //Board Steps
    @Given("the user is on home page trello")
    public void theUserIsOnHomePageTrello() {
        testContext.webDriverManager.goTo(testContext.getValue("webUrl"));
        loginPage.logInTrello(testContext.getValue("email"), testContext.getValue("password"));
    }
}
