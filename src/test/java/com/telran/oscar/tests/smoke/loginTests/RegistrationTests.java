package com.telran.oscar.tests.smoke.loginTests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.pages.user.RegisterPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).logOut().clickLoginOrRegisterBtn();
    }

    @Test
    public void registrationNewUserPositiveTest() {
        new RegisterPage(driver)
                .createNewAccount("nm456@mail.com", "Qwerty123$");
        Assert.assertEquals(new HomePage(driver).getAlertText(), "Thanks for registering!");
        Assert.assertEquals(new HomePage(driver).clickAccountBtn().getAccountEmail(),"nm456@mail.com");
        // ToDo 1. добавить Dataprovider
    }

    @AfterMethod
    public void deleteAccount() {
        new ProfilePage(driver).clickDeleteProfileBtn().deleteProfile("Qwerty123$");
    }


}
