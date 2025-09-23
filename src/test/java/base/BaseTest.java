package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {

   protected  WebDriver  driver ;
   protected static  ExtentReports extent;
   protected ExtentTest test;

   @BeforeSuite
   public void SetupReport(){
        extent = ExtentReportManager.getReportInstance();
   }
   @AfterSuite
  public  void teardownReport(){
       extent.flush();
  }
 @BeforeMethod
  public void setUp (){
     Log.info("WebDriver starting");
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
//      driver.manage().window().maximize();
     driver.manage().window().setSize(new Dimension(1920, 1080));
      Log.info("go URL");
      driver.get("https://admin-demo.nopcommerce.com/login");
  }

  @AfterMethod
  public void tearDown(ITestResult result){
       if(result.getStatus()==ITestResult.FAILURE){
           String screenshotPath= ExtentReportManager.captureScreenShot(driver,"LoginFailure");
           test.fail("test failed check screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
       }
     if(driver != null ){
//         driver.quit();
     }
  }
}
