package com.telran.oscar.tests.smoke.loginTests;

import com.telran.oscar.data.User;
import com.telran.oscar.helpers.DataProviders;
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
        Assert.assertEquals(new HomePage(driver).clickAccountBtn().getAccountEmail(), "nm456@mail.com");
    }
    // ToDo добавить DataProvider для проверки всех позитивных вариантов

    @Test(enabled = true)
    public void registrationOldUserNegativeTest() {
        new RegisterPage(driver)
                .createNewAccount("nm123@mail.com", "Qwerty123$");
        Assert.assertTrue(new RegisterPage(driver).isEmailAlreadyExistMsgPresent());
    }

    // ToDo добавить негативный для пароля - This password is too short
    // ToDo добавить негативный для пароля - This password is too common
    // ToDo добавить негативный тест - пароль != подтверждению пароля
    // ToDo добавить негативные тесты - пустой емейл / пароль

    @Test(dataProvider = "newUserWrongEmailFromCSV", dataProviderClass = DataProviders.class)
    public void registrationNewUserWrongEmailNegativeTest(User user) {
        new RegisterPage(driver)
                .createNewAccountUser(user);
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @Test(dataProvider = "newUserWrongPasswordFromCSV", dataProviderClass = DataProviders.class)
    public void registrationNewUserWrongPasswordNegativeTest(User user) {
        new RegisterPage(driver)
                .createNewAccountUser(user);
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @AfterMethod
    public void deleteAccount() {
        if (new HomePage(driver).isAccountBtnPresent()) {
            new HomePage(driver).clickAccountBtn();
            new ProfilePage(driver).clickDeleteProfileBtn().deleteProfile("Qwerty123$");
        }
    }

}
