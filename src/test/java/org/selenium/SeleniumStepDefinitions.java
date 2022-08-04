package org.selenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumStepDefinitions {

    SeleniumHelperMethods shm = new SeleniumHelperMethods();

    @Given("Chrome web browser")
    public void chromeWebBrowser() {
        shm.initChromeWebBrowser();
    }

    @When("I login with {string} and {string} at {string}")
    public void iLoginWithAndAt(String user, String password, String url) {
        shm.getURL(url);
        shm.enterLoginCredentials(user, password);
    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String output) {
        assertEquals(output, shm.grabSecureAreaText());
    }

    @Then("I should get an error message: {string}")
    public void iShouldGetAnErrorMessage(String output) {
        assertEquals(output, shm.grabLoginErrorMessage());
    }
}