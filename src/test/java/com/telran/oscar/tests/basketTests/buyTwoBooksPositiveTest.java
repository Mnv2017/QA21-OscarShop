package com.telran.oscar.tests.basketTests;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.basket.ConfirmationPage;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.user.AccountSidebarPage;
import com.telran.oscar.pages.user.OrderHistoryPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class buyTwoBooksPositiveTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickLogOut()
                .clickLoginBtn()
                .logInUser(new User().setEmail("nm123@mail.com").setPassword("Qwerty123$"));
        if (!new HeaderPage(driver).getBasketSum().contains("£0.00"))
            new HeaderPage(driver).clickViewBasket().emptyBasket().returnToHomePage();

    }

    @Test
    public void selectBookAndPutInBasket() {
        new BrowseStoreMenuPage(driver).clickOnAllProductsItem().clickOnNBookInList(4).addBookToBasket();
        new HeaderPage(driver).searchProductByName("Hacking Work")
                .clickOnSelectedBook("Hacking Work")
                .addBookToBasket();
        String sumItems = new HeaderPage(driver).clickViewBasket().countBasketTotalPrice(2);
        Assert.assertEquals(sumItems, new BasketPage(driver).getOrderTotalPrice());

        String orderNum = new BasketPage(driver).clickProceedToCheckout().fillShippingAddressForm().continueToPreview()
                .clickPlaceOrderBtn().getOrderNum();
        new ConfirmationPage(driver).clickContinueShopping().clickAccountBtn();
        new AccountSidebarPage(driver).clickOrderHistory();
        Assert.assertEquals(sumItems, new OrderHistoryPage(driver).getLastOrderSum());
        Assert.assertEquals(orderNum, new OrderHistoryPage(driver).getLastOrderNumber());

    }

}
