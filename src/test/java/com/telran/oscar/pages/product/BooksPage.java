package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends PageBase {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='messages']//div[1]//div[@class='alertinner ']")
    WebElement alert1;

    @FindBy(xpath = "//div[@id='messages']//div[1]//div[@class='alertinner ']/strong")
    WebElement name;

    @FindBy(xpath = "//div[@id='messages']//div[@class='alertinner ']/p")
    WebElement alert3;

    @FindBy(xpath = "//div[@id='messages']//div[@class='alertinner ']/p/strong")
    WebElement priceInAlert;

    public boolean isBooksPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Books')]"));
    }

    public ProductBookPage clickOnBookNInList(int n) {
        driver.findElement(By.xpath("//ol[@class='row']//li[" + n + "]")).click();
        return new ProductBookPage(driver);
    }

    public String getBookNName(int n) {
        return driver.findElement(By.xpath("//ol[@class='row']//li[" + n + "]//h3//a"))
                .getAttribute("title");
    }

    public String getBookNPrice(int n) {
        return driver.findElement(By.xpath("//ol[@class='row']//li[" + n + "]//p[@class='price_color']"))
                .getText();
    }

    public BooksPage addBookNToBasket(int n) {
        click(driver.findElement(By.xpath("//ol[@class='row']//li[" + n + "]//button")));
        return this;
    }

    public String getAlert1Text() {
        return alert1.getText();
    }

    public String getProductNameFromAlert() {
        return name.getText();
    }

    public String getAlert3Text() {
        return alert3.getText();
    }

    public String getProductPriceFromAlert() {
        return priceInAlert.getText();
    }
}

