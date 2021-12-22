package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends PageBase {
    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    @FindBy(id = "id_last_name")
    WebElement lastNameField;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;

    public ProfilePage editProfile(String fName, String lName){
        type(firstNameField, fName);
        type(lastNameField, lName);
        click(saveBtn);
        return new ProfilePage(driver);
    }

}
