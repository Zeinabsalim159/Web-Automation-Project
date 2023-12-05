package org_examples.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org_examples.StepDef.Hooks.driver;

public class P01_Login {
    public WebElement Login_Page (){

        return (driver.findElement(By.className("ico-login")));
    }
    public WebElement Email (){
        return (driver.findElement(By.id("Email")));
    }
    public WebElement Password (){
        return (driver.findElement(By.id("Password")));
    }
    public WebElement login_button (){
        return (driver.findElement(By.className("login-button")));//message-error
    }
    public WebElement Logout_appear (){
        return (driver.findElement(By.className("ico-logout")));
    }
    public WebElement Login_Err_MSG (){
        return (driver.findElement(By.className("message-error")));
    }

}
