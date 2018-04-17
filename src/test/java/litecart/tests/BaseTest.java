package litecart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    WebDriver driver;

    public void setupBrowser(){
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();

    }

    public void closeBrowser(){
        driver.close();
    }
}



