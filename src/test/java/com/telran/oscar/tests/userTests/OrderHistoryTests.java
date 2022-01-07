package com.telran.oscar.tests.userTests;

import com.telran.oscar.data.Address;
import com.telran.oscar.data.User;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.user.AccountSidebarPage;
import com.telran.oscar.pages.user.AddressPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderHistoryTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions() {
        new HeaderPage(driver).clickOnLogo();
        new HeaderPage(driver).clickLogOut().clickRegisterBtn()
                .createNewAccountUser(new User().setEmail(User.REG_EMAIL)
                        .setPassword(User.REG_PASSWORD).setPassword2(User.REG_PASSWORD)).clickAccountBtn();

    }

    //ToDo добавить тесты Order History
    @Test
    public void orderHistoryTest() {
        new AccountSidebarPage(driver).clickOrderHistoryItem();
    }
    // заказать одну книгу - проверить имя и сумму в Order History - перезаказать


    @AfterMethod
    public void postConditions() {
        new HeaderPage(driver).clickAccountBtn().clickDeleteProfileBtn().deleteProfile(User.REG_PASSWORD);
    }
}
