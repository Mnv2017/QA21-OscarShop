package com.telran.oscar.tests.productTests;

import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.product.OffersPage;
import com.telran.oscar.pages.product.PageNavigatorPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OffersListTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HeaderPage(driver).clickOnLogo();
        new BrowseStoreMenuPage(driver).clickOnOffersItem();
    }

    @Test
    public void offersMenuItemTest() {
        OffersPage offersPage = new OffersPage(driver);
        Assert.assertTrue(offersPage.isOffersPagePresent());
        Assert.assertTrue(offersPage.isSectionNormalSiteOfferPresent());
        Assert.assertTrue(offersPage.isSectionDeferredBenefitOfferPresent());
        Assert.assertTrue(offersPage.isSectionShippingOfferPresent());
    }

    @Test
    public void normalSiteOfferTest() {
        OffersPage offersPage = new OffersPage(driver);
        Assert.assertTrue(offersPage.clickOnBrowseNormalOfferBtn().isNormalSiteOfferPresent());
        Assert.assertEquals(offersPage.getMsgWhatYouNeedToDo(), "Buy 3 more products from Site");

        PageNavigatorPage pageNavigatorPage = new PageNavigatorPage((driver));
        Assert.assertTrue(pageNavigatorPage.isCurrentPageStringPresent());
        Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "1");
        Assert.assertTrue(pageNavigatorPage.isNextBtnPresent());
        Assert.assertTrue(pageNavigatorPage.clickOnNextBtn().isPreviousBtnPresent());
        Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "2");
        Assert.assertEquals(pageNavigatorPage.clickOnPreviousBtn().getCurrentPageNum(), "1");
    }

    @Test
    public void deferredOfferTest() {
        OffersPage offersPage = new OffersPage(driver);
        Assert.assertTrue(offersPage.clickOnBrowseDeferredOfferBtn().isDeferredOfferPagePresent());
        Assert.assertEquals(offersPage.getMsgWhatYouNeedToDo(), "Buy 1 more product from Site");

        PageNavigatorPage pageNavigatorPage = new PageNavigatorPage((driver));
        Assert.assertTrue(pageNavigatorPage.isCurrentPageStringPresent());
        Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "1");
        Assert.assertTrue(pageNavigatorPage.isNextBtnPresent());
        Assert.assertTrue(pageNavigatorPage.clickOnNextBtn().isPreviousBtnPresent());
        Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "2");
        Assert.assertEquals(pageNavigatorPage.clickOnPreviousBtn().getCurrentPageNum(), "1");
    }

    @Test
    public void shippingOfferTest() {
        OffersPage offersPage = new OffersPage(driver);
        Assert.assertTrue(offersPage.clickOnBrowseShippingOfferBtn().isShippingOfferPagePresent());
        Assert.assertEquals(offersPage.getMsgWhatYouNeedToDo(), "Buy 1 more product from Site");

        PageNavigatorPage pageNavigatorPage = new PageNavigatorPage((driver));
        Assert.assertTrue(pageNavigatorPage.isCurrentPageStringPresent());
        Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "1");
        Assert.assertTrue(pageNavigatorPage.isNextBtnPresent());
        Assert.assertTrue(pageNavigatorPage.clickOnNextBtn().isPreviousBtnPresent());
        Assert.assertEquals(pageNavigatorPage.getCurrentPageNum(), "2");
        Assert.assertEquals(pageNavigatorPage.clickOnPreviousBtn().getCurrentPageNum(), "1");
    }

}
