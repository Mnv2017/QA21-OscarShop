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

public class BuyTwoBooksSmokeTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickLogOut()
                .clickLoginBtn()
                .logInUser(new User().setEmail(User.LOG_EMAIL).setPassword(User.LOG_PASSWORD));

//        new HeaderPage(driver).clickLogOut()
//                .clickRegisterBtn().createNewAccountUser(new User()
//                .setEmail(User.REG_EMAIL).setPassword(User.REG_PASSWORD).setPassword2(User.REG_PASSWORD));

        new HeaderPage(driver).deleteAllProductsFromBasket();
        new BrowseStoreMenuPage(driver).clickOnBooksItem().addBookNToBasket(4);
        new HeaderPage(driver).searchProductByName("Hacking Work")
                .clickOnSelectedBook("Hacking Work")
                .addBookToBasket();
    }

    @Test
    public void buyTwoBooksPositiveTest() {
        String itemsSum = new HeaderPage(driver).clickViewBasket().countBasketTotalPrice(2);
        Assert.assertEquals(itemsSum, new BasketPage(driver).getOrderTotalPrice());

        String orderNum = new BasketPage(driver).clickProceedToCheckout().specifyShippingAddress().continueToPreview()
                .clickPlaceOrderBtn().getOrderNum();
        new ConfirmationPage(driver).clickContinueShopping().clickAccountBtn();
        new AccountSidebarPage(driver).clickOrderHistoryItem();
        Assert.assertEquals(itemsSum, new OrderHistoryPage(driver).getLastOrderSum());
        Assert.assertEquals(orderNum, new OrderHistoryPage(driver).getLastOrderNumber());

    }

//    @AfterMethod
//    public void postConditions(){
//        new HeaderPage(driver).clickAccountBtn().clickDeleteProfileBtn().deleteProfile(User.REG_PASSWORD);
//    }
}
