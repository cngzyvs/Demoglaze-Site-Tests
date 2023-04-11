package com.demoblaze.step_Defs;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login();
    }

    @Then("The user verify that Welcome George George is displayed")
    public void the_user_verify_that_Welcome_George_George_is_displayed() {
        homePage.verifyWelcomeMessage();
    }

    @When("The user enters {string} and {string} credentials")
    public void the_user_enters_and_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("The user verify that user {string} is displayed")
    public void the_user_verify_that_user_is_displayed(String user) {
        homePage.verifyWelcomeMessage();
        homePage.verifyWelcomeMessage(user);
    }

    @Then("The user verify that {string} is displayed")
    public void theUserVerifyThatIsDisplayed(String username) {
        homePage.verifyWelcomeMessage(username);
    }

    @When("The user enters valid username and password credentials")
    public void theUserEntersValidUsernameAndPasswordCredentials(Map<String,String> userAndPass) {
        loginPage.login(userAndPass.get("username"),userAndPass.get("password"));
    }

    @When("The user enters invalid user name {string} or password {string} credentials")
    public void theUserEntersInvalidUserNameOrPasswordCredentials(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("The user verify invalid credential {string}")
    public void theUserVerifyInvalidCredential(String expectedMessage) {
        loginPage.verifyInvalidInputCredentials(expectedMessage);
    }
}
