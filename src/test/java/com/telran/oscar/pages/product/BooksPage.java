package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import com.telran.oscar.pages.home.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends PageBase {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBooksPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Books')]"));
    }

    @FindBy(xpath = "//ol[@class='row']//li[2]")
    WebElement book2;

    public ProductBookPage clickOnNBookInList(int n) {
        String bookN = "//ol[@class='row']//li[" + n + "]";
        driver.findElement(By.xpath(bookN)).click();
        return new ProductBookPage(driver);
    }
}
