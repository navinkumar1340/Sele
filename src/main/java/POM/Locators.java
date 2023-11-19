package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Locators {
    WebDriver driver;
    public Locators(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how= How.XPATH,using = "//input[@type = 'email']")
    WebElement email;
    @FindBy(how=How.XPATH,using = "//input[@type='password']")
    WebElement password;

    //@FindBy(how = How.XPATH,using = "//input[@type='checkbox']")
    //WebElement checkbox;
    @FindBy(how=How.XPATH,using="//button[@type='submit']")
    WebElement Submitbutton;

    public void  login(String emailid,String pwd){
        email.clear();
        email.sendKeys(emailid);
        password.clear();
        password.sendKeys(pwd);
        Submitbutton.click();

    }
    
    
    
    
    
    
    
    
    
    
    public void invalid(){
        boolean inv = driver.findElement(By.xpath("//*[@class ='message-error validation-summary-errors']")).isDisplayed();
        System.out.println("The error as been displayed "  + " " + inv);
    }
    public void Without_password(){
        boolean error5 = driver.findElement(By.xpath("//span[@class ='field-validation-error']")).isDisplayed();
         System.out.println("The error as been displayed "  + " " + error5);
    }
    public void maximum_length() {
        boolean error7 = driver.findElement(By.xpath("//*[text() = 'Wrong email']")).isDisplayed();
        System.out.println("The error as been displayed " + " " + error7);
    }
    public void check_box(){
        boolean selected = driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
        System.out.println("The checkbox as been selected "  + " " + selected);
    }
    public void Login_Button(){
        boolean disp = driver.findElement(By.xpath("//*[@class = 'field-validation-error']")).isDisplayed();
        System.out.println("The checkbox color as been changed "  + " " + disp);
    }

}


