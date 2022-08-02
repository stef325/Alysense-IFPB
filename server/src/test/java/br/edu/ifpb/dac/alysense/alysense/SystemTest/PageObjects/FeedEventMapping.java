package br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FeedEventMapping {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "div.App div.EventFeed header.EventFeed-header div.main-container div.big-form > h1.title:nth-child(1)")
    private WebElement textTitle;

    @FindBy(how = How.CSS, using = "#inputTitulo")
    private WebElement inputTitle;

    @FindBy(how = How.CSS, using = "#inputLocal")
    private WebElement inputLocal;

    @FindBy(how = How.CSS, using = "div.App div.EventFeed header.EventFeed-header div.main-container div.big-form form:nth-child(2) div.action-button > button.btn.btn-primary")
    private WebElement btnSearch;

    @FindBy(how = How.CSS, using = "div.App div.EventFeed header.EventFeed-header div.main-container div.EventTable table.table.table-hover tbody:nth-child(2) tr:nth-child(1) > td:nth-child(1)")
    private WebElement titleColumn;
    
    @FindBy(how = How.CSS, using = "div.App div.EventFeed header.EventFeed-header div.main-container div.EventTable table.table.table-hover tbody:nth-child(2) tr:nth-child(1) > td:nth-child(2)")
    private WebElement localColumn;
    
    @FindBy(how = How.CSS, using = "#inputDate")
    private WebElement inputDate;

    @FindBy(how = How.CSS, using = "div.App div.EventFeed header.EventFeed-header div.main-container div.EventTable table.table.table-hover tbody:nth-child(2) tr:nth-child(1) td:nth-child(4) > button.btn.btn-info:nth-child(1)")
    private WebElement updateEvent;

    @FindBy(how = How.CSS, using = "div.App div.EventFeed header.EventFeed-header div.main-container div.EventTable table.table.table-hover tbody:nth-child(2) tr:nth-child(1) td:nth-child(4) > button.btn.btn-danger:nth-child(2)")
    private WebElement deleteEvent;
    
    @FindBy(how = How.CSS, using = "div.App div.nav-bar nav.navbar.navbar-expand-lg.navbar-dark.bg-primary div.container-fluid div.collapse.navbar-collapse ul.navbar-nav.me-auto li.nav-item:nth-child(5) > a.nav-link")
    private WebElement exit;
    

    public FeedEventMapping(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputTitle(String title){
        this.inputTitle.sendKeys(title);
    }

    public void inputLocal(String local){
        this.inputLocal.sendKeys(local);
    }

    public void inputDate(String date){
        this.inputDate.sendKeys(date);
    }

    public String textTitle(){
        return this.textTitle.getText();
    }

    public void clickButtonSearch(){
        this.btnSearch.click();
    }

    public String columnTitle(){
        return this.titleColumn.getText();
    }

    public String columnLocal(){
        return this.localColumn.getText();
    }

    public void updateBtn(){
        this.updateEvent.click();
    }

    public void deleteBtn(){
        this.deleteEvent.click();
    }
    
    public void exit(){
        this.exit.click();
    }
}
