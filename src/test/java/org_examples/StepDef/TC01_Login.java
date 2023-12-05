package org_examples.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org_examples.Pages.P01_Login;

import static org_examples.StepDef.Hooks.driver;
import static org_examples.StepDef.TC00_Register.User_Mail;
import static org_examples.StepDef.TC00_Register.User_Password;

public class TC01_Login {
    P01_Login Login_Loc= new P01_Login();

    @Given("navigate to url website")
    public void navigate_to_url_website() {
        driver.navigate().to("https://demo.nopcommerce.com/");

    }
    @Given("Go to login page")
    public void go_to_login_page() {
        Login_Loc.Login_Page().click();
    }
    @When("Enter valid email and password")
    public void enter_valid_email_and_password() {
        Login_Loc.Email().sendKeys(User_Mail);
        Login_Loc.Password().sendKeys(User_Password);

    }
    @When("click on login button")
    public void click_on_login_button() {
        Login_Loc.login_button().click();

    }
    @When("Enter invalid email and password")
    public void enter_invalid_email_and_password() {
        Login_Loc.Email().sendKeys("sherif.makii@gmail.com");
        Login_Loc.Password().sendKeys("Sherif123");
    }

    @Then("verify that user logged in successfully")
    public void verify_that_user_logged_in_successfully() {
        Assert.assertTrue(Login_Loc.Logout_appear().isDisplayed());

    }
    @Then("verify that user didn't logged in successfully")
    public void verify_that_user_didn_t_logged_in_successfully() {
        Assert.assertTrue(Login_Loc.Login_Err_MSG().isDisplayed());

    }


}
