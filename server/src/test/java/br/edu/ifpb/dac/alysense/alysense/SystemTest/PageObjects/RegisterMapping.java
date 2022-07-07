package br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterMapping {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "#name")
    private WebElement inputName;

    @FindBy(how = How.CSS, using = "#date")
    private WebElement inputDate;

    @FindBy(how = How.CSS, using = "#email")
    private WebElement inputEmail;

    @FindBy(how = How.CSS, using = "#password")
    private WebElement inputPassword;

    @FindBy(how = How.CSS, using = "div.App div.register div.register-container div.register-form:nth-child(1) div.big-form form:nth-child(2) div.action-button:nth-child(5) > button.btn.btn-primary")
    private WebElement btn;

    public RegisterMapping(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectNameInput(String name){
        this.inputName.sendKeys(name);
    }

    public void selectDateInput(String date){
        this.inputDate.sendKeys(date);
    }

    public void selectEmailInput(String email){
        this.inputEmail.sendKeys(email);
    }

    public void selectPasswordInput(String password){
        this.inputPassword.sendKeys(password);
    }

    public void clickBtn(){
        this.btn.click();
    }
}
