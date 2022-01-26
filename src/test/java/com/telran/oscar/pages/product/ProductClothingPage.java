package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductClothingPage extends PageBase {
    public ProductClothingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    WebElement name;

    public String getClothingName() {
        return name.getText();
    }

    @FindBy(css = "div.row p.price_color")
    WebElement price;

    public String getClothingPrice() {
        return price.getText();
    }

    public boolean isWishListMenuPresent() {
        return isElementPresent(By.cssSelector(".btn-group.btn-wishlist"));
    }

    public boolean isWriteReviewBtnPresent() {
        return isElementPresent(By.id("write_review"));
    }

    public boolean isProdInformationPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Product Information')]"));
    }

    public boolean isCustomerReviewsPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Customer Reviews')]"));
    }

    @FindBy(xpath = "//a[contains(.,'Django T-shirt')]")
    WebElement firstVariant;

    public ProductClothingPage clickOnFirstVariant() {
        click(firstVariant);
        return this;
    }

    @FindBy(id = "add_to_basket_form")
    WebElement addToBasketBtn;

    public ProductClothingPage addClothingToBasket() {
        click(firstVariant);
        click(addToBasketBtn);
        return this;
    }
}
