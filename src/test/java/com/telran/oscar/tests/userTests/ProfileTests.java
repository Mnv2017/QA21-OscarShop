package com.telran.oscar.tests.userTests;

import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.user.AccountSidebarPage;
import com.telran.oscar.pages.user.ChangePasswordPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions() { // создаем аккаунт и заходим в него
        new HeaderPage(driver).clickRegisterBtn()
                .createNewAccount("nm456@mail.com", "Qwerty123$").clickAccountBtn();
    }

    @Test(priority = 1)
    public void editProfileTest() {
        new ProfilePage(driver).clickEditProfileBtn().editProfile("Ivan", "Ivanov");
        Assert.assertEquals(new ProfilePage(driver).getAlertText(), "Profile updated");
        Assert.assertEquals(new ProfilePage(driver).getAccountName(), "Ivan Ivanov");
    }

    @Test(priority = 2)
    public void changePasswordPositiveTest() {
        new ProfilePage(driver).clickChangePasswordBtn().changePassword("Qwerty123$", "Qwerty1234$","Qwerty1234$");
        Assert.assertEquals(new ProfilePage(driver).getAlertText(), "Password updated");
    }

    @Test(priority = 3)
    public void changePasswordDifferentConfirmationNegativeTest(){
        new ProfilePage(driver).clickChangePasswordBtn().changePassword("Qwerty1234$","Qwerty12345$","Qwerty34$");
        Assert.assertTrue(new ChangePasswordPage(driver).isErrorAlertPresent());
        Assert.assertEquals(new ChangePasswordPage(driver).getErrMessageText(),"The two password fields didn't match.");
    }

    @Test(priority = 4)
    public void deleteAccountTest() {
        new AccountSidebarPage(driver).getProfilePage().clickDeleteProfileBtn().deleteProfile("Qwerty1234$");
        Assert.assertEquals(new HomePage(driver)
                .getAlertText(), "Your profile has now been deleted. Thanks for using the site.");
    }


}
