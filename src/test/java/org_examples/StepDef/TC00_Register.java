package org_examples.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org_examples.Pages.P00_Register;

import static org_examples.StepDef.Hooks.driver;
import static org_examples.StepDef.Hooks.soft;

public class TC00_Register {
    P00_Register Register_Loc= new P00_Register();

    // User Data //
    static String User_Mail = "test12@example.com";
    static String User_Password= "P@ssw0rd";
    static String User_1st_Name="automation";
    static String User_2nd_Name="tester";


    @When("clicks registration button to go to register page")
    public void clicks_registration_button_to_go_to_register_page() {
        Register_Loc.register_Page().click();

    }
    @And("user select gender type")
    public void user_select_gender_type() {
Register_Loc.Gender().click();
    }
    @And("user enter first name {string} and last name {string}")
    public void user_enter_first_name_and_last_name(String string, String string2) {
        Register_Loc.First_name().sendKeys(User_1st_Name);
        Register_Loc.Last_name().sendKeys(User_2nd_Name);

    }
    @And("user enter date of birth")
    public void user_enter_date_of_birth() {
        Select Day_DropDown =new Select(Register_Loc.Day_index());
        Day_DropDown.selectByIndex(17);
        Select Month_DropDown =new Select(Register_Loc.Month_index());
        Month_DropDown.selectByIndex(3);
        Select Year_DropDown=new Select(Register_Loc.year_index());
        Year_DropDown.selectByIndex(82);
    }
    @And("user enter email {string} field")
    public void user_enter_email_field(String string) {
      Register_Loc.email().sendKeys(User_Mail);
    }
    @And("user fills Password fields {string} {string}")
    public void user_fills_password_fields(String string, String string2) {
        Register_Loc.password().sendKeys(User_Password);
        Register_Loc.confirm_password().sendKeys(User_Password);

    }
    @And("user clicks on register button")
    public void user_clicks_on_register_button() {
        Register_Loc.register_btn().click();
    }
    @Then("success message is displayed")
    public void success_message_is_displayed()  {
        soft.assertTrue(Register_Loc.register_success_msg().getText().contains("Your registration completed"));
    }



}
