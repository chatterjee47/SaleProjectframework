package BrowserSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import ReadConfigFile.ConfigFileReader;

public class ConfigBrowser {
    public WebDriver driver;
    public WebDriverWait wait;
    ConfigFileReader configFileReader;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass (description = "Class Level Setup!")
	@Parameters("browser") 
	public void openBroswer(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			ConfigFileReader configFileReader= new ConfigFileReader();
			System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			ConfigFileReader configFileReader= new ConfigFileReader();
			System.setProperty("webdriver.gecko.driver", configFileReader.getDriverPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Internet Explorer")) {
			ConfigFileReader configFileReader= new ConfigFileReader();
			System.setProperty("webdriver.ie.driver", configFileReader.getDriverPath());
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
	}

    @AfterMethod(description = "Class Level Teardown!")
    public void teardown () throws InterruptedException {
    	Thread.sleep(5000);
        driver.close();
    }

}
