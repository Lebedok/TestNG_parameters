package Selenium.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

   @Test

    @Parameters({"username", "password"})
    public void parametersTest(String myUserName, String myPassword){
        driver.get("https://facebook.com/");
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        WebElement login = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        login.sendKeys(myUserName);
        password.sendKeys(myPassword);

    }

}
