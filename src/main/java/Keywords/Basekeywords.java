package Keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basekeywords {
    public WebDriver driver;
    public WebDriverWait wait;
    
    public Basekeywords (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Click Method
    public void Click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void InputText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String ReadText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}
