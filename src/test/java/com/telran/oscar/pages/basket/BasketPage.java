package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBasketPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Basket')]"));
    }

    @FindBy(css = ".breadcrumb a")
    WebElement home;

    public BrowseStoreMenuPage returnToHomePage() {
        click(home);
        return new BrowseStoreMenuPage(driver);
    }

    @FindBy(id = "id_form-0-quantity")
    WebElement numBooks;

    @FindBy(css = ".input-group-btn button")
    WebElement submitBtn;

    public BasketPage deleteBookFromBasket() {
        type(numBooks, "0");
        click(submitBtn);
        return this;
    }

    public BasketPage emptyBasket() {
        while (driver.findElements(By.cssSelector(".basket-items")).size() > 0) {
            new BasketPage(driver).deleteBookFromBasket();
        }
        return this;
    }

    // //*[@id='basket_formset']/div[1]//div[@class='col-sm-2']/p

    public String countBasketTotalPrice(int numItems) {
        if (numItems <= 0)
            return "£0.00";
        double sum = 0.0;
        for (int i = 1; i <= numItems; i++) {
            String s = "//*[@id='basket_formset']/div[" + i + "]//div[@class='col-sm-2']/p";
            String sItem = driver.findElement(By.xpath(s)).getText().substring(1);
            System.out.println("******  Сумма " + i + "-го элемента: " + sItem);
            // ToDo закомментить вывод сумм
            sum += Double.parseDouble(sItem);
        }
        System.out.println("****** Общая сумма: " + sum);
        return "£" + Precision.round(sum, 2);
    }

    @FindBy(css = "h3.price_color")
    WebElement orderTotal;

    public String getOrderTotalPrice() {
        return orderTotal.getText();
    }

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    WebElement toCheckout;

    public ShippingPage clickProceedToCheckout() {
        click(toCheckout);
        return new ShippingPage(driver);
    }


    // локаторы для книги с названием...
    @FindBy(xpath = "//a[contains(.,'Hacking Work')]/../../..//input[@type='number']")
    WebElement numBooksInBasket;

    @FindBy(xpath = "//a[contains(.,'Hacking Work')]/../../..//button[@type='submit']")
    WebElement submitNumBtn;


    // увеличиваем количество книг в корзине
    public BasketPage addNBookToBasket(String num) {
        type(numBooksInBasket, num);
        click(submitNumBtn);
        return this;
    }


    //    //a[contains(.,'The City and the Stars')]/../../..//input[@type='number']
    //    //a[contains(.,'The City and the Stars')]/../../..//button[@type='submit']
}
