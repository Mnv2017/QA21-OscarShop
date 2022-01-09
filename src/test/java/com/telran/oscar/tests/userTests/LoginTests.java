package com.telran.oscar.tests.userTests;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickLogOut().clickLoginBtn();
    }

    @Test(priority = 1)
    public void loginUserPositiveTest() throws InterruptedException {
        new LoginPage(driver).logInUser(new User().setEmail(User.LOG_EMAIL).setPassword(User.LOG_PASSWORD));
        Assert.assertEquals(new HomePage(driver).getAlertText(), "Welcome back");
        Assert.assertEquals(new HeaderPage(driver).clickAccountBtn().getAccountEmail(), User.LOG_EMAIL);
    }

    @Test(priority = 2)
    public void loginUserWrongEmailNegativeTest() {
        new LoginPage(driver).logInUser(new User().setEmail("nm777@mail.com").setPassword(User.LOG_PASSWORD));
        Assert.assertTrue(new LoginPage(driver).isErrorAlertPresent());
    }

    @Test(priority = 3)
    public void loginUserWrongPasswordNegativeTest() {
        new LoginPage(driver).logInUser(new User().setEmail(User.LOG_EMAIL).setPassword("12345"));
        Assert.assertTrue(new LoginPage(driver).isErrorAlertPresent());
    }

    @Test(priority = 4)
    public void loginUserWithEmptyEmailNegativeTest() {
        new LoginPage(driver).logInUser(new User().setPassword(User.LOG_PASSWORD));
        Assert.assertTrue(new LoginPage(driver).isLoginFormPresent());
    }

    @Test(priority = 5)
    public void loginUserWithEmptyPasswordNegativeTest() {
        new LoginPage(driver).logInUser(new User().setEmail(User.LOG_EMAIL));
        Assert.assertTrue(new LoginPage(driver).isLoginFormPresent());
    }

    @AfterClass
    public void logOut() {
        new HeaderPage(driver).clickLogOut();
    }
}

