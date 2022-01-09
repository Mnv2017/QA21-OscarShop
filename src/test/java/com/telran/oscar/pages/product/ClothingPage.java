package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
