package com.epam.tutbylettercounter;

import static org.testng.Assert.assertEquals;

import com.epam.tutbylettercounter.pages.MainPage;
import com.epam.tutbylettercounter.pages.YandexMailLoginPage;
import com.epam.tutbylettercounter.pages.YandexMailPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LetterCounterTest extends Configuration {

    @Test
    public void incomeLetterCounterTest(){
        int numberOfLetters;
        MainPage page = new MainPage(driver);
        page.open();
		page.authorizeUser("User2017", "12345678");
		YandexMailLoginPage mailPage = page.enterMail();
		mailPage.clickMailButton();
		YandexMailPage yaMailPage = mailPage.authorizeUser("User2017@tut.by", "12345678");
		numberOfLetters = yaMailPage.incomeLetterCounter();
		assertEquals(numberOfLetters, 2);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }

}
