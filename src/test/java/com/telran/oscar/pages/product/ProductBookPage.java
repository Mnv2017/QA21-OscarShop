package com.telran.oscar.pages.product;

import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductBookPage extends PageBase {

    public ProductBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-header.action")
    WebElement pageTitle;

    // ToDo переписать isItProductPage проверять заголовок
    public boolean isItProductPage() {
        return pageTitle.isDisplayed();
    }

    @FindBy(css = "h1")
    WebElement name;

    public String getBookName() {
        return name.getText();
    }

    @FindBy(css = "div.row p.price_color")
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

    @FindBy(xpath = "//div[@id='messages']//a[text()='View basket']")
    WebElement viewBasketBtn;

    public BasketPage viewBasket() {
        click(viewBasketBtn);
        return new BasketPage(driver);
    }

}
