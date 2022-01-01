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

    public ProductBookPage clickOnNProductInList(int n) {
        String bookN = "//ol[@class='row']//li[" + n + "]";
        driver.findElement(By.xpath(bookN)).click();
        return new ProductBookPage(driver);
    }
}
