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

public class TourExercise {
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
    public void login() throws IOException {
        test = report.startTest("Testing the Tour Website");
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.manage().window().maximize();
        driver.get("http://www.newtours.demoaut.com/");


        File login = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(login, new File(System.getProperty("user.dir") + "/test-output/login.jpg"));
        test.log(LogStatus.PASS, "The logo was present", "<img src=login.jpg>");
    }

    @Test
    public void gettingfallers() throws IOException {
        test = report.startTest("Testing the stock market website");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://www.newtours.demoaut.com/");

        File orderconfirmation = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(orderconfirmation, new File(System.getProperty("user.dir") + "/test-output/orderconfirmation.jpg"));
        test.log(LogStatus.PASS, "The logo was present", "<img src=orderconfirmation.jpg>");
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
