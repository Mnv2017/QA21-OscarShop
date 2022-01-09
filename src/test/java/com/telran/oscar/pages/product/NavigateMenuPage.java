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

    public BrowseStoreMenuPage goToHomePage() throws InterruptedException {
        Thread.sleep(2000);
        click(home);
        return new BrowseStoreMenuPage(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Clothing')]")
    WebElement clothing;

    public ClothingPage goToClothingPage() {
        click(clothing);
        return new ClothingPage(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Books')]")
    WebElement books;

    public BooksPage goToBooksPage() {
        click(books);
        return new BooksPage(driver);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Offers']")
    WebElement offers;

    public OffersPage goToOffersPage() {
        click(offers);
        return new OffersPage(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Fiction')]")
    WebElement fiction;

    public FictionPage goToFictionPage() {
        click(fiction);
        return new FictionPage(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Non-Fiction')]")
    WebElement nonFiction;

    public NonFictionPage goToNonFictionPage() {
        click(nonFiction);
        return new NonFictionPage(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Computers in Literature')]")
    WebElement computer;

    public FictionPage goToComputerPage() {
        click(computer);
        return new FictionPage(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Essential programming')]")
    WebElement essential;

    public NonFictionPage goToEssentialPage() {
        click(essential);
        return new NonFictionPage(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-list']//a[contains(.,'Hacking')]")
    WebElement hacking;

    public NonFictionPage goToHackingPage() {
        click(hacking);
        return new NonFictionPage(driver);
    }
}
