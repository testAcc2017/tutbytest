package com.epam.tutbylettercounter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMailPage extends YandexMailLoginPage{
	private final Wait<WebDriver> wait = new WebDriverWait(driver, 5);
	
	@FindBy(xpath = "//span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_body js-message-snippet-body\"]")
	private WebElement incomeLetters;

	public YandexMailPage(WebDriver driver) {
		super(driver);
	}
	
	public int incomeLetterCounter() {
		wait.until(ExpectedConditions.visibilityOf(incomeLetters));
		int counter = driver.findElements(By.xpath("//span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_body js-message-snippet-body\"]")).size();
		return counter;
	}
}
