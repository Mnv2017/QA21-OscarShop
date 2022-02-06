package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.product.BooksPage;
import com.telran.oscar.pages.product.ClothingPage;
import com.telran.oscar.pages.product.OffersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowseStoreMenuPage extends PageBase {
    public BrowseStoreMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(.,'All products')]")
    WebElement allProducts;

    @FindBy(xpath = "//a[contains(.,'Clothing')]")
    WebElement clothing;

    @FindBy(xpath = "//a[contains(.,'Books')]")
    WebElement books;

    @FindBy(xpath = "//a[contains(.,'Offers')]")
    WebElement offers;

    public AllProductsPage clickOnAllProductsItem() {
        click(allProducts);
        return new AllProductsPage(driver);
    }

    public ClothingPage clickOnClothingItem() {
        click(clothing);
        return new ClothingPage(driver);
    }

    public BooksPage clickOnBooksItem() {
        click(books);
        return new BooksPage(driver);
    }

    public OffersPage clickOnOffersItem() {
        click(offers);
        return new OffersPage(driver);
    }

}
