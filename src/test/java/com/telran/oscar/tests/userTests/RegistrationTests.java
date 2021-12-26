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
        new HeaderPage(driver).clickLogOut().clickRegisterBtn();
    }

    @Test
    public void registrationNewUserPositiveTest() {
        new RegisterPage(driver)
                .createNewAccount("nm456@mail.com", "Qwerty123$");
        Assert.assertEquals(new HomePage(driver).getAlertText(), "Thanks for registering!");
        Assert.assertEquals(new HeaderPage(driver).clickAccountBtn().getAccountEmail(), "nm456@mail.com");
    }
    // ToDo добавить DataProvider для проверки всех позитивных вариантов

    @Test
    public void registrationOldUserNegativeTest() {
        new RegisterPage(driver)
                .createNewAccount("nm123@mail.com", "Qwerty123$");
        Assert.assertTrue(new RegisterPage(driver).isEmailAlreadyExistMsgPresent());
    }

    @Test
    public void registrationWithShortPasswordNegativeTest(){
        new RegisterPage(driver).createNewAccountUser(new User().setEmail("nm456@mail.com").setPassword("Qwerty")
                .setPassword2("Qwerty"));
        Assert.assertTrue(new RegisterPage(driver).isErrorAlertPresent());
        Assert.assertTrue(new RegisterPage(driver).isPasswordTooShortMessagePresent());
    }

    @Test
    public void registrationWithCommonPasswordNegativeTest(){
        new RegisterPage(driver).createNewAccountUser(new User().setEmail("nm456@mail.com").setPassword("123456789")
                .setPassword2("123456789"));
        Assert.assertTrue(new RegisterPage(driver).isErrorAlertPresent());
        Assert.assertTrue(new RegisterPage(driver).isPasswordTooCommonMessagePresent());
    }

    @Test
    public void registrationWithEmptyEmailNegativeTest(){
        new RegisterPage(driver).createNewAccountUser(new User().setPassword("Qwerty123$").setPassword2("Qwerty123$"));
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @Test
    public void registrationWithEmptyPasswordNegativeTest(){
        new RegisterPage(driver).createNewAccountUser(new User().setEmail("nm456@mail.com")
                .setPassword2("Qwerty123$"));
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @Test
    public void registrationWithEmptyConfirmNegativeTest(){
        new RegisterPage(driver).createNewAccountUser(new User().setEmail("nm456@mail.com")
                .setPassword("Qwerty123$"));
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @Test
    public void registrationWithDifferentConfirmNegativeTest(){
        new RegisterPage(driver).createNewAccountUser(new User().setEmail("nm456@mail.com")
                .setPassword("Qwerty123$").setPassword2("Qwerty456$"));
        Assert.assertTrue(new RegisterPage(driver).isErrorAlertPresent());
        Assert.assertEquals(new RegisterPage(driver).getErrMessageText(),"The two password fields didn't match.");
    }

    @Test(dataProvider = "newUserWrongEmailFromCSV", dataProviderClass = DataProviders.class)
    public void registrationNewUserWrongEmailNegativeTest(User user) {
        new RegisterPage(driver)
                .createNewAccountUser(user);
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    // ToDo -  удалить из списка негативных пароли, разрешающие регистрацию пользователя

    @Test(dataProvider = "newUserWrongPasswordFromCSV", dataProviderClass = DataProviders.class)
    public void registrationNewUserWrongPasswordNegativeTest(User user) {
        new RegisterPage(driver)
                .createNewAccountUser(user);
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
    }

    @AfterMethod
    public void deleteAccount() {
        if (new HeaderPage(driver).isAccountBtnPresent()) {
            new HeaderPage(driver).clickAccountBtn();
            new ProfilePage(driver).clickDeleteProfileBtn().deleteProfile("Qwerty123$");
        }
    }

}
