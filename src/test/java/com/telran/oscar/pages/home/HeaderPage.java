package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.pages.user.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HeaderPage extends PageBase {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "select[name=language]")
    WebElement languageList;

    @FindBy(css = "#language_selector button")
    WebElement goBtn;

    public boolean isLanguageSelectElementsPresent() {
        return isElementPresent(By.cssSelector("select[name=language]"))
                && isElementPresent(By.cssSelector("#language_selector button"));
    }

    public HeaderPage setLanguage(String languge) {
        Select select = new Select(languageList);
        select.selectByVisibleText(languge);
        click(goBtn);
        return this;
    }

    @FindBy(id = "login_link")
    WebElement loginBtn;

    public LoginPage clickLoginBtn() {
        click(loginBtn);
        return new LoginPage(driver);
    }

    public RegisterPage clickRegisterBtn() {
        click(loginBtn);
        return new RegisterPage(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logoutBtn;

    public boolean isLogOutBtnPresent() {
        return isElementPresent(By.id("logout_link"));
    }

    public HeaderPage clickLogOut() {
        if (isLogOutBtnPresent()) {
            click(logoutBtn);
        }
        return this;
    }

    @FindBy(xpath = "//a[contains(.,'Account')]")
    WebElement accountBtn;

    public ProfilePage clickAccountBtn() {
        click(accountBtn);
        return new ProfilePage(driver);
    }

    public boolean isAccountBtnPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'Account')]"));
    }

    @FindBy(xpath = "//a[text()='Oscar']")
    WebElement logo;

    public HomePage clickOnLogo() {
        click(logo);
        return new HomePage(driver);
    }

    @FindBy(css = "span.btn-group")
    WebElement viewBasket;

    public BasketPage clickViewBasket() {
        click(viewBasket);
        return new BasketPage(driver);
    }

    @FindBy(id = "id_q")
    WebElement search;

    @FindBy(css = "input[value=Search]")
    WebElement searchBtn;

    public SearchPage searchProductByName(String name) {
        type(search, name);
        click(searchBtn);
        return new SearchPage(driver);
    }
}
