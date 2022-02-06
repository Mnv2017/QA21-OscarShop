package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.product.ProductBookPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ProductBookPage clickOnSelectedBook(String name) {
        WebElement selectedBook = driver.findElement(By.cssSelector("a[title='" + name + "']"));
        click(selectedBook);
        return new ProductBookPage(driver);
    }

    public boolean isSearchResultPresent(String text) {
        return isElementPresent(By.xpath("//h1[contains(.,'" + text + "')]"));
    }

}
