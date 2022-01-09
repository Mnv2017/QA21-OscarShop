package com.telran.oscar.tests.userTests;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.basket.ConfirmationPage;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.product.BooksPage;
import com.telran.oscar.pages.user.AccountSidebarPage;
import com.telran.oscar.pages.user.OrderHistoryPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderHistoryTests extends TestBase {
    private String name;
    private String price;
    private String orderNum;

    @BeforeClass
    public void ensurePreconditions() throws InterruptedException {
        new HeaderPage(driver).clickOnLogo();
        new HeaderPage(driver).clickLogOut().clickLoginBtn().logInUser(new User()
                .setEmail(User.LOG_EMAIL).setPassword(User.LOG_PASSWORD));

        BooksPage booksPage = new BrowseStoreMenuPage(driver).clickOnBooksItem().addBookNToBasket(3);
        name = booksPage.getBookNName(3);
        price = booksPage.getBookNPrice(3);

        orderNum = new HeaderPage(driver).clickViewBasket().clickProceedToCheckout().specifyShippingAddress()
                .continueToPreview().clickPlaceOrderBtn().getOrderNum();
        new ConfirmationPage(driver).clickContinueShopping().clickAccountBtn();
    }

    @Test
    public void orderHistoryTest() {
        OrderHistoryPage orderHistoryPage = new AccountSidebarPage(driver).clickOrderHistoryItem();
        Assert.assertEquals(orderHistoryPage.getLastOrderNumber(), orderNum);
        Assert.assertEquals(orderHistoryPage.getNumItem(), "1");
        Assert.assertEquals(orderHistoryPage.getLastOrderSum(), price);
        Assert.assertEquals(orderHistoryPage.clickOrderNumber().getFirstProductName(),name);
        Assert.assertEquals(orderHistoryPage.getFirstLinePrice(),price);
        Assert.assertEquals(orderHistoryPage.getOrderTotal(),price);
    }

    @AfterMethod
    public void postConditions() {
        new HeaderPage(driver).clickLogOut();
    }
}
