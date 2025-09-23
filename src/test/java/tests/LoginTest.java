

package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

    @Test
    public  void testValidLogin(){
        Log.info("LoginTest starting");
        test = ExtentReportManager.createTest("Login Test");

        test.info("navigation to URL");
        LoginPage loginpage = new LoginPage(driver);

        Log.info("adding info");
        test.info("adding info");

        loginpage.enterUserName("admin@yourstore.com");
        loginpage.enterUserPassword("admin");

        test.info("clicking button");
        loginpage.clickLogin();
        System.out.println("page title " + driver.getTitle());
        Log.info("verifying page title");
        test.info("adding info");
      Assert.assertEquals(driver.getTitle(), "Just a moment... 123");
        test.pass("login successful");

    }
}