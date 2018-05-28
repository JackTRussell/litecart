package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class BasePage {



    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = wait;
        driver.manage().window().maximize();
    }

    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
    }
}
