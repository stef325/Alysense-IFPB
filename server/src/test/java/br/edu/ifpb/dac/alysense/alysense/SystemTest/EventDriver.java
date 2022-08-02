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

import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.CreateEventMapping;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.FeedEventMapping;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.LoginMapping;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.RegisterMapping;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.UpdateEventMapping;

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
		driver.get("http://localhost:3000/login");

		//login
		LoginMapping login = new LoginMapping(driver);
		login.selectNameInput("filipe");
		timeSleep();
		login.selectPasswordInput("123");
		timeSleep();
		login.clickBtn();

		//inicio Do createEvent
		CreateEventMapping createEventMapping = new CreateEventMapping(driver);

		createEventMapping.clickNavBarCreateEvent();
		timeSleep();

		assertEquals("CRIAR NOVO EVENTO", createEventMapping.textTitle());

		JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,1000)","" );

		createEventMapping.inputTitle("Bolo de casamento");
		timeSleep();

		createEventMapping.inputLocal("Loja de bolos");
		timeSleep();

		createEventMapping.inputDate("10072022");
		timeSleep();

		createEventMapping.inputPaticipants("10");
		timeSleep();

		createEventMapping.inputSamples("10");
		timeSleep();

		createEventMapping.clickCreateEvent();
		timeSleep();
		//Fim do createEvent

		//inicio do FeedEvent
		FeedEventMapping feedEventMapping = new FeedEventMapping(driver);

		assertEquals("SEUS EVENTOS", feedEventMapping.textTitle());

		feedEventMapping.inputTitle("Bolo de casamento");
		timeSleep();

		feedEventMapping.inputLocal("Loja de bolos");
		timeSleep();

		feedEventMapping.clickButtonSearch();
		timeSleep();

		assertAll(()-> assertEquals("Bolo de casamento",feedEventMapping.columnTitle()),
				()-> assertEquals("Loja de bolos", feedEventMapping.columnLocal()));

		//parte do update
		feedEventMapping.updateBtn();
		timeSleep();

		UpdateEventMapping update = new UpdateEventMapping(driver);

		assertEquals("ATUALIZAR EVENTO", update.textTitle());

		jse.executeScript("scrollBy(0,1000)","" );

		update.inputTitle("Bolo de aniversario");
		timeSleep();

		update.clickUpdate();
		timeSleep();

		feedEventMapping.inputTitle("Bolo de aniversario");
		timeSleep();

		feedEventMapping.inputLocal("Loja de bolos");
		timeSleep();

		feedEventMapping.clickButtonSearch();
		timeSleep();

		assertEquals("Bolo de aniversario",feedEventMapping.columnTitle());

		feedEventMapping.deleteBtn();
		timeSleep();

		feedEventMapping.exit();
		timeSleep();
		
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
