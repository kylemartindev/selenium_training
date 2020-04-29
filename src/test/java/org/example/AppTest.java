package org.example;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.lang.Thread.*;
import static org.junit.Assert.assertTrue;

public class AppTest
{
private WebDriver driver;

@Before
public void setup() {

    driver = new ChromeDriver();
}
@Test
public void SeleniumTest() throws InterruptedException{
    driver.manage().window().maximize();
    sleep(2000);
    driver.get("https://www.google.com");
    sleep(2000);
   WebElement googlesearch = driver.findElement(By.name("q"));
   googlesearch.sendKeys(Keys.chord("funny", "dog" ,"pics" , Keys.ENTER));
   sleep(1000);
   googlesearch.submit();
   WebElement linktopics = driver.findElement(By.partialLinkText("Images for funny dogs"));
   linktopics.click();
   sleep(1000);
   WebElement imageslink = driver.findElement(By.className("NZmxZe"));
   assertTrue (imageslink.isDisplayed());
   imageslink.getLocation();
   imageslink.getSize();
   imageslink.getText();
   imageslink.isDisplayed();
   imageslink.isSelected();//to check if a box is selected, radio or selection

    Actions actions = new Actions(driver);
    actions.moveByOffset(50,50).clickAndHold().moveByOffset(50,50).perform();
    actions.moveToElement(imageslink).click().perform();//always add perform when building an action

}

@After
    public void teardown() {

    driver.quit();
}


}
