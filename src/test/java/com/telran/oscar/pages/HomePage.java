package com.telran.oscar.pages;

import com.telran.oscar.pages.product.BooksPage;
import com.telran.oscar.pages.product.ProductBookPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.pages.user.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "select[name=language]")
    WebElement languageList;

    @FindBy(css = "#language_selector button")
    WebElement goBtn;

    public HomePage setLanguage(String languge) {
        Select select = new Select(languageList);
        select.selectByVisibleText(languge);
        click(goBtn);
        return this;
    }

    @FindBy(id = "login_link")
    WebElement loginBtn;

    public LoginPage clickLoginOrRegisterBtn() {
        click(loginBtn);
        return new LoginPage(driver);
    }

    public RegisterPage clickRegisterBtn(){
        click(loginBtn);
        return new RegisterPage(driver);
    }

    @FindBy(css = "ul.navbar-right li:first-child")
    WebElement accountBtn;

    public ProfilePage clickAccountBtn() {
        click(accountBtn);
        return new ProfilePage(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logoutBtn;

    public HomePage logOut() {
        if (isElementPresent(By.id("logout_link"))) {
            click(logoutBtn);
        }
        return this;
    }

    @FindBy(css = ".col-sm-3 .thumbnail")
    WebElement recomReading;

    public ProductBookPage clickOnRecommendReading() {
        click(recomReading);
        return new ProductBookPage(driver);
    }

//    @FindBy(css = ".dropdown-menu li:nth-child(4)")
//    WebElement booksMenuItem;

    @FindBy(css = ".dropdown-submenu")
    WebElement booksMenuItem2;

    public BooksPage getBooksPage() {
        click(booksMenuItem2);
        return new BooksPage(driver);
    }

    @FindBy(css = ".alertinner.wicon")
    WebElement alertInner;

    public String getAlertText() {
        return alertInner.getText();
    }


    // сообщение, которое появляется при удалении аккаунта пользователя
    // //div[@class='alertinner wicon']
    // Your profile has now been deleted. Thanks for using the site.
}
