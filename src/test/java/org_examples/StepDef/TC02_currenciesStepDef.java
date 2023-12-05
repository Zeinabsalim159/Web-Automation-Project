package org_examples.StepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org_examples.Pages.P02_homePage;

import java.util.List;

import static org_examples.StepDef.Hooks.driver;


public class TC02_currenciesStepDef {
    P02_homePage Cur_locators=new P02_homePage();

    @When("User Select Euro currency from the dropdown list on the top left of home page")
    public void user_select_euro_currency_from_the_dropdown_list_on_the_top_left_of_home_page() {

        driver.navigate().to("https://demo.nopcommerce.com/");
        Select sel_cur= new Select(Cur_locators.Cur_index(driver));
        sel_cur.selectByIndex(1);

    }
    @Then("Euro Symbol \\(€) is shown on the {int} products displayed in Home page")
    public void euro_symbol_€_is_shown_on_the_products_displayed_in_home_page(Integer int1) {

        List<WebElement> actualPrice= Cur_locators.ActuaPricelLoc(driver);
        WebElement Euro;
        for (int i=0;i< actualPrice.size();i++){
            Euro=actualPrice.get(i);
            Assert.assertTrue(Euro.getText().contains("€"));
            System.out.println(Euro.getText());
        }


    }

}
