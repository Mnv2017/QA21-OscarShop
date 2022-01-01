package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.product.NavigateMenuPage;
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

    public HeaderPage setLanguage(String language) {
        typeSelect(languageList, language);
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

    public boolean isAccountBtnPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'Account')]"));
    }

    // ToDo переделать isElementPresent?

    @FindBy(xpath = "//a[contains(.,'Account')]")
    WebElement accountBtn;

    public ProfilePage clickAccountBtn() {
        click(accountBtn);
        return new ProfilePage(driver);
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

    @FindBy(css = ".basket-mini.pull-right.hidden-xs")
    WebElement basketSum;

    public String getBasketSum() {
        return basketSum.getText();
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

    public BrowseStoreMenuPage deleteAllProductsFromBasket() {
        if (new HeaderPage(driver).getBasketSum().contains("£0.00")) {
            return new BrowseStoreMenuPage(driver);
        } else {
            new HeaderPage(driver).clickViewBasket().emptyBasket();
            return new NavigateMenuPage(driver).returnToHomePage();
        }
    }
}
