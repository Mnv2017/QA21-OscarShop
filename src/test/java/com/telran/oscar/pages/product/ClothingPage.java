package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothingPage extends PageBase {
    public ClothingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isClothingPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Clothing')]"));
    }

    @FindBy(css = ".breadcrumb a")
    WebElement home;

    public BrowseStoreMenuPage returnToHomePage() {
        click(home);
        return new BrowseStoreMenuPage(driver);
    }
}
