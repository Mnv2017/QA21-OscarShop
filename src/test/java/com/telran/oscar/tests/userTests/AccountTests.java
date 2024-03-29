package com.telran.oscar.tests.userTests;

import com.telran.oscar.data.Address;
import com.telran.oscar.data.User;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.user.AccountSidebarPage;
import com.telran.oscar.pages.user.AddressPage;
import com.telran.oscar.pages.user.ChangePasswordPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions() throws InterruptedException {
        new HeaderPage(driver).clickLogOut().clickRegisterBtn()
                .createNewAccountUser(new User().setEmail(User.REG_EMAIL)
                        .setPassword(User.REG_PASSWORD).setPassword2(User.REG_PASSWORD)).clickAccountBtn();
    }

    @Test(priority = 1)
    public void editProfileTest() {
        new ProfilePage(driver).clickEditProfileBtn().editProfile("Ivan", "Ivanov");
        Assert.assertEquals(new ProfilePage(driver).getAlertText(), "Profile updated");
        Assert.assertEquals(new ProfilePage(driver).getAccountName(), "Ivan Ivanov");
    }

    @Test(priority = 2)
    public void changePasswordPositiveTest() {
        new ProfilePage(driver).clickChangePasswordBtn().changePassword("Qwerty123$", "Qwerty1234$", "Qwerty1234$");
        Assert.assertEquals(new ProfilePage(driver).getAlertText(), "Password updated");
    }

    @Test(priority = 3)
    public void changePasswordDifferentConfirmationNegativeTest() {
        new ProfilePage(driver).clickChangePasswordBtn().changePassword("Qwerty1234$", "Qwerty12345$", "Qwerty34$");
        Assert.assertTrue(new ChangePasswordPage(driver).isErrorAlertPresent());
        Assert.assertEquals(new ChangePasswordPage(driver).getErrMessageText(), "The two password fields didn't match.");
    }

    @Test(priority = 4)
    public void addAndEditAddressTest() {
        AddressPage addressPage = new AccountSidebarPage(driver).clickAddressBookItem().clickAddNewAddressBtn()
                .fillShippingAddressForm().clickSaveAddressBtn();
        Assert.assertTrue(addressPage.getAddress().contains(Address.F_NAME));
        Assert.assertTrue(addressPage.getAddress().contains(Address.L_NAME));
        Assert.assertTrue(addressPage.getAddress().contains(Address.AD_LINE1));
        Assert.assertTrue(addressPage.getAddress().contains(Address.POST_CODE));
        Assert.assertTrue(addressPage.getAddress().contains(Address.COUNTRY));

        addressPage.clickEditBtn().editFirstLineAddress(Address.EDIT_AD_LINE1).clickSaveAddressBtn();
        Assert.assertTrue(addressPage.getAddress().contains(Address.EDIT_AD_LINE1));
    }

    @Test(priority = 5)
    public void deleteAccountTest() throws InterruptedException {
        new AccountSidebarPage(driver).getProfilePage().clickDeleteProfileBtn().deleteProfile("Qwerty1234$");
        Assert.assertEquals(new HomePage(driver)
                .getAlertText(), "Your profile has now been deleted. Thanks for using the site.");
    }

}
