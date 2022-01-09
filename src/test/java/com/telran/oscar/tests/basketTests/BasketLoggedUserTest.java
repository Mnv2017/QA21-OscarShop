package com.telran.oscar.tests.basketTests;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.product.NavigateMenuPage;
import com.telran.oscar.pages.product.ProductBookPage;
import com.telran.oscar.pages.product.ProductClothingPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketLoggedUserTest extends TestBase {

    @BeforeClass
    public void classPreconditions() {
        new HeaderPage(driver).clickLogOut().clickLoginBtn()
                .logInUser(new User().setEmail(User.LOG_EMAIL).setPassword(User.LOG_PASSWORD));
    }

    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickOnLogo();
        new HeaderPage(driver).deleteAllProductsFromBasket();
    }

    @Test
    public void addOneBookToBasketTest() {
        String name = new BrowseStoreMenuPage(driver).clickOnBooksItem().clickOnBookNInList(1)
                .addBookToBasket().getBookName();
        String price = new ProductBookPage(driver).getBookPrice();
        Assert.assertTrue(new HeaderPage(driver).getBasketSum().contains(price));
        BasketPage basket = new HeaderPage(driver).clickViewBasket();
        Assert.assertEquals(basket.getItemIName(1), name);
        Assert.assertEquals(basket.getItemIPrice(1), price);
        Assert.assertEquals(basket.getItemITotalPrice(1), price);
        Assert.assertEquals(basket.getOrderTotalPrice(), price);
    }

    @Test
    public void addOneClothingToBasketTest() {
        String name = new BrowseStoreMenuPage(driver).clickOnClothingItem().clickOnFirstClothingInList().getClothingName();
        String price = new ProductClothingPage(driver).addClothingToBasket().getClothingPrice();
        Assert.assertTrue(new HeaderPage(driver).getBasketSum().contains(price));
        BasketPage basket = new HeaderPage(driver).clickViewBasket();
        Assert.assertTrue(basket.getItemIName(1).contains(name));
        Assert.assertEquals(basket.getItemIPrice(1), price);
        Assert.assertEquals(basket.getItemITotalPrice(1), price);
        Assert.assertEquals(basket.getOrderTotalPrice(), price);
    }

    @Test
    public void multipleOneBookInBasketTest() {
        int num = 2; // увеличиваем количество наименования до num
        String price = new BrowseStoreMenuPage(driver).clickOnBooksItem().clickOnBookNInList(1)
                .addBookToBasket().getBookPrice();
        double itemTotalPrice = Double.parseDouble(price.substring(1)) * num;

        String itemStringTotalPrice = new HeaderPage(driver).clickViewBasket()
                .multipleItemInBasket(1, num).getItemITotalPrice(1);
        Assert.assertEquals(itemTotalPrice, Double.parseDouble(itemStringTotalPrice.substring(1)));
    }

    @Test
    public void emptyBasketTest() {
        new BrowseStoreMenuPage(driver).clickOnBooksItem().addBookNToBasket(1);
        new NavigateMenuPage(driver).goToHomePage().clickOnClothingItem().clickOnFirstClothingInList()
                .addClothingToBasket();
        BasketPage basket = new HeaderPage(driver).clickViewBasket().emptyBasket();
        Assert.assertEquals(basket.getAlertText(), "Your basket is now empty");
        Assert.assertTrue(basket.getMessageText().contains("Your basket is empty."));
        new NavigateMenuPage(driver).goToHomePage();
        Assert.assertTrue(new HeaderPage(driver).getBasketSum().contains("£0.00"));
    }

    @AfterClass
    public void postConditions() {
        new HeaderPage(driver).clickLogOut();
    }
}
