package br.edu.ifpb.dac.alysense.alysense.SystemTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.FeedEventMapping;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.LoginMapping;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.RegisterMapping;

public class UserDriver {

    static WebDriver driver;
	
	@BeforeAll
	static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}
    
    @Test
	public void createLogin(){

			driver.get("http://localhost:3000/");
			//criando user
			RegisterMapping register = new RegisterMapping(driver);
			register.selectNameInput("filipe");
			timeSleep();
			register.selectDateInput("18122001");
			timeSleep();
			register.selectEmailInput("filipeteste@gmail.com");
			timeSleep();
			register.selectPasswordInput("123");
			timeSleep();
			register.clickBtn();
			timeSleep();

			//login
			LoginMapping login = new LoginMapping(driver);
			login.selectNameInput("filipe");
			timeSleep();
			login.selectPasswordInput("123");
			timeSleep();
			login.clickBtn();
			timeSleep();
			timeSleep();

			//checagem de url
			String url = driver.getCurrentUrl();
			assertEquals("http://localhost:3000/EventFeed", url);
			//sair
			FeedEventMapping eventMapping = new FeedEventMapping(driver);
			eventMapping.exit();

			url = driver.getCurrentUrl();
			assertEquals("http://localhost:3000/login", url);


	}

    public void timeSleep(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    @AfterAll
	static void tearDown(){
		driver.close();
		driver.quit();
	}
}
