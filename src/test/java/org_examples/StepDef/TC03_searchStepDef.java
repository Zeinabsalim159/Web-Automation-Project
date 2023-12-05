package org_examples.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org_examples.Pages.P02_homePage;

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Locale;

import static org_examples.StepDef.Hooks.driver;
import static org_examples.StepDef.Hooks.soft;

public class TC03_searchStepDef {
    SoftAssert Soft = new SoftAssert();
    P02_homePage Search_locators=new P02_homePage();
    @When("User write product name {string} on Search Field and click on search button")
    public void user_write_product_name_on_search_field_and_click_on_search_button(String item_name) {
        driver.navigate().to("https://demo.nopcommerce.com/");
        Search_locators.Search_field().sendKeys(item_name);
        Search_locators.Search_Btn().click();
    }
    @When("User write product {string} on Search Field and click on search button")
    public void user_write_product_on_search_field_and_click_on_search_button(String SKU) {
        driver.navigate().to("https://demo.nopcommerce.com/");
        Search_locators.Search_field().sendKeys(SKU);
        Search_locators.Search_Btn().click();
    }
    @And("User click on the product in search result")
    public void user_click_on_the_product_in_search_result() {
        Search_locators.item().click();
    }

    @Then("All Products with product name {string} apears on the web page")
    public void all_products_with_product_name_apears_on_the_web_page(String Item_webpage) {

        Soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q="+Item_webpage);
        Soft.assertAll();
        /*Select Search_Display_Dropdown= new Select(Search_locators.Search_Display());
        Search_Display_Dropdown.selectByIndex(3);*/

        List<WebElement> item_counter= Search_locators.item_Num(driver);
        System.out.println("the number of "+Item_webpage+" items = " +item_counter.size());
        for (int i=0;i< item_counter.size();i++){
            WebElement item_Box=item_counter.get(i);
            //System.out.println( item_Box.getText().toLowerCase());
            System.out.println( "is the Item contain "+Item_webpage+"? = "+item_Box.getText().toLowerCase().contains(Item_webpage));
            Soft.assertTrue(item_Box.getText().toLowerCase().contains(Item_webpage));
        }
        Soft.assertAll();
    }
    @Then("The product has the same {string}")
    public void the_product_has_the_same(String item_SKU) {
        List<WebElement> item_SKU_Search = Search_locators.item_page(driver);

        System.out.println("The item Contain "+item_SKU+ "?= "+item_SKU_Search.get(0).getText().contains(item_SKU) );
        Assert.assertTrue(item_SKU_Search.get(0).getText().contains(item_SKU));
    }

}
