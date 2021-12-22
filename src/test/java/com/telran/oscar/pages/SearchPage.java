package com.telran.oscar.pages;

import com.telran.oscar.pages.product.ProductBookPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css = "a[title='Hacking Work']")
//    WebElement hackingWork; // ссылка на книгу

    @FindBy(xpath = "//div[@id='messages']//a[text()='View basket']")
    WebElement viewBasketBtn;

    public ProductBookPage openSelectedBook(String name) {
        WebElement selectedBook = driver.findElement(By.cssSelector("a[title='" + name + "']"));
        click(selectedBook);
        return new ProductBookPage(driver);
    }

}
