package by.htp.tutbylettercounter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page{
	private final Wait<WebDriver> wait = new WebDriverWait(driver, 5);
			
	@FindBy(xpath = "//a[@class = 'enter']")//(xpath = "//input[@name=\"login\"]")
	private WebElement loginButton;
	
	@FindBy(name = "login")//(xpath = "//input[@name=\"login\"]")
	private WebElement userLogin;
	
	@FindBy(name = "password")//(xpath = "//input[@name=\"password\"]")
	private WebElement userPassword;
	
	@FindBy(xpath = "//input[@type='submit' and @class='button auth__enter']")
	private WebElement enterButton;
	
	@FindBy(xpath = "//div[@id = 'mainmenu']//li[3]/a")
	private WebElement mailButton;
	
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	private void enterLogin(String login){
		userLogin.clear();
		userLogin.sendKeys(login);
	}
	
	private void enterPassword(String password){
		userPassword.clear();
		userPassword.sendKeys(password);
	}
	
	//method enters login and password and then click submit button
	public MainPage authorizeUser(String login, String password) {
		loginButton.click();
		enterLogin(login);
		enterPassword(password);
		enterButton.click();
		return new MainPage(driver);
	}
	
	//method click user name icon to get drop-down menu and click mail button
	public YandexMailPage enterMail() {
		mailButton.click();
		return new YandexMailPage(driver);
	}
}
