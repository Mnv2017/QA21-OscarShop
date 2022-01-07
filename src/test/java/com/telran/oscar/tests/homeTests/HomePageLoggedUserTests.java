package com.telran.oscar.tests.homeTests;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.home.SearchPage;
import com.telran.oscar.pages.product.NavigateMenuPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageLoggedUserTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions() {
        new HeaderPage(driver).clickLoginBtn().logInUser(new User()
                .setEmail(User.LOG_EMAIL).setPassword(User.LOG_PASSWORD));
    }

    @Test(priority = 1)
    public void comeBackToHomepageWithLogoTest() {
        new HeaderPage(driver).clickAccountBtn();
        Assert.assertTrue(new HeaderPage(driver).clickOnLogo().isHomePagePresent());
        new HeaderPage(driver).clickViewBasket();
        Assert.assertTrue(new HeaderPage(driver).clickOnLogo().isHomePagePresent());
        new HeaderPage(driver).searchProductByName("Robot");
        Assert.assertTrue(new HeaderPage(driver).clickOnLogo().isHomePagePresent());
        new BrowseStoreMenuPage(driver).clickOnAllProductsItem();
        Assert.assertTrue(new HeaderPage(driver).clickOnLogo().isHomePagePresent());
    }

    @Test(priority = 2)
    public void browseStoreMenuTest(){
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnAllProductsItem().isAllProductsPagePresent());
        new NavigateMenuPage(driver).goToHomePage();
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnBooksItem().isBooksPagePresent());
        new NavigateMenuPage(driver).goToHomePage();
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnClothingItem().isClothingPagePresent());
        new NavigateMenuPage(driver).goToHomePage();
        Assert.assertTrue(new BrowseStoreMenuPage(driver).clickOnOffersItem().isOffersPagePresent());
    }

    @Test(priority = 3)
    public void searchFunctionTest() {
        new HeaderPage(driver).searchProductByName("Robot");
        Assert.assertTrue(new SearchPage(driver).isSearchResultPresent("Robot"));
    }

    @Test(priority = 4)
    public void viewBasketTest() {
        new HeaderPage(driver).clickViewBasket();
        Assert.assertTrue(new BasketPage(driver).isBasketPagePresent());
    }

    @Test(priority = 5)
    public void accountLinkTest() {
        Assert.assertTrue(new HeaderPage(driver).isAccountBtnPresent());
        new HeaderPage(driver).clickAccountBtn();
        Assert.assertTrue(new ProfilePage(driver).isProfilePagePresent());
    }

    @Test(priority = 6)
    public void logOutLinkTest() {
        Assert.assertTrue(new HeaderPage(driver).isLogOutBtnPresent());
        new HeaderPage(driver).clickLogOut();
        Assert.assertTrue(new HomePage(driver).isHomePagePresent());
    }


}
