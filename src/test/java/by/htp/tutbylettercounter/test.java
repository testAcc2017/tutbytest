package by.htp.tutbylettercounter;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
	private WebDriver driver;
	
	
	@BeforeTest
	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver", "..\\tutbylettercounter\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void incomeLetterCounter() throws InterruptedException {
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
		driver.close();
	}
}
