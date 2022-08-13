package br.edu.ifpb.dac.alysense.alysense.SystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.LoginMapping;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.PoductMapping;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.ProductViewMapping;
import br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects.UpdateProductMapping;

public class ProductDriver {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @Test
    public void createProduct1() {

        driver.get("http://localhost:3000/login");
        

        // login
        LoginMapping login = new LoginMapping(driver);
        login.selectNameInput("filipe");
        timeSleep();
        login.selectPasswordInput("123");
        timeSleep();
        login.clickBtn();
        timeSleep();
        timeSleep();

        // checagem de url
        String urlini = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/EventFeed", urlini);
        // sair
        PoductMapping prod = new PoductMapping(driver);

        timeSleep();
        timeSleep();
        timeSleep();
        timeSleep();
        prod.clicknavBtn();
        timeSleep();

        String urlnewprod = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/newProduct", urlnewprod);

        timeSleep();

        prod.selectProdNameInput("Caixa de Madeira");
        timeSleep();
        prod.selectownerInput("marceneiro félix");
        timeSleep();
        prod.selectExpDateInput("01082022");
        timeSleep();
        prod.selectProdingrInput("madeira,pregos");
        timeSleep();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,1000)","" );

        prod.clickCharactBtn();
        timeSleep();
        prod.selectcharactInput("firme");
        timeSleep();
        prod.clickaddCharactBtn();
        timeSleep();
        timeSleep();
        prod.clickremCharactBtn();
        timeSleep();
        timeSleep();
        prod.clickCharactBtn();
        timeSleep();
        prod.selectcharactInput("Firme");
        timeSleep();
        prod.clickaddCharactBtn();
        timeSleep();
        timeSleep();

        assertEquals(prod.getcharacttext(), "Firme");

        prod.clicksampleBtn();
        timeSleep();
        prod.selectsampleInput("caixa pintada de azul");
        timeSleep();
        prod.clicksamplesendBtn();
        timeSleep();

        assertEquals(prod.getsampletext(), "1");

        timeSleep();
        timeSleep();
        prod.clickcreateProd();
        timeSleep();

        String urlpstclickCreateW = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/newProduct", urlpstclickCreateW);


        timeSleep();
        timeSleep();
        timeSleep();
        prod.selectExpDateInput("07082022");
        timeSleep();
        prod.clickcreateProd();
        timeSleep();
        String urlpstclickCreateOk = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/ProductView/", urlpstclickCreateOk);

    }

    @Test
    public void UpdateProduct1(){
        driver.get("http://localhost:3000/login");
        

        // login
        LoginMapping login = new LoginMapping(driver);
        login.selectNameInput("filipe");
        timeSleep();
        timeSleep();
        login.selectPasswordInput("123");
        timeSleep();
        timeSleep();
        timeSleep();
        login.clickBtn();
        timeSleep();
        timeSleep();
        timeSleep();

        // checagem de url
        String urlini = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/EventFeed", urlini);

        ProductViewMapping pdview = new ProductViewMapping(driver);
        timeSleep();
        timeSleep();
        timeSleep();
        timeSleep();
        pdview.clickNavBtnProd();
        timeSleep();

        String urlmyprod = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/ProductView", urlmyprod);
        timeSleep();
        timeSleep();

        String pdname = pdview.getProdname();
        String pdowner = pdview.getProdowner();

        timeSleep();
        timeSleep();
        pdview.clickeditBtn();
        timeSleep();
        timeSleep();
        String urleditpd = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/updateproduct/65", urleditpd);
        timeSleep();

        UpdateProductMapping updtmp = new UpdateProductMapping(driver);
        timeSleep();

        
        assertEquals(updtmp.gettitlepage(), "ATUALIZAR PRODUTO");
        timeSleep();
        timeSleep();
        timeSleep();

        String nm = updtmp.getInputName();
        timeSleep();
        timeSleep();
        assertEquals(nm, pdname);
        timeSleep();
        assertEquals(updtmp.getInputowner(), pdowner);
        timeSleep();


        assertNotEquals(updtmp.getsampleID(), "1");


        timeSleep();
        updtmp.selectinputName("");
        timeSleep();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,1000)","" );

        timeSleep();
        updtmp.clickupdt();
        timeSleep();
        timeSleep();
        String updtw = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/updateproduct/65", updtw);
        timeSleep();

        jse.executeScript("scrollBy(0,-1000)","" );

        timeSleep();
        timeSleep();
        updtmp.selectinputName("Caixa de Madeira");
        timeSleep();
        timeSleep();
        updtmp.clickupdt();
        timeSleep();
        String updtr = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/ProductView", updtr);



    }


    public void timeSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
	void tearDown(){
		driver.close();
	}
}
