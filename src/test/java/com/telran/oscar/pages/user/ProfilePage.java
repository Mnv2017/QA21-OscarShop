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

    public boolean isProfilePagePresent() {
        return isElementPresent(By.xpath("//h1[text()='Profile']"));
    }

    @FindBy(xpath = "//tbody/tr[2]/td")
    WebElement accountEmail;

    @FindBy(xpath = "//tbody/tr[1]/td")
    WebElement accountName;

    @FindBy(xpath = "//a[contains(.,'Change password')]")
    WebElement changePasswordBtn;

    @FindBy(xpath = "//a[contains(.,'Edit profile')]")
    WebElement editProfileBtn;

    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    @FindBy(css = ".alertinner.wicon")
    WebElement alertInner;

    public String getAccountEmail() {
        return accountEmail.getText();
    }

    public String getAccountName() {
        return accountName.getText();
    }

    public ChangePasswordPage clickChangePasswordBtn() {
        click(changePasswordBtn);
        return new ChangePasswordPage(driver);
    }

    public EditProfilePage clickEditProfileBtn() {
        click(editProfileBtn);
        return new EditProfilePage(driver);
    }

    public DeleteProfilePage clickDeleteProfileBtn() {
        click(deleteProfileBtn);
        return new DeleteProfilePage(driver);
    }

    public String getAlertText() {
        return alertInner.getText();
    }

}
