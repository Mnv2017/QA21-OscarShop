package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NonFictionPage extends PageBase {
    public NonFictionPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNonFictionPagePresent() {
        return isElementPresent(By.xpath("//h1[text()='Non-Fiction']"));
    }

    public boolean isEssentialPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Essential programming')]"));
    }

    public boolean isHackingPagePresent() {
        return isElementPresent(By.xpath("//h1[contains(.,'Hacking')]"));
    }
}
