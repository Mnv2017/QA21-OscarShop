package com.telran.oscar.pages.user;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginFormPresent() {
        return isElementPresent(By.id("login_form"));
    }

    @FindBy(id = "id_login-username")
    WebElement loginEmail;

    @FindBy(id = "id_login-password")
    WebElement loginPassword;

    @FindBy(css = "button[name=login_submit]")
    WebElement logInBtn;

    public LoginPage logIn(String email, String password) {
        type(loginEmail, email);
        type(loginPassword, password);
        click(logInBtn);
        return new LoginPage(driver);
    }

    public LoginPage logInUser(User user) {
        type(loginEmail, user.getEmail());
        type(loginPassword, user.getPassword());
        click(logInBtn);
        return new LoginPage(driver);
    }

    @FindBy(css = ".alert.alert-danger")
    WebElement wrongDataAlert;

    public boolean isErrorAlertPresent() {
        return wrongDataAlert.isDisplayed();
    }




    // #login_form .alert - локатор для 2х алертов при неправильном логине

}
