package com.telran.oscar.pages.product;

import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductBookPage extends PageBase {

    public ProductBookPage(WebDriver driver) {
        super(driver);
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

    @FindBy(css=".page-header.action")
    WebElement pageTitle;

    public boolean isItProductPage(){
        return pageTitle.isDisplayed();
    }

}
