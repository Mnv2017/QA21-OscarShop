package com.telran.oscar.pages.user;

import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProfilePage extends PageBase {
    public DeleteProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_password")
    WebElement submitPassword;

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement submitDelete;

    public HomePage deleteProfile(String password) {
        type(submitPassword, password);
        click(submitDelete);
        return new HomePage(driver);
    }
}
