package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends PageBase {
    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllProductsPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'All products')]"));
    }

    @FindBy(css = ".breadcrumb a")
    WebElement home;

    public BrowseStoreMenuPage returnToHomePage() {
        click(home);
        return new BrowseStoreMenuPage(driver);
    }

    @FindBy(css = ".product_pod a")
    WebElement firstBookInList;

    public ProductBookPage clickOnFirstBookInList(){
        click(firstBookInList);
        return new ProductBookPage(driver);
    }
}
