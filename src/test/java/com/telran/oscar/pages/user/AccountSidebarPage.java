package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSidebarPage extends PageBase {

    public AccountSidebarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Profile']")
    WebElement profile;

    @FindBy(xpath = "//a[text()='Order History']")
    WebElement orderHistory;

    @FindBy(xpath = "//a[text()='Address Book']")
    WebElement addressBook;

    public ProfilePage getProfilePage() {
        click(profile);
        return new ProfilePage(driver);
    }

    public OrderHistoryPage clickOrderHistoryItem() {
        click(orderHistory);
        return new OrderHistoryPage(driver);
    }

    public AddressPage clickAddressBookItem(){
        click(addressBook);
        return new AddressPage(driver);
    }
}
