package litecart.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    WebDriver driver;
    public WebDriver setupBrowser(String browser){
        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
        }
        else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }
    public void closeBrowser(){
        driver.close();
    }
}


