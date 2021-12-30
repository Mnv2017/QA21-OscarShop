package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase {
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table//tr[2]//td[3]")
    WebElement lastOrderSum;

    public String getLastOrderSum() {
        return lastOrderSum.getText();
    }

    @FindBy(xpath = "//table//tr[2]//a")
    WebElement orderNumber;

    public String getLastOrderNumber(){
        return orderNumber.getText();
    }
}
