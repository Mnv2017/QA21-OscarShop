package com.telran.oscar.tests;

import com.telran.oscar.helpers.MyListener;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static EventFiringWebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    String browser = System.getProperty("browser", BrowserType.CHROME);

    @BeforeSuite
    public void setUp() {

        if (browser.equals(BrowserType.CHROME)){
            driver = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)){
            driver = new EventFiringWebDriver(new FirefoxDriver());
        } else if (browser.equals(BrowserType.SAFARI)){
            driver = new EventFiringWebDriver(new SafariDriver());
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://selenium1py.pythonanywhere.com/en-gb");

        driver.register(new MyListener());

        Cookie cookieEn = new Cookie("django_language", "en-gb");
        driver.manage().addCookie(cookieEn);

    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("################ Start test " + m.getName() + "with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info(("################ PASSED: test method " + result.getMethod().getMethodName()));
        } else {
            logger.error("################ FAILED: test method " + result.getMethod().getMethodName());
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
