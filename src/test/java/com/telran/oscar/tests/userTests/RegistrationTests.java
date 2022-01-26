package com.telran.oscar.tests.userTests;

import com.telran.oscar.data.User;
import com.telran.oscar.helpers.DataProviders;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
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
        new HeaderPage(driver).clickOnLogo();
        new HeaderPage(driver).clickLogOut().clickRegisterBtn();
    }

    @Test
    public void registrationNewUserPositiveTest() throws InterruptedException {
        new RegisterPage(driver)
                .createNewAccountUser(new User().setEmail(User.REG_EMAIL)
                        .setPassword(User.REG_PASSWORD).setPassword2(User.REG_PASSWORD));
        Assert.assertEquals(new HomePage(driver).getAlertText(), "Thanks for registering!");
        Assert.assertEquals(new HeaderPage(driver).clickAccountBtn().getAccountEmail(), User.REG_EMAIL);
    }

    @Test
    public void registrationOldUserNegativeTest() {
        new RegisterPage(driver)
                .createNewAccountUser(new User().setEmail(User.LOG_EMAIL)
                        .setPassword(User.LOG_PASSWORD).setPassword2(User.LOG_PASSWORD));
        Assert.assertEquals(new RegisterPage(driver).getErrMessageText(),
                "A user with that email address already exists");
    }

    @Test
    public void registrationWithShortPasswordNegativeTest() {
        new RegisterPage(driver).createNewAccountUser(new User().setEmail(User.REG_EMAIL).setPassword("Qwerty")
                .setPassword2("Qwerty"));
        Assert.assertTrue(new RegisterPage(driver).isErrorAlertPresent());
        Assert.assertTrue(new RegisterPage(driver).isPasswordTooShortMessagePresent());
    }

    @Test
    public void registrationWithCommonPasswordNegativeTest() {
        new RegisterPage(driver).createNewAccountUser(new User().setEmail(User.REG_EMAIL).setPassword("123456789")
                .setPassword2("123456789"));
        Assert.assertTrue(new RegisterPage(driver).isErrorAlertPresent());
        Assert.assertTrue(new RegisterPage(driver).isPasswordTooCommonMessagePresent());
    }

    @Test
    public void registrationWithEmptyEmailNegativeTest() {
        new RegisterPage(driver).createNewAccountUser(new User().setPassword(User.REG_PASSWORD).setPassword2(User.REG_PASSWORD));
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @Test
    public void registrationWithEmptyPasswordNegativeTest() {
        new RegisterPage(driver).createNewAccountUser(new User().setEmail(User.REG_EMAIL)
                .setPassword2(User.REG_PASSWORD));
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @Test
    public void registrationWithEmptyConfirmNegativeTest() {
        new RegisterPage(driver).createNewAccountUser(new User().setEmail(User.REG_EMAIL)
                .setPassword(User.REG_PASSWORD));
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @Test
    public void registrationWithDifferentConfirmNegativeTest() {
        new RegisterPage(driver).createNewAccountUser(new User().setEmail(User.REG_EMAIL)
                .setPassword("Qwerty123$").setPassword2("Qwerty456$"));
        Assert.assertTrue(new RegisterPage(driver).isErrorAlertPresent());
        Assert.assertEquals(new RegisterPage(driver).getErrMessageText(),
                "The two password fields didn't match.");
    }

    @Test(dataProvider = "newUserWrongEmailFromCSV", dataProviderClass = DataProviders.class)
    public void registrationNewUserWrongEmailNegativeTest(User user) {
        new RegisterPage(driver)
                .createNewAccountUser(user);
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @Test(dataProvider = "newUserWrongPasswordFromCSV", dataProviderClass = DataProviders.class)
    public void registrationNewUserWrongPasswordNegativeTest(User user) throws InterruptedException {
        new RegisterPage(driver)
                .createNewAccountUser(user);
        var passed = true;
        if (new HeaderPage(driver).isAccountBtnPresent()) {
            passed = false;
            new HeaderPage(driver).clickAccountBtn();
            new ProfilePage(driver).clickDeleteProfileBtn().deleteProfile(user.getPassword());
        }
        Assert.assertTrue(passed);
    }

    @AfterMethod
    public void deleteAccount() throws InterruptedException {
        if (new HeaderPage(driver).isAccountBtnPresent()) {
            new HeaderPage(driver).clickAccountBtn();
            new ProfilePage(driver).clickDeleteProfileBtn().deleteProfile(User.LOG_PASSWORD);
        }
    }


}
