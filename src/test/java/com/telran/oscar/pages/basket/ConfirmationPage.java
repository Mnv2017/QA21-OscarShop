package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends PageBase {
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(.,'Continue shopping')]")
    WebElement continueShopping;

    @FindBy(css = "h1")
    WebElement orderNum;

    public HeaderPage clickContinueShopping() {
        click(continueShopping);
        return new HeaderPage(driver);
    }

    public String getOrderNum() {
        String[] substr = orderNum.getText().split(":");
        return substr[0].substring(6);
    }
}
