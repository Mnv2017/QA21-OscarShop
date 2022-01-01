package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigateMenuPage extends PageBase {
    public NavigateMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".breadcrumb a")
    WebElement home;

    public BrowseStoreMenuPage returnToHomePage() {
        click(home);
        return new BrowseStoreMenuPage(driver);
    }
}
