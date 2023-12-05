package org_examples.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org_examples.StepDef.Hooks.driver;

public class P00_Register {
    public WebElement register_Page (){
        return (driver.findElement(By.className("ico-register")));
    }
    public WebElement Gender (){
        return (driver.findElement(By.id("gender-male")));
    }
    public WebElement First_name (){
        return (driver.findElement(By.id("FirstName")));
    }
    public WebElement Last_name (){
        return (driver.findElement(By.id("LastName")));
    }
    public WebElement Day_index (){
        return (driver.findElement(By.name("DateOfBirthDay")));
    }
    public WebElement Month_index (){
        return (driver.findElement(By.name("DateOfBirthMonth")));
    }
    public WebElement year_index (){
        return (driver.findElement(By.name("DateOfBirthYear")));
    }
    public WebElement email (){
        return (driver.findElement(By.name("Email")));
    }
    public WebElement password (){
        return (driver.findElement(By.name("Password")));}
    public WebElement confirm_password (){
        return (driver.findElement(By.name("ConfirmPassword")));}
    //register-button
    public WebElement register_btn (){
        return (driver.findElement(By.name("register-button")));}
    public WebElement register_result (){
        return (driver.findElement(By.cssSelector("div[class='result']")));}
    public WebElement register_success_msg (){
        return (driver.findElement(By.className("result")));
    }



}
