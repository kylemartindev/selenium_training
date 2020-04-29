package org.example;

import com.sun.java.swing.plaf.windows.resources.windows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class DrawMouse {

    private WebDriver driver;

    @Before
    public void setup() {

        driver = new ChromeDriver();
    }

    @Test
    public void SeleniumTest() throws InterruptedException {
        driver.manage().window().maximize();
        sleep(2000);
        driver.get("https://www.youidraw.com/apps/painter/");
        sleep(2000);

        Actions house = new Actions(driver);
        house.moveByOffset(200, 200).clickAndHold().moveByOffset(0, 300).perform();
        house.moveByOffset(300, 0).clickAndHold().moveByOffset(0, -300).perform();
        house.moveByOffset(-300, 0).perform();
        sleep(3000);
        Actions roof = new Actions(driver);
        roof.moveByOffset(150, -150).clickAndHold().moveByOffset(150,150).perform();
        roof.release().perform();
        sleep(3000);
        Actions topwindowright = new Actions(driver);
        topwindowright.moveByOffset (-250,50).clickAndHold().moveByOffset(50,0).perform();
        topwindowright.moveByOffset (0,50).clickAndHold().moveByOffset(-50,0).perform();
        topwindowright.moveByOffset(0,-50).perform();
        topwindowright.release().perform();
        topwindowright.moveByOffset(25,0).clickAndHold().moveByOffset(0,50).perform();
        sleep(3000);
        topwindowright.release().perform();
        topwindowright.moveByOffset(-25,-25).clickAndHold().moveByOffset(50,0).perform();
        topwindowright.release().perform();
        sleep(3000);
        Actions topleftwindow = new Actions(driver);
        topleftwindow.moveByOffset(100,-25).clickAndHold().moveByOffset(50,0).perform();
        sleep(3000);
        topleftwindow.moveByOffset(0,50).clickAndHold().moveByOffset(-50,0).perform();
        sleep(3000);
        topleftwindow.moveByOffset(0,-50).perform();
        sleep(3000);
        topleftwindow.release().perform();
        topleftwindow.moveByOffset(25,0).clickAndHold().moveByOffset(0,50).perform();
        sleep(3000);
        topleftwindow.release().perform();
        topleftwindow.moveByOffset(-25,-25).clickAndHold().moveByOffset(50,0).perform();
        topleftwindow.release().perform();
        Actions bottomrightwindow = new Actions(driver);
        //bottomrightwindow

    }

    @After
    public void teardown() {

        driver.quit();
    }


}