package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase {
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table//tr[2]//td[2]")
    WebElement numItems;

    public String getNumItem(){
        return numItems.getText();
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

    public OrderHistoryPage clickOrderNumber(){
        click(orderNumber);
        return this;
    }

    @FindBy(css = "p a")
    WebElement firstProductName;

    public String getFirstProductName(){
        return firstProductName.getText();
    }

    @FindBy(xpath = "//tr[1]/td[5]")
    WebElement firstLinePrice;

    public String getFirstLinePrice(){
        return firstLinePrice.getText();
    }

    @FindBy(xpath = "//tr[4]/td")
    WebElement orderTotal;

    public String getOrderTotal(){
        return orderTotal.getText();
    }

}
