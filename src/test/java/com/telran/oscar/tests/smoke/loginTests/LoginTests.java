package com.telran.oscar.tests.smoke.loginTests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.product.ProductBookPage;
import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).logOut().clickLoginOrRegisterBtn();
    }

    @Test
    public void loginUserPositiveTest() {
        new LoginPage(driver).logIn("nm123@mail.com","Qwerty123$");
        Assert.assertEquals(new HomePage(driver).getAlertText(),"Welcome back");
        Assert.assertEquals(new HomePage(driver).clickAccountBtn().getAccountEmail(),"nm123@mail.com");
    }

    // ToDo 1. добавить Dataprovider
}

