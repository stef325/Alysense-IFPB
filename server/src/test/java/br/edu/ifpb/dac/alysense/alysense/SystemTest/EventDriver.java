package br.edu.ifpb.dac.alysense.alysense.SystemTest;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.RegisterMapping;

public class EventDriver {
    
    static WebDriver driver;
	
	@BeforeAll
	static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

    @Test
    public void eventCreateTest(){
		driver.get("http://localhost:3000");
		
    }

    @AfterAll
	static void tearDown(){
		driver.close();
		driver.quit();
	}
}
