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

public class HeaderPage extends PageBase {
    public HeaderPage(WebDriver driver) {
        super(driver);
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

    @FindBy(css = " a .icon-user")
    WebElement accountBtn;

    public ProfilePage clickAccountBtn() throws InterruptedException {
        Thread.sleep(1000);
        click(accountBtn);
        return new ProfilePage(driver);
    }

    @FindBy(css = "div.col-sm-7.h1>a")
    WebElement logo;

    public HomePage clickOnLogo() {
        click(logo);
        return new HomePage(driver);
    }

    @FindBy(css = "span.btn-group a.btn.btn-default")
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
            return new NavigateMenuPage(driver).goToHomePage();
        }
    }
}
