package litecart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    WebDriver driver;


    public BaseTest() throws MalformedURLException {
    }

    public void setupBrowser() throws MalformedURLException {

        //new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        driver = new ChromeDriver();

        //driver = new FirefoxDriver();

    }

    public void closeBrowser(){
        driver.close();
    }
}



