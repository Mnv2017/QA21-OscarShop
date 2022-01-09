package com.telran.oscar.tests.productTests;

import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.product.BooksPage;
import com.telran.oscar.pages.product.NavigateMenuPage;
import com.telran.oscar.pages.product.PageNavigatorPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsListGuestTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickLogOut().clickOnLogo();
    }

    @Test
    public void allProductsMenuItemTest() {
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnAllProductsItem().isAllProductsPagePresent());
        PageNavigatorPage pageNavigatorPage = new PageNavigatorPage(driver);
        Assert.assertTrue(pageNavigatorPage.isResultsStringPresent());
        if (pageNavigatorPage.getNumOfItemsInList() > 20) {
            Assert.assertTrue(pageNavigatorPage.isCurrentPageStringPresent());
            Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "1");
            Assert.assertTrue(pageNavigatorPage.isNextBtnPresent());
            Assert.assertTrue(pageNavigatorPage.clickOnNextBtn().isPreviousBtnPresent());
            Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "2");
            Assert.assertEquals(pageNavigatorPage.clickOnPreviousBtn().getCurrentPageNum(), "1");
        }
    }

    @Test
    public void booksMenuItemTest() {
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnBooksItem().isBooksPagePresent());
        PageNavigatorPage pageNavigatorPage = new PageNavigatorPage(driver);
        Assert.assertTrue(pageNavigatorPage.isResultsStringPresent());
        if (pageNavigatorPage.getNumOfItemsInList() > 20) {
            Assert.assertTrue(pageNavigatorPage.isCurrentPageStringPresent());
            Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "1");
            Assert.assertTrue(pageNavigatorPage.isNextBtnPresent());
            Assert.assertTrue(pageNavigatorPage.clickOnNextBtn().isPreviousBtnPresent());
            Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "2");
            Assert.assertEquals(pageNavigatorPage.clickOnPreviousBtn().getCurrentPageNum(), "1");
        }
    }

    @Test
    public void clothingMenuItemTest() {
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnClothingItem().isClothingPagePresent());
        PageNavigatorPage pageNavigatorPage = new PageNavigatorPage(driver);
        Assert.assertTrue(pageNavigatorPage.isResultsStringPresent());
        if (pageNavigatorPage.getNumOfItemsInList() > 20) {
            Assert.assertTrue(pageNavigatorPage.isCurrentPageStringPresent());
            Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "1");
            Assert.assertTrue(pageNavigatorPage.isNextBtnPresent());
            Assert.assertTrue(pageNavigatorPage.clickOnNextBtn().isPreviousBtnPresent());
            Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "2");
            Assert.assertEquals(pageNavigatorPage.clickOnPreviousBtn().getCurrentPageNum(), "1");
        }
    }

    @Test
    public void productNavigateMenuTest() {
        new BrowseStoreMenuPage(driver).clickOnBooksItem();
        NavigateMenuPage navigateMenuPage = new NavigateMenuPage(driver);
        Assert.assertTrue(navigateMenuPage.goToClothingPage().isClothingPagePresent());
        Assert.assertTrue(navigateMenuPage.goToBooksPage().isBooksPagePresent());
        Assert.assertTrue(navigateMenuPage.goToFictionPage().isFictionPagePresent());
        Assert.assertTrue(navigateMenuPage.goToComputerPage().isComputerInLiteraturePagePresent());
        Assert.assertTrue(navigateMenuPage.goToNonFictionPage().isNonFictionPagePresent());
        Assert.assertTrue(navigateMenuPage.goToEssentialPage().isEssentialPagePresent());
        Assert.assertTrue(navigateMenuPage.goToHackingPage().isHackingPagePresent());
        navigateMenuPage.goToHomePage();
    }

    @Test
    public void addBookNFromListToBasket() {
        BooksPage booksPage = new BrowseStoreMenuPage(driver).clickOnBooksItem();
        String name = booksPage.getBookNName(1);
        String price = booksPage.getBookNPrice(1);
        booksPage.addBookNToBasket(1);

        Assert.assertTrue(booksPage.getAlert1Text().contains("has been added to your basket"));
        Assert.assertEquals(booksPage.getProductNameFromAlert(), name);
        Assert.assertTrue(booksPage.getAlert3Text().contains("Your basket total is now"));
        Assert.assertEquals(booksPage.getProductPriceFromAlert(), price);
        new HeaderPage(driver).deleteAllProductsFromBasket();
    }

}
