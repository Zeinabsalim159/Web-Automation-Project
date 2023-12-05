package org_examples.StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class Hooks {
    public static WebDriver driver;
    static SoftAssert soft = new SoftAssert();

    @Before
    public void open_browser() {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
       //driver = new EdgeDriver();
*/
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        //driver = new EdgeDriver();
        // 3- configuration to your driver
       // driver.manage().window().maximize();
       //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @After
    public void quit_from_browser() {

        driver.quit();
    }


}
