package TestCase;

import PageObjectory.LoginPageObject;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BrowserSetUp.ConfigBrowser;
import ExcelFileReader.ExcelUtil;
import utils.extentreports.ExtentTestManager;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
public class CaseCreationTest extends ConfigBrowser {

	@BeforeTest
	public void setupTestData() throws Exception {
		System.out.println("************Execution of Test Script Started**********");
		ExcelUtil.setExcelFileSheet("LoginData");
	}

	@Test(priority = 0, description = "Creating a New Case")
	public void CaseCreation() throws Exception {

		ExtentTestManager.getTest().setDescription("Creating a New Case");

		LoginPageObject loginpage = new LoginPageObject(driver, wait);
		Thread.sleep(100);
		loginpage.goToN11();
		loginpage.loginToN11(ExcelUtil.getRowData(1));
		Thread.sleep(100);
		// loginpage.SwitchToLightning();
//		loginpage.CaseButton();
//		loginpage.NewButton();
//		loginpage.scrollIntoView();
//		loginpage.NewCaseRadioButton();
//		loginpage.NextButton();
//		loginpage.SaveButton();
//		Thread.sleep(1000);
//		loginpage.AccountName(ExcelUtil.getRowData(1));
//		loginpage.scrollIntoViewInternalStatus();
//		loginpage.CallTypeRandomSelect();
//		loginpage.InquirySelect();
//		loginpage.scrollIntoDatePicker();
//		loginpage.SubjectText(ExcelUtil.getRowData(1));
//		loginpage.DescriptionTest(ExcelUtil.getRowData(1));
//		loginpage.CurrentDatePicker();
//		loginpage.SaveButton();
//		Thread.sleep(20000);
	}
}
