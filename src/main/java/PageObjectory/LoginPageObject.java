package PageObjectory;

import io.qameta.allure.Step;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Keywords.Basekeywords;

public class LoginPageObject extends Basekeywords {
	 static ArrayList<String> al ;
	 
    public LoginPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //web elements
    String usenameId = "//input[@id='username']";
    String passwordId = "//input[@id='password']";
    String signInButtonClass = "//input[@id='Login']";
    String SwitchToLightning = "//div[@class='linkElements']/a";
    String CaseButton = "//*[@id='oneHeader']/div[3]/one-appnav/div/one-app-nav-bar/nav/ul/li[5]/a/span";
    String NewButton = "//*[@id='brandBand_1']/div/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div";
    String NewCaseWindowOption = "//*[@class='changeRecordTypeOptionRightColumn']/span[@data-aura-rendered-by='312:1053;a']";
    String NewCaseRadioButton = "html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/fieldset/div[2]/div[27]/label/div[1]/span";
    String NextButton = "//div[@class='forceChangeRecordTypeFooter']/button[2]";
    String SaveButton = "//button[@title='Save']/span[1]";
    String AccountName = "//input[@title='Search Accounts']";
    String SubjectText = "//input[@data-interactive-lib-uid='52']";
    String DescriptionTest = "//textarea[@data-interactive-lib-uid='53']";
    String RespondByDate = "//input[@data-interactive-lib-uid='54']";
    String TodaysDate = "//table[@class='calGrid']/tbody/tr/td[@colspan='7']";
    
    
    //Methods
    @Step("Login Step with username: {1}, password: {2}, for method: {method} step...")
    public void loginToN11 (XSSFRow row){
    	System.out.println("Entered Valid Username");
    	InputText(By.xpath(usenameId),row.getCell(0).toString());
   	    System.out.println("Entered Valid Password");
    	InputText(By.xpath(passwordId), row.getCell(1).toString());
    	System.out.println("Clicking on Sign Button");
        Click(By.xpath(signInButtonClass));
    }
 
    @Step("Opening the Browser Step...")
    public void goToN11 () throws InterruptedException{
    	File file = new File("D://WiproFramework//SalesforceFramework//configs//Configuration.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("Url"));
		System.out.println("Opening the Browser and hiting the Url");
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		
    }

    //Clicking on Sign Button
    @Step("SignIn Button Click Step...")
    public void SignInButton (){
    	System.out.println("Clicking on Sign Button");
        Click(By.xpath(signInButtonClass));
    }
    
    //Clicking on Next Button
    @Step("Next Button Click Step...")
    public void NextButton () throws InterruptedException{
    	Thread.sleep(5000);
    	System.out.println("Clicking on Next Button");
        Click(By.xpath(NextButton));
    }
    
    //Clicking on Next Button
    @Step("Save Button Click Step...")
    public void SaveButton () throws InterruptedException{
    	Thread.sleep(5000);
    	System.out.println("Clicking on Save Button");
        Click(By.xpath(SaveButton));
    }
    
    
   
    
    @Step("Account Name")
    public void AccountName (XSSFRow row) throws InterruptedException{
    	
    	Thread.sleep(5000);
    	System.out.println("Entered Account Name");
    	InputText(By.xpath(AccountName),row.getCell(2).toString());
    	Thread.sleep(5000);
    	driver.findElement(By.xpath(AccountName)).sendKeys(Keys.ARROW_DOWN);
    	driver.findElement(By.xpath(AccountName)).sendKeys(Keys.ENTER);
    	Thread.sleep(20000);
   // 	driver.findElement(By.xpath("//a[@title='Test QA Account']")).click();
    	Thread.sleep(10000);
    	
    }
 
    
    //Clicking on Next Button
    @Step("Call Type Select Step...")
    public void CallTypeRandomSelect() throws InterruptedException{
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//a[@data-interactive-lib-uid='46']")).click();
    	Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Account Set-Up']")).click();
		Thread.sleep(2000);
}
    
  //Clicking on Next Button
    @Step("Inquiry Select Step...")
    public void InquirySelect() throws InterruptedException{
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//a[@data-interactive-lib-uid='47']")).click();
    	Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Service Fees']")).click();
		Thread.sleep(2000);
}
    
    @Step("Entering Subject")
    public void SubjectText (XSSFRow row) throws InterruptedException{
    	
    	Thread.sleep(5000);
    	System.out.println("Entered Subject Text");
    	InputText(By.xpath(SubjectText),row.getCell(3).toString());
    	Thread.sleep(5000);
    }
   
    
    @Step("Entering Description")
    public void DescriptionTest (XSSFRow row) throws InterruptedException{
    	
    	Thread.sleep(5000);
    	System.out.println("Entered Description Test");
    	InputText(By.xpath(DescriptionTest),row.getCell(4).toString());
    	Thread.sleep(5000);
    }
    
    @Step("Current Date Picker Step...")
    public void CurrentDatePicker() throws InterruptedException{
    	Thread.sleep(2000);
    	System.out.println("Clicking on Current Date Picker");
        Click(By.xpath(RespondByDate));
        Thread.sleep(2000);
        Click(By.xpath(TodaysDate));
        Thread.sleep(2000);
    }
    
    
  //SwitchToLightning
    @Step("Clicking on Switch to Lightning Experience...")
    public void SwitchToLightning() throws InterruptedException{
    	
    	Thread.sleep(10000);
    	WebElement  SwitchToLightning = driver.findElement(By.xpath("//*[@id='phHeader']/tbody/tr/td[3]/div/div[3]/div/a"));
    	System.out.println("Clicking on SwitchToLightning");
    	Thread.sleep(10000);
        if (SwitchToLightning.isDisplayed()) {
        	Thread.sleep(10000);
        	SwitchToLightning.click();
        	Thread.sleep(10000);
        	}
        	else {
        		WebElement  SearchSwitchToLightning = driver.findElement(By.xpath("//*[@id='107:1353;a']/div[1]/div[1]/div/div[5]/a"));
        		System.out.println("Clicking on SwitchToLightning");
        		Thread.sleep(10000);
        		SearchSwitchToLightning.click();
        		Thread.sleep(10000);
        		}
    }
    
    
  
  //CaseButton
    @Step("Clicking on Case Button")
    public void CaseButton () throws InterruptedException{
    	Thread.sleep(20000);
    	System.out.println("Clicking on Case Button");
        Click(By.xpath(CaseButton));
    }
    
    //NewButton
    @Step("Clicking on New Button")
    public void NewButton () throws InterruptedException{
    	Thread.sleep(20000);
    	System.out.println("Clicking on New Button");
        Click(By.xpath(NewButton));
    }
    
    //NewCaseRadioButton
    @Step("Clicking on New Button")
    public void NewCaseRadioButton () throws InterruptedException{
    	Thread.sleep(2000);
    	System.out.println("Clicking on New Case Radio Button");
        Click(By.xpath(NewCaseRadioButton));
    }
    
    
    
    //NewButton
    @Step("Scroll to view webelement")
    public void scrollIntoView () throws InterruptedException{
    	
    	Thread.sleep(5000);
    	WebElement element = driver.findElement(By.xpath("//div[@class='changeRecordTypeOptionRightColumn']/span[contains(., 'LBC Case Record Type')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       
        Thread.sleep(5000);
    }
    
  //NewButton
    @Step("Scroll to view webelement")
    public void scrollIntoViewInternalStatus () throws InterruptedException{
    	
    	Thread.sleep(10000);
    	WebElement element = driver.findElement(By.xpath("//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/span[contains(., 'Internal Status')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       
        Thread.sleep(10000);
    }
     
    
    //NewButton
    @Step("Scroll to DatePicker")
    public void scrollIntoDatePicker () throws InterruptedException{
    	
    	Thread.sleep(5000);
    	WebElement element = driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']/span[contains(., 'Date Picker')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       
        Thread.sleep(5000);
    }
    
    
    //MouseOver
    @Step("Go to Bear Icon Step...")
    public void MouseOver (){
    	WebElement element = driver.findElement(By.xpath(""));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        WebElement subElement = driver.findElement(By.xpath(""));
        action.moveToElement(subElement);
        action.click();
        action.perform();
    }
    
 
    @Step("Verifying Title of the Page...")
    public void VerifyTitle() throws InterruptedException{
    	//Verify the title
        Thread.sleep(10000);
        //get the actual value of the title
        String eTitle = "Salesforce - Unlimited Edition";
    	String aTitle = "" ;
    	aTitle = driver.getTitle();
    	System.out.println("Title display as: " + aTitle);
    	//compare the actual title with the expected title
    	if (aTitle.equals(eTitle))
    	{
    	System.out.println( "Title of the page Verified") ;
    	}
    	else 
    	{
    	System.out.println( "Title of the page Not Verified" );
    	}
    }
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    @FindBy(xpath = "//input[@value='Find Flights']") 
//    public WebElement Button_FindFlights;
//
//    public void Button_FindFlights (){
//    	Button_FindFlights.click();
//    }
//    
//    //Verify Username Condition
//    @Step("Verify username: {0} step...")
//    public void verifyLoginUserName (String expectedUserNameMessage) {
//        Assert.assertEquals(ReadText(By.xpath(errorMessageUsernameXpath)), expectedUserNameMessage);
//    }
//
//    //Verify Password Condition
//    @Step("Verify verifyLoginPassword: {0} step...")
//    public void verifyLoginPassword (String expectedPasswordMessage) {
//        Assert.assertEquals(ReadText(By.xpath(errorMessagePasswordXpath)), expectedPasswordMessage);
//    }

}
