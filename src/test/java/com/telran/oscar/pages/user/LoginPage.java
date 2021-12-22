package com.telran.oscar.pages.user;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="login_form")
    WebElement loginForm;

    public boolean loginFormIsPresent(){
        return loginForm.isDisplayed();
    }

    @FindBy(id = "id_login-username")
    WebElement loginEmail;

    @FindBy(id = "id_login-password")
    WebElement loginPassword;

    @FindBy(css = "button[name=login_submit]")
    WebElement logInBtn;

    public HomePage logIn(String email, String password) {
        type(loginEmail, email);
        type(loginPassword, password);
        click(logInBtn);
        return new HomePage(driver);
    }

    // #login_form .alert - локатор для 2х алертов при неправильном логине

}
