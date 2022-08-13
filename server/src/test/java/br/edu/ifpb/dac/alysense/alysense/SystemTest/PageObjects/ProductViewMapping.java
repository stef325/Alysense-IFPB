package br.edu.ifpb.dac.alysense.alysense.SystemTest.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductViewMapping {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/button[1]")
    private WebElement editbtn;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Seus Produtos')]")
    private WebElement navbtn;
    

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement FPname;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
    private WebElement FPowner;

    

    

    public ProductViewMapping(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getProdname(){
        return this.FPname.getText();
    }
    public String getProdowner(){
        return this.FPowner.getText();
    }

    public void clickNavBtnProd(){
        this.navbtn.click();
    }


    public void clickeditBtn() {
        this.editbtn.click();
    }

}
