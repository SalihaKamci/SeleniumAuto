package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class LoginPage {
    private WebDriver driver ;

    private By  userEmailtextbox = By.id("Email");
    private By  userPasswordtextbox = By.id("Password");
    private By  loginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
 public  LoginPage (WebDriver driver){
     this.driver = driver;
 }
  public void enterUserName (String userEmail){
  driver.findElement(userEmailtextbox).clear();
   driver.findElement(userEmailtextbox).sendKeys(userEmail);
  }

    public void enterUserPassword (String userPassword){
        driver.findElement(userPasswordtextbox).clear();
    driver.findElement(userPasswordtextbox).sendKeys(userPassword);
    }


    public void clickLogin (){
        Log.info("loginButton clicking");
   driver.findElement(loginButton).click();
    }
}
