package org_examples.StepDef;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;


import static org_examples.StepDef.Hooks.driver;


public class TC04_hoverCategoriesStepDef {
    SoftAssert Soft=new SoftAssert();
    @When("From homepage user select random one of the seven main categories and select any sub-category if it exist")
    public void from_homepage_user_select_random_one_of_the_three_main_categories() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
       //********************** Random fx ************************/

        Actions actions=new Actions(driver);
        List<WebElement> mainLinks = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));



        int count = mainLinks.size();
        System.out.println("the Number of main category is "+count);
        int min = 0;
        int max = count-1;
        Random random = new Random();
        int rand = min;
        while (true){
            rand = random.nextInt(max);
            if(rand !=0) break;
        }
        System.out.println("The random  of main-cat number is "+rand);

        int selectedCategory = rand;
        actions.moveToElement(mainLinks.get(selectedCategory)).perform();
        String selectedCategoryText = mainLinks.get(selectedCategory).getText();
        System.out.println("to know which category is selected:   " +selectedCategoryText);

        Thread.sleep(1200);

        selectedCategory = selectedCategory+1;
        String locator = "(//ul[@class='top-menu notmobile']//ul)["+selectedCategory+"]/li";

        List<WebElement> subCategoryLinks = driver.findElements(By.xpath(locator));

        // minimize implicit wait to not waste time if it's empty

        String selectedSubCategoryText;
        if(!subCategoryLinks.isEmpty()) {

            int subCategoryCount = subCategoryLinks.size();
            System.out.println("numbers of profile links = " + subCategoryCount);
            System.out.println(subCategoryLinks.get(0).getText());
            System.out.println(subCategoryLinks.get(1).getText());
            System.out.println(subCategoryLinks.get(2).getText());
            int min1 = -1;
            int max1 = subCategoryCount-1;
            Random random1 = new Random();
            int rand1 = min1;
            while (true){
                rand1 = random1.nextInt(max1);
                if(rand1 !=-1) break;
            }
            //System.out.println("The random  of SUb-cat number is"+rand);




            int selectedSubCategory = rand1;
            //System.out.println("The random  of SUb-cat number is"+selectedSubCategory+" which is "+subCategoryLinks.get(0).getText());
            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText().toLowerCase();
            System.out.println("The random  of SUb-cat number is"+selectedSubCategory+" which is "+selectedSubCategoryText);


            subCategoryLinks.get(selectedSubCategory).click();

            // Do your assertion on selected sub category
            /*Soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/"+selectedSubCategoryText);
            Soft.assertAll();*/
            WebElement Page_Title= driver.findElement(By.className("page-title"));
            String Page_Tit= Page_Title.getText().toLowerCase().trim();
            System.out.println("the page title is "+Page_Tit);
            Soft.assertEquals(Page_Tit,selectedSubCategoryText.toLowerCase());
            Soft.assertAll();
        }
        else
        {
            mainLinks.get(selectedCategory-1).click();
            WebElement Page_Title= driver.findElement(By.className("page-title"));
            String Page_Tit= Page_Title.getText().toLowerCase().trim();
            System.out.println("the page title is "+Page_Tit);
            Soft.assertEquals(Page_Tit,selectedCategoryText.toLowerCase());
            Soft.assertAll();

           /* Soft.assertTrue(Page_Title.getText().contains(selectedCategoryText));
            Soft.assertAll();*/
            // Do your assertion on selected main category
        }




    }

    @Then("Check the page title\\(equal or contains) the one you get it while selecting random sub-category")
    public void check_the_page_title_equal_or_contains_the_one_you_get_it_while_selecting_random_sub_category() {

    }
}
