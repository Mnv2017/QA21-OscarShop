package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FictionPage extends PageBase {
    public FictionPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFictionPagePresent() {
        return isElementPresent(By.xpath("//h1[text()='Fiction']"));
    }

    public boolean isComputerInLiteraturePagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Computers in Literature')]"));
    }
}
