

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {

    @Test
    public  void testValidLogin(){
        Log.info("LoginTest starting");
        LoginPage loginpage = new LoginPage(driver);

        loginpage.enterUserName("admin@yourstore.com");
        loginpage.enterUserPassword("admin");
        loginpage.clickLogin();
        System.out.println("page title " + driver.getTitle());

    }
}