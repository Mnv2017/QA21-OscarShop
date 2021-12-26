package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBasketPagePresent(){
        return isElementPresent(By.xpath("//h1[contains(.,'Basket')]"));
    }

    // локаторы для книги с названием...
    @FindBy(xpath = "//a[contains(.,'Hacking Work')]/../../..//input[@type='number']")
    WebElement numBooksInBasket;

    @FindBy(xpath = "//a[contains(.,'Hacking Work')]/../../..//button[@type='submit']")
    WebElement submitNumBtn;

    public BasketPage deleteBookFromBasket() {
        type(numBooksInBasket, "0");
        click(submitNumBtn);
        return this;
    }

    public BasketPage addNBookToBasket(String num){
        type(numBooksInBasket, num);
        click(submitNumBtn);
        return this;
    }

    //    //a[contains(.,'The City and the Stars')]/../../..//input[@type='number']
    //    //a[contains(.,'The City and the Stars')]/../../..//button[@type='submit']
}
