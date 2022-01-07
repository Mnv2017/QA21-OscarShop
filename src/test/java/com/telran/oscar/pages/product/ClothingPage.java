package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.BrowseStoreMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.annotation.meta.Exclusive;

public class ClothingPage extends PageBase {
    public ClothingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isClothingPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Clothing')]"));
    }

    @FindBy(xpath = "//ol[@class='row']//li[1]//h3/a")
    WebElement firstClothing;

    public ProductClothingPage clickOnFirstClothingInList() {
        click(firstClothing);
        return new ProductClothingPage(driver);
    }

    public String getFirstClothingInListName() {
        return firstClothing.getAttribute("title");
    }

    @FindBy(xpath = "//ol[@class='row']//li[1]//p[@class='price_color']")
    WebElement firstClothingPrice;

    public String getFirstClothingInListPrice() {
        return firstClothingPrice.getText();
    }

//    @FindBy(xpath = "//a[contains(.,'Django T-shirt')]")
//    WebElement firstVariant;
//
//    @FindBy(id = "add_to_basket_form")
//    WebElement addToBasketBtn;
//
//    public ClothingPage addClothingToBasket() {
//        click(firstVariant);
//        click(addToBasketBtn);
//        return this;
//    }
//
//    @FindBy(css = "h1")
//    WebElement name;
//
//    public String getClothingName() {
//        return name.getText();
//    }
//
//    @FindBy(css = "div.row p.price_color")
//    WebElement price;
//
//    public String getClothingPrice() {
//        return price.getText();
//    }
}
