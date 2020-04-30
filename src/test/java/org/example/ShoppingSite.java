package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingSite {

    private WebDriver driver;

    @BeforeClass
    public void onetimesetup() {

    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    //@Test
    public void login() {
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        WebElement signinbutton = driver.findElement(By.className("login"));
        signinbutton.click();
        WebElement loginpage = (new WebDriverWait(driver,10
        )).until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitLogin")));
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("kyle3@gmail.com");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("testing1234");
        WebElement submit = driver.findElement(By.id("SubmitLogin"));
        submit.click();
        //assertTrue();
        WebElement homepage = driver.findElement(By.className("home"));
        homepage.click();
    }

    @Test
    public void searchforitem() {
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        WebElement signinbutton = driver.findElement(By.className("login"));
        signinbutton.click();
        WebElement loginpage = (new WebDriverWait(driver,10
        )).until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitLogin")));
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("kyle.martin3@gmail.com");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("testing1234");
        WebElement submit = driver.findElement(By.id("SubmitLogin"));
        submit.click();
       //// WebElement checklogin = (new WebDriverWait(driver,60
        //)).until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitLogin")));
        WebElement homepage = driver.findElement(By.className("home"));
        homepage.click();
       WebElement searchbar = driver.findElement(By.id("search_query_top"));
       searchbar.sendKeys("Blouse");
       searchbar.click();
        WebElement blousefound = driver.findElement(By.linkText("Blouse"));
        blousefound.getText();
        WebElement blouses = (new WebDriverWait(driver,10000
        )).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Blouse")));
       assertTrue(blousefound.isDisplayed());
       blousefound.click();
        WebElement addtocartwait = (new WebDriverWait(driver,120
        )).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add_to_cart\"]/button/span")));
        WebElement addtocart= driver.findElement(By.id("add_to_cart"));
        addtocart.click();
        WebElement shoppingwindow = (new WebDriverWait(driver,120
        )).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")));
        WebElement proceedtocheckout1 = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
        proceedtocheckout1.click();
        WebElement proceedtocheckout2wait = (new WebDriverWait(driver,120
        )).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")));
        WebElement proccedtocheckout2= driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
        proccedtocheckout2.click();

        WebElement proceedtocheckoutAddwait = (new WebDriverWait(driver,120
        )).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")));
        WebElement proccedtocheckoutAddress= driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
        proccedtocheckoutAddress.click();
        WebElement agreetermswait = (new WebDriverWait(driver,120
        )).until(ExpectedConditions.elementToBeClickable(By.id("uniform-cgv")));
        WebElement agreeterms = driver.findElement(By.id("uniform-cgv"));
        agreeterms.click();
        WebElement proccedtocheckoutShipping= driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
        proccedtocheckoutShipping.click();
        WebElement bankwirewait = (new WebDriverWait(driver,120
        )).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")));
        WebElement bankwire = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
        bankwire.click();
        WebElement confirmorder = driver.findElement(By.xpath(" //*[@id=\"cart_navigation\"]/button/span"));
        confirmorder.click();


    }

   // @Test
   // public void




    @After
    public void teardown() {

        driver.quit();
    }





}
