package org_examples.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org_examples.StepDef.Hooks.driver;

public class P02_homePage {
    public WebElement Cur_index (WebDriver driver){
        return (driver.findElement(By.id("customerCurrency")));
    }
    //driver.findElements(By.className("actual-price"))
    public List<WebElement> ActuaPricelLoc(WebDriver driver){
        return (driver.findElements(By.className("actual-price")));
    }
    public WebElement Search_field (){
        return (driver.findElement(By.className("search-box-text")));}

    public WebElement Search_Btn (){
        return (driver.findElement(By.className("search-box-button")));}

    public WebElement Search_Display (){
        return (driver.findElement(By.id("products-pagesize")));}
    public WebElement item (){
        return (driver.findElement(By.cssSelector("div[class=\"item-box\"]")));}

    public List<WebElement> item_Num (WebDriver driver){
        return (driver.findElements(By.cssSelector("div[class=\"item-box\"]")));}//overview
    public List<WebElement> item_page (WebDriver driver){
        return (driver.findElements(By.className("overview")));}
    public List<WebElement> Page_Title (WebDriver driver){
        return (driver.findElements(By.className("overview")));}


}




