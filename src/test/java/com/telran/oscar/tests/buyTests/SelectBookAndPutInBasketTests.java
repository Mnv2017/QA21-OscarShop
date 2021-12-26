package com.telran.oscar.tests.buyTests;

import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.HomePage;
import com.telran.oscar.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectBookAndPutInBasketTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        new HeaderPage(driver)
                .clickLoginBtn()
                .logIn("nm123@mail.com","Qwerty123$");
    }

    @Test
    public void selectBookAndPutInBasket() {
        new HomePage(driver).getBooksPage()
                .searchProductByName("Hacking Work")
                .openSelectedBook("Hacking Work")
                .addBookToBasket()
                .viewBasket().addNBookToBasket("4");

        // ToDo добавить assert - цена корзины = цены книги
    }

    // ToDo postcondition - удалить книгу из корзины?
}
