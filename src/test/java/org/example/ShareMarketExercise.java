package org.example;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class ShareMarketExercise {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    @BeforeTest
    public void startReport(){
        report = new ExtentReports(
                System.getProperty("user.dir") + "/test-output/Report.html",
                true
        );
        report
                .addSystemInfo("Host Name", "QA")
                .addSystemInfo("Tester", "Kyle Martin");
        report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-report.xml"));
    }
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void gettingrisers() throws IOException {
        test = report.startTest("Testing the stock market website");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        test.log(LogStatus.INFO, "Navigating to the Market website");
        //WebElement logo = driver.findElement(By.id("topNavItems"));
        //assertTrue(logo.isDisplayed());
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 1000)");
        WebElement riser = (new WebDriverWait(driver,5000
        )).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("RISERS")));
        WebElement riserclick = driver.findElement(By.partialLinkText("RISERS"));
        riserclick.click();
        WebElement checkpage = (new WebDriverWait(driver,5000
        )).until(ExpectedConditions.presenceOfElementLocated(By.className("main")));
        JavascriptExecutor mainscroll = (JavascriptExecutor)driver;
        mainscroll.executeScript("scroll(0, 1000)");
        File pictureriser = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(pictureriser, new File(System.getProperty("user.dir") + "/test-output/riserpage.jpg"));
        test.log(LogStatus.PASS, "The logo was present", "<img src=riserpage.jpg>");
    }

    @Test
    public void gettingfallers() throws IOException {
        test = report.startTest("Testing the stock market website");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        test.log(LogStatus.INFO, "Navigating to the Market website");
        ////WebElement logo = driver.findElement(By.id("topNavItems"));
        //assertTrue(logo.isDisplayed());
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 1000)");
        WebElement riser = (new WebDriverWait(driver,5000
        )).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("FALLERS")));
        WebElement fallerclick = driver.findElement(By.partialLinkText("FALLERS"));
        fallerclick.click();
        WebElement checkpage = (new WebDriverWait(driver,5000
        )).until(ExpectedConditions.presenceOfElementLocated(By.className("main")));
        JavascriptExecutor mainscroll = (JavascriptExecutor)driver;
        mainscroll.executeScript("scroll(0, 1000)");
        File picturefaller = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(picturefaller, new File(System.getProperty("user.dir") + "/test-output/fallerspage.jpg"));
        test.log(LogStatus.PASS, "The logo was present", "<img src=fallerspage.jpg>");
    }


    @AfterMethod
    public void getResult(ITestResult result){
        driver.close();
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(LogStatus.FAIL, "Test has failed " + result.getName());
            test.log(LogStatus.FAIL, "Test has failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, "Test has passed " + result.getName());
        }
        report.endTest(test);
    }

    @AfterTest
    public void endReport(){
        report.flush();
        report.close();
    }








}
