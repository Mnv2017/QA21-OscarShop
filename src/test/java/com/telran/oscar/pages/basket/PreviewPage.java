package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewPage extends PageBase {
    public PreviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "place-order")
    WebElement placeOrderBtn;

    public ConfirmationPage clickPlaceOrderBtn() {
        click(placeOrderBtn);
        return new ConfirmationPage(driver);
    }
}
