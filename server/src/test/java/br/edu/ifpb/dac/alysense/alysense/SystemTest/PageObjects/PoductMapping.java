package br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PoductMapping {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Adicionar Produto')]")
    private WebElement navbtn;

    @FindBy(how = How.CSS, using = "#name")
    private WebElement name;

    @FindBy(how = How.CSS, using = "body.vid_found:nth-child(2) div.toast-top-left:nth-child(5) > div.toast.toast-error:nth-child(3)")
    private WebElement alertexpdate;

    @FindBy(how = How.CSS, using = "#owner")
    private WebElement owner;

    @FindBy(how = How.CSS, using = "#date")
    private WebElement expdate;

    @FindBy(how = How.CSS, using = "#ingredients")
    private WebElement ingr;

    @FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/button[1]")
    private WebElement addBTNs;

    @FindBy(how = How.CSS, using = "#charact")
    private WebElement charactinput;

    @FindBy(how = How.XPATH, using = "//body/div[3]/div[1]/div[1]/div[1]/button[1]")
    private WebElement charactsendBTN;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement charactrowtable;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[2]/button[1]")
    private WebElement charactexcBTN;

    @FindBy(how = How.CSS, using = "#obs")
    private WebElement sampleOBSINPUT;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[2]/div[1]/div[1]/button[1]")
    private WebElement sampleAddBTN;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/button[1]")
    private WebElement samplesendBTN;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement sampleadded;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/button[1]")
    private WebElement createProd;

    @FindBy(how = How.CSS, using = "div.App div.nav-bar nav.navbar.navbar-expand-lg.navbar-dark.bg-primary div.container-fluid div.collapse.navbar-collapse ul.navbar-nav.me-auto li.nav-item:nth-child(5) > a.nav-link")
    private WebElement exit;

    public PoductMapping(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void selectProdNameInput(String name) {
        this.name.sendKeys(name);
    }

    public void selectProdingrInput(String name) {
        this.ingr.sendKeys(name);
    }

    public void selectownerInput(String name) {
        this.owner.sendKeys(name);
    }

    public void selectExpDateInput(String name) {
        this.expdate.sendKeys(name);
    }

    public void selectcharactInput(String name) {
        this.charactinput.sendKeys(name);
        
    }

    public String getcharacttext() {
        return this.charactrowtable.getText();
        
    }

    public String getsampletext() {
        return this.sampleadded.getText();
        
    }

    public void selectsampleInput(String name) {
        this.sampleOBSINPUT.sendKeys(name);
    }

    public void clicknavBtn() {
        this.navbtn.click();
    }

    public void clickCharactBtn() {
        
        addBTNs.click();
    }

    public void clickaddCharactBtn() {
        
        charactsendBTN.click();
    }

    public void clickremCharactBtn() {
        
        charactexcBTN.click();
    }
    

    public void clicksampleBtn() {
        
        sampleAddBTN.click();
    }

    public void clicksamplesendBtn() {
        
        samplesendBTN.click();
    }

    public void clickcreateProd() {
        
        createProd.click();
    }


    public void exit() {
        this.exit.click();
    }
}
