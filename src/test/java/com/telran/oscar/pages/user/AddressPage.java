package com.telran.oscar.pages.user;

import com.telran.oscar.data.Address;
import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends PageBase {

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.btn.btn-primary")
    WebElement addNewAdressBtn;

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

    @FindBy(css = "button.btn.btn-lg.btn-primary")
    WebElement saveBtn;

    @FindBy(css = "address")
    WebElement address;

    @FindBy(xpath = "//a[contains(.,'Edit')]")
    WebElement editBtn;

    @FindBy(css = "div.alertinner.wicon")
    WebElement updateAlert;

    public AddressPage clickAddNewAddressBtn() {
        click(addNewAdressBtn);
        return this;
    }

    public AddressPage fillShippingAddressForm() {
        typeSelect(titleSelect, Address.TITLE);
        type(fName, Address.F_NAME);
        type(lName, Address.L_NAME);
        type(line1, Address.AD_LINE1);
        type(line2, Address.AD_LINE2);
        type(line3, Address.AD_LINE3);
        type(city, Address.CITY);
        type(state, Address.STATE);
        type(postcode, Address.POST_CODE);
        typeSelect(countrySelect, Address.COUNTRY);
        type(phNumber, Address.PH_NUMBER);
        type(instr, Address.INSTRUCT);
        return this;
    }

    public AddressPage clickSaveAddressBtn() {
        click(saveBtn);
        return this;
    }

    public String getAddress() {
        return address.getText();
    }

    public AddressPage clickEditBtn() {
        click(editBtn);
        return this;
    }

    public AddressPage editFirstLineAddress(String edit) {
        type(line1, edit);
        return this;
    }

    public String getUpdateAlert() {
        return updateAlert.getText();
    }
}
