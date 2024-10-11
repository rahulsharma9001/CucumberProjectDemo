package StepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utility.TestContextSetup;

import java.io.IOException;

public class HomePageStepDefinition {
    TestContextSetup tcs;
    // Constructor to initialize TestContextSetup
    public HomePageStepDefinition() throws IOException {
        tcs = new TestContextSetup();  // Inject TestContextSetup instance
    }

    @Given("User navigates the Login page")
    public void user_navigates_to_Login_Page() throws InterruptedException{
        tcs.pom.getHomePage().click_menu();
        tcs.pom.getHomePage().SignIn();
    }

    @When("user successfully enters the log in details")
    public void user_enters_credentials(){
        tcs.pom.getHomePage().enter_credentials_for_sigIn();
    }

    @Then("User should be able to view the product category page")
    public void user_succesfully_loggedIn(){
        tcs.pom.getHomePage().assert_url();
    }



}
