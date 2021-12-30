package com.telran.oscar.pages.basket;

import com.telran.oscar.data.ShippingAddress;
import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends PageBase {
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Shipping address')]")
    WebElement shippingAddress;

    public boolean isShippingPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(text(),'Shipping address')]"));
    }

    @FindBy(id = "id_title")
    WebElement titleSelect;

    @FindBy(id = "id_first_name")
    WebElement fName;

    @FindBy(id = "id_last_name")
    WebElement lName;

    @FindBy(id = "id_line1")
    WebElement line1;

    @FindBy(id = "id_line2")
    WebElement line2;

    @FindBy(id = "id_line3")
    WebElement line3;

    @FindBy(id = "id_line4")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "id_postcode")
    WebElement postcode;

    @FindBy(id = "id_country")
    WebElement countrySelect;

    @FindBy(id = "id_phone_number")
    WebElement phNumber;

    @FindBy(id = "id_notes")
    WebElement instr;

    @FindBy(css = "button")
    WebElement continueBtn;

    public PaymentPage fillShippingAddressForm() {
        typeSelect(titleSelect, ShippingAddress.TITLE);
        type(fName, ShippingAddress.F_NAME);
        type(lName, ShippingAddress.L_NAME);
        type(line1, ShippingAddress.AD_LINE1);
        type(line2, ShippingAddress.AD_LINE2);
        type(line3, ShippingAddress.AD_LINE3);
        type(city, ShippingAddress.CITY);
        type(state, ShippingAddress.STATE);
        type(postcode, ShippingAddress.POST_CODE);
        typeSelect(countrySelect, ShippingAddress.COUNTRY);
        type(phNumber, ShippingAddress.PH_NUMBER);
        type(instr, ShippingAddress.INSTRUCT);
        click(continueBtn);
        return new PaymentPage(driver);
    }

    // ToDo добавить проверку - есть кнопка или заполнять форму

    @FindBy(css = ".btn.btn-primary.btn-large.ship-address")
    WebElement shipToAddress;

    public PaymentPage clickShipToThisAddress(){
        click(shipToAddress);
        return new PaymentPage(driver);
    }

}
