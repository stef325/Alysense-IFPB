package br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UpdateEventMapping {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "div.App div.EventUpdate header.EventUpdate-header div.main-container div.big-form > h1.title:nth-child(1)")
    private WebElement textTitle;

    @FindBy(how = How.CSS, using = "#inputTitulo")
    private WebElement inputTitle;

    @FindBy(how = How.CSS, using = "#inputLocal")
    private WebElement inputLocal;
   
    @FindBy(how = How.CSS, using = "div.App div.EventUpdate header.EventUpdate-header div.main-container div.big-form form:nth-child(2) div.action-button:nth-child(5) > button.btn.btn-primary")
    private WebElement uptadeBtn;

    public UpdateEventMapping(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String textTitle(){
        return this.textTitle.getText();
    }


    public void inputTitle(String title){
        this.inputTitle.clear();
        this.inputTitle.sendKeys(title);
    }



    public void clickUpdate(){
        this.uptadeBtn.click();
    }


}
