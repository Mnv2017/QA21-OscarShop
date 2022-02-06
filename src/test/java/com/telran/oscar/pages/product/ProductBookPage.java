package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductBookPage extends PageBase {

    public ProductBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    WebElement name;

    @FindBy(css = "p.price_color")
    WebElement price;

    @FindBy(id = "add_to_basket_form")
    WebElement addToBasketBtn;

    @FindBy(css = ".product_pod h3 a")
    WebElement firstViewedBook;

    @FindBy(xpath = "//div[@id='messages']//div[1]//div[@class='alertinner ']")
    WebElement alert1;

    @FindBy(xpath = "//div[@id='messages']//div[1]//div[@class='alertinner ']/strong")
    WebElement nameInAlert;

    @FindBy(xpath = "//div[@id='messages']//div[@class='alertinner ']/p")
    WebElement alert3;

    @FindBy(xpath = "//div[@id='messages']//div[@class='alertinner ']/p/strong")
    WebElement priceInAlert;

    public String getBookName() {
        return name.getText();
    }

    public String getBookPrice() {
        return price.getText();
    }

    public ProductBookPage addBookToBasket() {
        click(addToBasketBtn);
        return this;
    }

    public boolean isWishListMenuPresent() {
        return isElementPresent(By.cssSelector(".btn-group.btn-wishlist"));
    }

    public boolean isWriteReviewBtnPresent() {
        return isElementPresent(By.id("write_review"));
    }

    public boolean isProdDescriptionPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Product Description')]"));
    }

    public boolean isProdInformationPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Product Information')]"));

    }

    public boolean isCustomerReviewsPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Customer Reviews')]"));
    }

    public boolean isProductsRecentlyViewsPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Products you recently viewed')]"));
    }

    public String getNameFirstViewedBook() {
        return firstViewedBook.getAttribute("title");
    }

    public String getAlert1Text() {
        return alert1.getText();
    }

    public String getProductNameFromAlert() {
        return nameInAlert.getText();
    }

    public String getAlert3Text() {
        return alert3.getText();
    }

    public String getProductPriceFromAlert() {
        return priceInAlert.getText();
    }
}
