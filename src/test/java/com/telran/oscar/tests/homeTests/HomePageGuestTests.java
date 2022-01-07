package com.telran.oscar.tests.homeTests;

import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.home.SearchPage;
import com.telran.oscar.pages.product.NavigateMenuPage;
import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.pages.user.RegisterPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageGuestTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions(){
        new HeaderPage(driver).clickLogOut().clickOnLogo();
    }

    @Test
    public void homePageHeadersTest(){
        Assert.assertEquals(new HomePage(driver).getSection1Header(),"Welcome!");
        Assert.assertEquals(new HomePage(driver).getSection2Header(),"Recommended reading");
        Assert.assertEquals(new HomePage(driver).getSection3Header(),"Other good books");
    }

    @Test
    public void comeBackToHomepageWithLogoTest() {
        new HeaderPage(driver).clickViewBasket();
        Assert.assertTrue(new HeaderPage(driver).clickOnLogo().isHomePagePresent());
        new HeaderPage(driver).searchProductByName("Robot");
        Assert.assertTrue(new HeaderPage(driver).clickOnLogo().isHomePagePresent());
        new BrowseStoreMenuPage(driver).clickOnAllProductsItem();
        Assert.assertTrue(new HeaderPage(driver).clickOnLogo().isHomePagePresent());
    }

    @Test
    public void loginOrRegisterLinkTest(){
        new HeaderPage(driver).clickRegisterBtn();
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormPresent());
        Assert.assertTrue(new LoginPage(driver).isLoginFormPresent());
    }

    @Test
    public void searchFunktionTest(){
        new HeaderPage(driver).searchProductByName("Robot");
        Assert.assertTrue(new SearchPage(driver).isSearchResultPresent("Robot"));
    }

    @Test
    public void viewBasketTest(){
        new HeaderPage(driver).clickViewBasket();
        Assert.assertTrue(new BasketPage(driver).isBasketPagePresent());
    }

    @Test
    public void browseStoreMenuTest(){
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnAllProductsItem().isAllProductsPagePresent());
        new NavigateMenuPage(driver).goToHomePage();
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnBooksItem().isBooksPagePresent());
        new NavigateMenuPage(driver).goToHomePage();
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnClothingItem().isClothingPagePresent());
        new NavigateMenuPage(driver).goToHomePage();
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnOffersItem().isOffersPagePresent());
    }
}
