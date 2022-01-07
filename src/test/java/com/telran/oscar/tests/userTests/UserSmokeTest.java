package com.telran.oscar.tests.userTests;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserSmokeTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickLogOut().clickOnLogo();
    }

    @Test
    public void registrationAndLoginSmokeTest() {
        new HeaderPage(driver).clickRegisterBtn().createNewAccountUser(new User()
                .setEmail(User.REG_EMAIL).setPassword(User.REG_PASSWORD).setPassword2(User.REG_PASSWORD));
        Assert.assertEquals(new HomePage(driver).getAlertText(), "Thanks for registering!");
        Assert.assertEquals(new HeaderPage(driver).clickAccountBtn().getAccountEmail(), User.REG_EMAIL);
        new HeaderPage(driver).clickLogOut();
        new HeaderPage(driver).clickLoginBtn().logInUser(new User()
                .setEmail(User.REG_EMAIL).setPassword(User.REG_PASSWORD));
        Assert.assertEquals(new HomePage(driver).getAlertText(), "Welcome back");
        Assert.assertEquals(new HeaderPage(driver).clickAccountBtn().getAccountEmail(), User.REG_EMAIL);
    }

    @AfterMethod
    public void postConditions(){
        new ProfilePage(driver).clickDeleteProfileBtn().deleteProfile(User.REG_PASSWORD);
    }
}
