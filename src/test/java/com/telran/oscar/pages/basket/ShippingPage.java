package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.user.AddressPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends PageBase {
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShipToAddressBtnPresent() {
        return isElementPresent(By.cssSelector(".btn.btn-primary.btn-large.ship-address"));
    }

    @FindBy(css = ".btn.btn-primary.btn-large.ship-address")
    WebElement shipToAddress;

    public PaymentPage clickShipToThisAddress() {
        click(shipToAddress);
        return new PaymentPage(driver);
    }

    public PaymentPage specifyShippingAddress() {
        if (isShipToAddressBtnPresent()) {
            return clickShipToThisAddress();
        } else {
            new AddressPage(driver).fillShippingAddressForm();
            return new ShippingPage(driver).clickContinueBtn();
        }

    }

    @FindBy(css = "button")
    WebElement continueBtn;

    public PaymentPage clickContinueBtn() {
        click(continueBtn);
        return new PaymentPage(driver);
    }

}
