package litecart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    WebDriver driver;
    public WebDriver setupBrowser(String browser){
        if(browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
    public void closeBrowser(){
        driver.close();
    }
}


