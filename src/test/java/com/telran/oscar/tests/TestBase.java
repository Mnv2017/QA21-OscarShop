package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    public Cookie cookieLanguage;

    @BeforeMethod
    public void setUp() {
        // скрываем экран при выполнении тестов
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("windows-size=1200x800"); // задаем размер невидимого экрана
//        driver = new ChromeDriver(options);

        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1800,900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://selenium1py.pythonanywhere.com/en-gb");
        new HomePage(driver).setLanguage("British English");
        cookieLanguage = driver.manage().getCookieNamed("django_language");
        System.out.println("#############  " + cookieLanguage.toString());
    }

//    @BeforeMethod
//    public void setLanguage() {
//        new HomePage(driver).setLanguage("British English");
//    }

    @BeforeMethod
    public void startTest(Method m) {
        logger.info("#### Start test " + m.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info(("#### PASSED: test method " + result.getMethod().getMethodName()));
        } else {
            logger.error("#### FAILED: test method " + result.getMethod().getMethodName());
        }
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
