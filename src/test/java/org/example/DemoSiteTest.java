package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class DemoSiteTest {
    private WebDriver driver;

    @Before
    public void setup() {

        driver = new ChromeDriver();
    }
    @Test
    public void AddUserTest() throws InterruptedException{
        driver.manage().window().maximize();
        sleep(2000);
        driver.get("http://thedemosite.co.uk/addauser.php");
        sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("kyle1");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("kyle1");
        WebElement submitbutton = driver.findElement(By.name("FormsButton2"));
        submitbutton.click();
        sleep(2000);
    }

    @Test
    public void LoginNewUser() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://thedemosite.co.uk/login.php");
        sleep (2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("kyle1");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("kyle1");
        sleep(2000);
        WebElement submitbutton = driver.findElement(By.name("FormsButton2"));
        submitbutton.click();
        sleep(2000);
        WebElement successmessage = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
        successmessage.getText();
        List<WebElement> list = driver.findElements(By.tagName("P"));
       assertTrue(successmessage.isDisplayed());
        System.out.println(successmessage);
    }


    @After
    public void teardown() {

        driver.quit();
    }

}
