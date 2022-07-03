package br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterMapping {

    private WebDriver driver;

    @FindBy(how = How.ID_OR_NAME, using = "name")
    private WebElement inputName;
    
    public RegisterMapping(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectNameInput(String name){
        this.inputName.sendKeys(name);
    }
}
