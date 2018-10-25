package TestCase;

import PageObjectory.LoginPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BrowserSetUp.ConfigBrowser;
import ExcelFileReader.ExcelUtil;
import utils.extentreports.ExtentTestManager;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
public class LoginPageTest extends ConfigBrowser {
	
    @BeforeTest
    public void setupTestData () throws Exception {
        System.out.println("************Setup Test Level Data**********");
        ExcelUtil.setExcelFileSheet("LoginData");
    }

    @Test (priority = 0, description="Valid Login Scenario with valid username and password.")
    public void LoginTest () throws Exception {
    	
    	
        ExtentTestManager.getTest().setDescription("Valid Login Scenario with valid username and password.");
        
        LoginPageObject loginpage = new LoginPageObject(driver,wait);

        loginpage.goToN11();
        loginpage.SignInButton();

        loginpage.loginToN11(ExcelUtil.getRowData(1));
      
        ExcelUtil.setRowNumber(1);
        ExcelUtil.setColumnNumber(3);
        
        loginpage.VerifyTitle();
    }
}
