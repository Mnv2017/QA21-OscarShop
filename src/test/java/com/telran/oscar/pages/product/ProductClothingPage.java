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

    @FindBy(css = "div.row p.price_color")
    WebElement price;

    @FindBy(xpath = "//a[contains(.,'Django T-shirt')]")
    WebElement firstVariant;

    @FindBy(id = "add_to_basket_form")
    WebElement addToBasketBtn;

    public String getClothingName() {
        return name.getText();
    }

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

    public ProductClothingPage clickOnFirstVariant() {
        click(firstVariant);
        return this;
    }

    public ProductClothingPage addClothingToBasket() {
        click(firstVariant);
        click(addToBasketBtn);
        return this;
    }
}
