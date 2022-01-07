package com.telran.oscar.tests.productTests;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.product.*;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductsViewCardUserTests extends TestBase {

    @BeforeClass
    public void classPreconditions() {
        new HeaderPage(driver).clickLogOut().clickLoginBtn().logInUser(new User()
                .setEmail(User.LOG_EMAIL).setPassword(User.LOG_PASSWORD));
    }

    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickOnLogo();
    }

    @Test
    public void verifyAvailBookViewCardTest() {
        BooksPage booksPage = new BrowseStoreMenuPage(driver).clickOnBooksItem();
        String nameInList = booksPage.getBookNName(4);
        String priceInList = booksPage.getBookNPrice(4);
        ProductBookPage productBookPage = new BooksPage(driver).clickOnBookNInList(4);

        Assert.assertEquals(productBookPage.getBookName(), nameInList);
        Assert.assertEquals(productBookPage.getBookPrice(), priceInList);
        Assert.assertTrue(productBookPage.isProdDescriptionPresent());
        Assert.assertTrue(productBookPage.isProdInformationPresent());
        Assert.assertTrue(productBookPage.isCustomerReviewsPresent());
        Assert.assertTrue(productBookPage.isWriteReviewBtnPresent());
        Assert.assertTrue(productBookPage.isWishListMenuPresent());
    }

    @Test
    public void verifyAvailClothingViewCardTest() {
        ClothingPage clothingPage = new BrowseStoreMenuPage(driver).clickOnClothingItem();
        String nameInList = clothingPage.getFirstClothingInListName();
        String priceInList = clothingPage.getFirstClothingInListPrice();
        ProductClothingPage productClothingPage = new ClothingPage(driver).clickOnFirstClothingInList()
                .clickOnFirstVariant();
        Assert.assertEquals(productClothingPage.getClothingName(), nameInList);
        Assert.assertEquals(productClothingPage.getClothingPrice(), priceInList);
        Assert.assertTrue(productClothingPage.isProdInformationPresent());
        Assert.assertTrue(productClothingPage.isCustomerReviewsPresent());
        Assert.assertTrue(productClothingPage.isWriteReviewBtnPresent());
        Assert.assertTrue(productClothingPage.isWishListMenuPresent());
    }

    @Test
    public void sectionProductsYouRecentlyViewedTest() {
        driver.manage().deleteCookieNamed("oscar_history");
        String firstViewedBookName = new BrowseStoreMenuPage(driver).clickOnBooksItem()
                .getBookNName(1);
        Assert.assertFalse(new BooksPage(driver).clickOnBookNInList(1).isProductsRecentlyViewsPresent());

        String recentlyViewedBookName = new NavigateMenuPage(driver).goToHomePage()
                .clickOnAllProductsItem().clickOnNProductInList(2)
                .getNameFirstViewedBook();
        Assert.assertTrue(new ProductBookPage(driver).isProductsRecentlyViewsPresent());
        Assert.assertEquals(recentlyViewedBookName, firstViewedBookName);
    }

    @Test
    public void addBookFromCardToBasketTest() {
        new HeaderPage(driver).deleteAllProductsFromBasket();
        ProductBookPage productBookPage = new BrowseStoreMenuPage(driver).clickOnBooksItem().clickOnBookNInList(4);
        String name = productBookPage.getBookName();
        String price = productBookPage.getBookPrice();
        productBookPage.addBookToBasket();

        Assert.assertTrue(productBookPage.getAlert1Text().contains("has been added to your basket"));
        Assert.assertEquals(productBookPage.getProductNameFromAlert(), name);
        Assert.assertTrue(productBookPage.getAlert3Text().contains("Your basket total is now"));
        Assert.assertEquals(productBookPage.getProductPriceFromAlert(), price);
        new HeaderPage(driver).deleteAllProductsFromBasket();
    }

    @AfterClass
    public void postCondition() {
        new HeaderPage(driver).clickLogOut();
    }

}
