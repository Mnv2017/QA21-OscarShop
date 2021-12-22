package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isItProfilePage() {
        return isElementPresent(By.xpath("//h1[text()='Profile']"));
    }

    @FindBy(xpath = "//tbody/tr[2]/td")
    WebElement accountEmail;

    public String getAccountEmail() {
        return accountEmail.getText();
    }

    @FindBy(xpath = "//tbody/tr[1]/td")
    WebElement accountName;

    public String getAccountName() {
        return accountName.getText();
    }

    @FindBy(xpath = "//a[contains(.,'Change password')]")
    WebElement changePasswordBtn;

    public ChangePasswordPage clickChangePasswordBtn() {
        click(changePasswordBtn);
        return new ChangePasswordPage(driver);
    }

    @FindBy(xpath = "//a[contains(.,'Edit profile')]")
    WebElement editProfileBtn;

    public EditProfilePage clickEditProfileBtn() {
        click(editProfileBtn);
        return new EditProfilePage(driver);
    }

    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    public DeleteProfilePage clickDeleteProfileBtn() {
        click(deleteProfileBtn);
        return new DeleteProfilePage(driver);
    }

    @FindBy(css = ".alertinner.wicon")
    WebElement alertInner;

    public String getAlertText() {
        return alertInner.getText();
    }

    // локатор сообщения при неправильном пароле
    // //div[@class='alert alert-danger']
}
