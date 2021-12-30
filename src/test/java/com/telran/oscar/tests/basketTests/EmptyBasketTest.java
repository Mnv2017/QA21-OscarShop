package com.telran.oscar.tests.basketTests;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmptyBasketTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickLogOut().clickLoginBtn()
                .logInUser(new User().setEmail("nm123@mail.com").setPassword("Qwerty123$"));
    }

    @Test
    public void deleteAllProductsFromBasket() {
        if (!new HeaderPage(driver).getBasketSum().contains("£0.00")) {
            new HeaderPage(driver).clickViewBasket().emptyBasket();
        }
    }

    // проверить сумму корзины = 0 - внутри написано "Корзина пустая"
}
