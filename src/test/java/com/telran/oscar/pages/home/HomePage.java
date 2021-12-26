package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
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

    public boolean isHomePagePresent(){
        return isElementPresent(By.xpath("//h2[text()='Welcome!']"));
    }

    @FindBy(css = ".col-sm-3 .thumbnail")
    WebElement recomReading;

    public ProductBookPage clickOnRecommendReading() {
        click(recomReading);
        return new ProductBookPage(driver);
    }

    @FindBy(css = ".dropdown-submenu")
    WebElement booksMenuItem2;

    public HeaderPage getBooksPage() {
        click(booksMenuItem2);
        return new HeaderPage(driver);
    }

    @FindBy(css = ".alertinner.wicon")
    WebElement alertInner;

    public String getAlertText() {
        return alertInner.getText();
    }


}
