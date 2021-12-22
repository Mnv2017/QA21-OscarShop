package com.telran.oscar.tests.smoke.loginTests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() { // создаем аккаунт и заходим в него
        new HomePage(driver).clickRegisterBtn()
                .createNewAccount("nm456@mail.com", "Qwerty123$").clickAccountBtn();
    }

    @Test
    public void editProfileTest() {
        new ProfilePage(driver).clickEditProfileBtn().editProfile("Ivan", "Ivanov");
        Assert.assertEquals(new ProfilePage(driver).getAlertText(), "Profile updated");
        Assert.assertEquals(new ProfilePage(driver).getAccountName(), "Ivan Ivanov");
    }

    @Test
    public void changePasswordTest() {
        new ProfilePage(driver).clickChangePasswordBtn().changePassword("Qwerty123$", "Qwerty1234$");
        Assert.assertEquals(new ProfilePage(driver).getAlertText(), "Password updated");
    }

    @Test
    public void deleteAccountTest() {
        new ProfilePage(driver).clickDeleteProfileBtn().deleteProfile("Qwerty1234$");
        Assert.assertEquals(new HomePage(driver)
                .getAlertText(), "Your profile has now been deleted. Thanks for using the site.");
    }
}
