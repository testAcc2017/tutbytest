package com.epam.tutbylettercounter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMailLoginPage extends MainPage{
	private final Wait<WebDriver> wait = new WebDriverWait(driver, 2).ignoring(NoSuchElementException.class, ElementNotVisibleException.class);

	@FindBy(xpath = "//a[@class= ' nb-button _nb-large-action-button new-hr-auth-Form_Button-enter']")
	private WebElement YadexMailButton;
	
	@FindBy(name = "login")
	private WebElement userLogin;
	
	@FindBy(name = "passwd")
	private WebElement userPassword;
	
	@FindBy(xpath = "//span[@class = 'passport-Button-Text']")
	private WebElement submitButton;

	public YandexMailLoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	public YandexMailLoginPage clickMailButton() {
		YadexMailButton.click();
		return new YandexMailLoginPage(driver);
	}
	
	private void enterLogin(String login){
		if(!driver.findElement(By.name("login")).getAttribute("value").equals(login)){
			wait.until(ExpectedConditions.visibilityOf(userLogin));
			userLogin.clear();
			userLogin.sendKeys(login);
		}
	}
	
	private void enterPassword(String password){
		userPassword.clear();
		userPassword.sendKeys(password);
	}
	
	public YandexMailPage authorizeUser(String login, String password) {
		
		enterLogin(login);
		enterPassword(password);
		submitButton.click();
		return new YandexMailPage(driver);
	}
}
