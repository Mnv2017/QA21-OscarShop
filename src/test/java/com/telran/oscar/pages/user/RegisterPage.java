package com.telran.oscar.pages.user;

import com.telran.oscar.data.User;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "register_form")
    WebElement registerForm;

    public boolean isRegisterFormPresent() {
        return registerForm.isDisplayed();
    }

    @FindBy(id = "id_registration-email")
    WebElement registerEmail;

    @FindBy(id = "id_registration-password1")
    WebElement registerPassword;

    @FindBy(id = "id_registration-password2")
    WebElement confirmPassword;

    @FindBy(css = "button[name=registration_submit]")
    WebElement registerBtn;

    public HomePage createNewAccount(String email, String password) {
        type(registerEmail, email);
        type(registerPassword, password);
        type(confirmPassword, password);
        click(registerBtn);
        return new HomePage(driver);
    }

    public HomePage createNewAccountUser(User user) {
        type(registerEmail, user.getEmail());
        type(registerPassword, user.getPassword());
        type(confirmPassword, user.getPassword());
        click(registerBtn);
        return new HomePage(driver);
    }

    @FindBy(css = "span.error-block")
    WebElement errorMsg;

    public boolean isEmailAlreadyExistMsgPresent() {
        return errorMsg.getText().equals("A user with that email address already exists");
    }

    //  //span[contains(.,'A user with that email address already exists')]
}
