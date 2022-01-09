package com.telran.oscar.tests;

import com.telran.oscar.helpers.MyListener;
import com.telran.oscar.helpers.PropertiesLoader;
import com.telran.oscar.pages.home.HeaderPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static EventFiringWebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    String browser = System.getProperty("browser", BrowserType.CHROME);

    public static String baseURL = PropertiesLoader.loadProperty("url");
    public static String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static String validPassword = PropertiesLoader.loadProperty("valid.password");

    @BeforeSuite
    public void setUp() {
        // скрываем экран при выполнении тестов
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("windows-size=1200x800"); // задаем размер невидимого экрана
//        driver = new ChromeDriver(options);

        if (browser.equals(BrowserType.CHROME)){
            driver = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)){
            driver = new EventFiringWebDriver(new FirefoxDriver());
        } else if (browser.equals(BrowserType.SAFARI)){
            driver = new EventFiringWebDriver(new SafariDriver());
        }

        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1800,900));
//        driver.get(baseURL); // если используем файл с Properties
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
