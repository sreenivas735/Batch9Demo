package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FaceBookLoginPage;

public class FacebookLoginPageGlue {

    FaceBookLoginPage faceBookLoginPage;
    public FacebookLoginPageGlue() {
       faceBookLoginPage = new FaceBookLoginPage(Hooks.driver);
    }


    @Given("enter user name {string}")
    public void enterUserName(String username) {
        faceBookLoginPage.enterUsername(username);
    }

    @When("enter password {string}")
    public void enterPassword(String password) {
        faceBookLoginPage.enterPassword(password);
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        faceBookLoginPage.clickOnLoginButton();
    }

    @Then("verify error message {string}")
    public void verifyErrorMessage(String expErrorMessage) {
        String actualErrMsg = faceBookLoginPage.getLoginErrorMessage();
        Assert.assertTrue(actualErrMsg.contains(expErrorMessage));
    }
}
