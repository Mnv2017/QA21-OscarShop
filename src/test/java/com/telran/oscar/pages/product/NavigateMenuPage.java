package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigateMenuPage extends PageBase {
    public NavigateMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".breadcrumb a")
    WebElement home;

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Clothing')]")
    WebElement clothing;

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Books')]")
    WebElement books;

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Offers']")
    WebElement offers;

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Fiction')]")
    WebElement fiction;

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Non-Fiction')]")
    WebElement nonFiction;

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Computers in Literature')]")
    WebElement computer;

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Essential programming')]")
    WebElement essential;

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Hacking')]")
    WebElement hacking;

    public BrowseStoreMenuPage goToHomePage() throws InterruptedException {
        Thread.sleep(2000);
        click(home);
        return new BrowseStoreMenuPage(driver);
    }

    public ClothingPage goToClothingPage() {
        click(clothing);
        return new ClothingPage(driver);
    }

    public BooksPage goToBooksPage() {
        click(books);
        return new BooksPage(driver);
    }

    public OffersPage goToOffersPage() {
        click(offers);
        return new OffersPage(driver);
    }

    public FictionPage goToFictionPage() {
        click(fiction);
        return new FictionPage(driver);
    }

    public NonFictionPage goToNonFictionPage() {
        click(nonFiction);
        return new NonFictionPage(driver);
    }

    public FictionPage goToComputerPage() {
        click(computer);
        return new FictionPage(driver);
    }

    public NonFictionPage goToEssentialPage() {
        click(essential);
        return new NonFictionPage(driver);
    }

    public NonFictionPage goToHackingPage() {
        click(hacking);
        return new NonFictionPage(driver);
    }
}
