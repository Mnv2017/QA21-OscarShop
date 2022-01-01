package com.telran.oscar.tests;

import com.telran.oscar.helpers.MyListener;
import com.telran.oscar.helpers.PropertiesLoader;
import com.telran.oscar.pages.home.HeaderPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static EventFiringWebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    public Cookie cookieLanguage;

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

        driver = new EventFiringWebDriver(new ChromeDriver());
//        driver = new EventFiringWebDriver(new FirefoxDriver());

        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1800,900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://selenium1py.pythonanywhere.com");
//        driver.get(baseURL); // если используем файл с Properties
        driver.register(new MyListener());

        new HeaderPage(driver).setLanguage("British English");
        cookieLanguage = driver.manage().getCookieNamed("django_language");
        System.out.println("#############  " + cookieLanguage.toString());
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

    @AfterSuite(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
