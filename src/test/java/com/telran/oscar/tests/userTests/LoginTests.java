package com.telran.oscar.tests.userTests;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickLogOut().clickLoginBtn();
    }

    @Test(priority = 1)
    public void loginUserPositiveTest() {
        new LoginPage(driver).logIn("nm123@mail.com", "Qwerty123$");
        Assert.assertEquals(new HomePage(driver).getAlertText(), "Welcome back");
        Assert.assertEquals(new HeaderPage(driver).clickAccountBtn().getAccountEmail(), "nm123@mail.com");
    }

    @Test(priority = 2)
    public void loginUserWrongEmailNegativeTest() {
        new LoginPage(driver).logIn("nm777@mail.com", "Qwerty123$");
        Assert.assertTrue(new LoginPage(driver).isErrorAlertPresent());
    }

    @Test(priority = 3)
    public void loginUserWrongPasswordNegativeTest() {
        new LoginPage(driver).logIn("nm123@mail.com", "12345");
        Assert.assertTrue(new LoginPage(driver).isErrorAlertPresent());
    }

    @Test(priority = 4)
    public void loginUserWithEmptyEmailNegativeTest(){
        new  LoginPage(driver).logInUser(new User().setPassword("Qwerty123$"));
        Assert.assertTrue(new LoginPage(driver).isLoginFormPresent());
    }

    @Test(priority = 5)
    public void loginUserWithEmptyPasswordNegativeTest(){
        new  LoginPage(driver).logInUser(new User().setEmail("nm123@mail.com"));
        Assert.assertTrue(new LoginPage(driver).isLoginFormPresent());
    }
}

