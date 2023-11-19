package POM.testcases;

import POM.Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;

    @BeforeMethod

    public void startbrowser(){
        driver= WebDriverManager.chromedriver().create();
        driver.get("https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void  login_with_valid_details(){
        Locators method= PageFactory.initElements(driver, Locators.class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       method.login("admin@yourstore.com","admin");
       method.valid();
    }

    @Test
    public void login_with_invalid_details(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("navin@yourstore.com","navin");
        method1.invalid();
    }

    @Test
    public void login_valid_EmailId_with_invalid_Password_details(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("admin@yourstore.com","navin");
        method1.invalid();
    }

    @Test
    public void login_invalid_EmailId_with_valid_Password_details(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("navin@yourstore.com","admin");
        method1.invalid();
    }

    @Test
    public void login_valid_EmailId_with_without_Password_details(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("admin@yourstore.com","");
       method1.invalid();
    }

    @Test
    public void login_without_EmailId_with_valid_Password_details(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("","admin");
        method1.Without_password();
    }

    @Test
    public void login_without_EmailId_and_without_Password_details(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("","");
        method1.Without_password();
    }
    @Test
    public void maximum_length_of_the_email(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("navin@yourstore.comudhfjhajsdfjjdhdffuahsfujdshfjhsdhfgdsihgkjsddhgifsdlssngfvksdkfkksdjdhfhisddhfishfishfihsdifhidhffis","admin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        method1.maximum_length();
    }

    @Test
    public void minimum_length_of_the_email(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("nh","admin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        method1.maximum_length();
    }

    @Test
    public void maximum_length_of_the_password(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("admin@yourstore.com","adminuhfiuldhfhiehfihehiriewifejfif");
    }

    @Test
    public void minimum_length_of_the_password(){
        Locators method1= PageFactory.initElements(driver, Locators.class);
        method1.login("admin@yourstore.com","ad");
    }
    @Test
    public void checkbox_select(){
        Locators meth = PageFactory.initElements(driver, Locators.class);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        meth.check_box();
    }

    @Test
    public void checkbox_select_colour() {
        Locators meth = PageFactory.initElements(driver, Locators.class);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        meth.check_box();
    }
        @Test
        public void Login_button_select_() {
            Locators method1 = PageFactory.initElements(driver, Locators.class);
            method1.login("", "");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            method1.Login_Button();
        }

        @AfterMethod
        public void closebrower () {
            driver.close();
        }
    }
