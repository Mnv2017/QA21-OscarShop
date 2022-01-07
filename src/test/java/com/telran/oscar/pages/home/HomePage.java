package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.product.ProductBookPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePagePresent() {
        return isElementPresent(By.xpath("//h2[text()='Welcome!']"));
    }

    @FindBy(css = ".well.well-blank h2")
    WebElement welcomeHeader;

    public String getSection1Header() {
        return welcomeHeader.getText();
    }

    @FindBy(css = ".well.promotion_single h2")
    WebElement recReadingHeader;

    public String getSection2Header() {
        return recReadingHeader.getText();
    }

    @FindBy(css = ".sub-header h3")
    WebElement otherGoodBooksHeader;

    public String getSection3Header() {
        return otherGoodBooksHeader.getText();
    }

    @FindBy(css = "#messages .alertinner.wicon")
    WebElement alertInner;

    public String getAlertText() {
        return alertInner.getText();
    }

}
