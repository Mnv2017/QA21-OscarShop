package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OffersPage extends PageBase {
    public OffersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOffersPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Offers')]"));
    }

    public boolean isSectionNormalSiteOfferPresent() {
        return isElementPresent(By.xpath("//h2[text()='Normal site offer']"));
    }

    public boolean isSectionDeferredBenefitOfferPresent() {
        return isElementPresent(By.xpath("//h2[text()='Deferred benefit offer']"));
    }

    public boolean isSectionShippingOfferPresent() {
        return isElementPresent(By.xpath("//h2[text()='Shipping offer']"));
    }

    @FindBy(xpath = "//div[@id='content_inner']/p[2]/a")
    WebElement browseNormalOfferBtn;

    public OffersPage clickOnBrowseNormalOfferBtn() {
        click(browseNormalOfferBtn);
        return this;
    }

    public boolean isNormalSiteOfferPresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Normal site offer')]"));
    }

    @FindBy(xpath = "//div[@id='content_inner']/p[4]/a")
    WebElement browseDeferredOfferBtn;

    public OffersPage clickOnBrowseDeferredOfferBtn() {
        click(browseDeferredOfferBtn);
        return this;
    }

    public boolean isDeferredOfferPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Deferred benefit offer')]"));
    }

    @FindBy(xpath = "//div[@id='content_inner']/p[6]/a")
    WebElement browseShippingOfferBtn;

    public OffersPage clickOnBrowseShippingOfferBtn() {
        click(browseShippingOfferBtn);
        return this;
    }

    public boolean isShippingOfferPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Shipping offer')]"));
    }

    @FindBy(css = ".well p")
    WebElement whatYouNeedToDo;

    public String getMsgWhatYouNeedToDo() {
        return whatYouNeedToDo.getText();
    }

    @FindBy(xpath = "//div[@class='alertinner ']")
    WebElement alert;

    public String getAlertText() {
        return alert.getText();
    }

}
