package br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UpdateProductMapping {
    private WebDriver driver;

   

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/h1[1]")
    private WebElement title;
    

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
    private WebElement nameInput;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/input[1]")
    private WebElement ownerInput;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement sampleid;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/input[1]")
    private WebElement expdate;

    
    

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[5]/button[1]")
    private WebElement btnUpdate;
    

    public UpdateProductMapping(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String gettitlepage(){
        return this.title.getText();
    }
    public String getInputName(){
        return this.nameInput.getText();
    }

    public void selectinputName(String name){
        this.nameInput.sendKeys(name);
    }
    public void selectinputexpdate(String name){
        this.expdate.sendKeys(name);
    }
    public String getInputowner(){
        return this.ownerInput.getText();
    }
    public String getsampleID(){
        return this.sampleid.getText();
    }

    public void selectinputowner(String name){
        this.ownerInput.sendKeys(name);
    }

    public void clickupdt(){
        this.btnUpdate.click();
    }

    

}
