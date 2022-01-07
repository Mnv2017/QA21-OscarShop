package com.telran.oscar.pages.product;

import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
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

    public String getBookName() {
        return name.getText();
    }

    @FindBy(css = "p.price_color")
    WebElement price;

    public String getBookPrice() {
        return price.getText();
    }

    @FindBy(id = "add_to_basket_form")
    WebElement addToBasketBtn;

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
    @FindBy(css = ".product_pod h3 a")
    WebElement firstViewedBook;

    public String getNameFirstViewedBook(){
        return firstViewedBook.getAttribute("title");
    }

    @FindBy(xpath = "//div[@id='messages']//div[1]//div[@class='alertinner ']")
    WebElement alert1;

    public String getAlert1Text() {
        return alert1.getText();
    }

    @FindBy(xpath = "//div[@id='messages']//div[1]//div[@class='alertinner ']/strong")
    WebElement nameInAlert;

    public String getProductNameFromAlert() {
        return nameInAlert.getText();
    }

    @FindBy(xpath = "//div[@id='messages']//div[@class='alertinner ']/p")
    WebElement alert3;

    public String getAlert3Text() {
        return alert3.getText();
    }

    @FindBy(xpath = "//div[@id='messages']//div[@class='alertinner ']/p/strong")
    WebElement priceInAlert;

    public String getProductPriceFromAlert() {
        return priceInAlert.getText();
    }
}
