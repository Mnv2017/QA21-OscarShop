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

    public ProfilePage getProfilePage() {
        click(profile);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//a[text()='Order History']")
    WebElement orderHistory;

    public OrderHistoryPage clickOrderHistoryItem() {
        click(orderHistory);
        return new OrderHistoryPage(driver);
    }

    @FindBy(xpath = "//a[text()='Address Book']")
    WebElement addressBook;

    public AddressPage clickAddressBookItem(){
        click(addressBook);
        return new AddressPage(driver);
    }
}
