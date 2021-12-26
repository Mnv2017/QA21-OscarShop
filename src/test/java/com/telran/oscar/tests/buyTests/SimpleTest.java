package com.telran.oscar.tests.buyTests;

import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest extends TestBase {

//    @BeforeMethod
//    public void ensurePreconditions() {
//        new HomePage(driver).clickOnRecommendReading();
//    }
//
//    @Test
//    public void putBookInBasket() {
//        new ProductBookPage(driver).addBookToBasket();
//    }


    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickLogOut().clickLoginBtn();
    }

    @Test
    public void loginUserPositiveTest() {
        new LoginPage(driver).logIn(validEmail, validPassword);
        Assert.assertEquals(new HomePage(driver).getAlertText(), "Welcome back");
        Assert.assertEquals(new HeaderPage(driver).clickAccountBtn().getAccountEmail(), "nm123@mail.com");
    }
}
