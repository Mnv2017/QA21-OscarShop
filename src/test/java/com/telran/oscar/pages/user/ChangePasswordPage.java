package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_old_password")
    WebElement oldPassword;

    @FindBy(id = "id_new_password1")
    WebElement newPassword1;

    @FindBy(id = "id_new_password2")
    WebElement newPassword2;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;

    @FindBy(css = "span.error-block")
    WebElement errMessage;

    public ProfilePage changePassword(String oldPass, String newPass, String confirm) {
        type(oldPassword, oldPass);
        type(newPassword1, newPass);
        type(newPassword2, confirm);
        click(saveBtn);
        return new ProfilePage(driver);
    }

    public boolean isErrorAlertPresent() {
        return isElementPresent(By.cssSelector(".alert.alert-danger"));
    }

    public String getErrMessageText() {
        return errMessage.getText();
    }
}
