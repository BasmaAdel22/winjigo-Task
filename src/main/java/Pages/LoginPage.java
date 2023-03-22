package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By userNameField=By.id("Email");
    private By passwordField=By.id("inputPassword");
    private By loginButton=By.id("btnLogin");


    public void enterusername(String username){
        driver.findElement(userNameField).sendKeys(username);
    }
    public void enterpassword(String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }

    public HomePage ClickOnLogin(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

}
