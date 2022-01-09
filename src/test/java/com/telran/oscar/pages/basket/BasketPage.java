package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
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

    public String getItemIName(int i) {
        return driver.findElement(By.xpath("//*[@id='basket_formset']/div["
                + i + "]//h3/a")).getText();
    }

    public String getItemIPrice(int i) {
        return driver.findElement(By.xpath("//form[@id='basket_formset']/div["
                + i + "]//div[@class='col-sm-1']")).getText();
    }

    public String getItemITotalPrice(int i) {
        return driver.findElement(By.xpath("//form[@id='basket_formset']/div["
                + i + "]//div[@class='col-sm-2']/p")).getText();
    }

    @FindBy(id = "id_form-0-quantity")
    WebElement numBooks;

    @FindBy(css = ".input-group-btn button")
    WebElement submitBtn;

    public void deleteItemFromBasket() {
        type(numBooks, "0");
        click(submitBtn);
    }

    public BasketPage emptyBasket() {
        while (driver.findElements(By.cssSelector("div.basket-items")).size() > 0) {
            new BasketPage(driver).deleteItemFromBasket();
        }
        return this;
    }

    @FindBy(css = "#content_inner p")
    WebElement emptyMsg;

    public String getMessageText() {
        return emptyMsg.getText();
    }

    @FindBy(css = ".alertinner p")
    WebElement emptyAlert;

    public String getAlertText() {
        return emptyAlert.getText();
    }

    public String countBasketTotalPrice(int numItems) {
        if (numItems <= 0)
            return "£0.00";
        double sum = 0.0;
        for (int i = 1; i <= numItems; i++) {
            String s = "//*[@id='basket_formset']/div[" + i + "]//div[@class='col-sm-2']/p";
            String sItem = driver.findElement(By.xpath(s)).getText().substring(1);
            sum += Double.parseDouble(sItem);
        }
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

    public BasketPage multipleItemInBasket(int i, int num) {
        // i - номер строки корзины, num - количество продукта
        WebElement itemI = driver.findElement(By.cssSelector("#id_form-" + (i - 1) + "-quantity"));
        type(itemI, "" + num);
        WebElement itemISubmit = driver.findElement(By.xpath("//*[@id='basket_formset']/div[" + i + "]//button"));
        click(itemISubmit);
        return this;
    }

}
