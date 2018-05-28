package litecart.tests;


import litecart.pages.AdminCustomerPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AdminDeleteUserTest extends BaseTest {
    public AdminDeleteUserTest() throws MalformedURLException {
    }
    /*@BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
    }*/

    @BeforeClass
    public void setup() throws MalformedURLException {
        setupBrowser();
    }
    @Test
    public void testDeleteUser(){
        AdminCustomerPage adminDeleteUser = new AdminCustomerPage(driver);
        adminDeleteUser.openDeleteUser();
        adminDeleteUser.sighIn();
        Assert.assertEquals(adminDeleteUser.deleteUser(), "×\n" + "Changes saved successfully");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}

