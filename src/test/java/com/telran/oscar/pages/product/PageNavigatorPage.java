package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageNavigatorPage extends PageBase {
    public PageNavigatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".next a") // a
    WebElement nextBtn;

    @FindBy(css = ".previous a")
    WebElement previousBtn;

    public boolean isPreviousBtnPresent() {
        return isElementPresent(By.cssSelector(".previous"));
    }

    public boolean isNextBtnPresent() {
        return isElementPresent(By.cssSelector(".next"));
    }

    public boolean isResultsStringPresent() {
        return isElementPresent(By.cssSelector(".form-horizontal"));
    }

    public boolean isCurrentPageStringPresent() {
        return isElementPresent(By.cssSelector(".current"));
    }

    public String getCurrentPageNum() {
        String str = driver.findElement(By.cssSelector(".current")).getText();
        String[] num = str.split(" ");
        return num[1];
    }

    public int getNumOfItemsInList() {
        return Integer.parseInt(driver.findElement(By.cssSelector(".form-horizontal strong")).getText());
    }

    public PageNavigatorPage clickOnNextBtn() {
        click(nextBtn);
        return this;
    }

    public PageNavigatorPage clickOnPreviousBtn() {
        click(previousBtn);
        return this;
    }

}
