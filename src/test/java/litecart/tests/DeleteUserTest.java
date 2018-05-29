package litecart.tests;


import litecart.pages.AdminDeleteUser;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class DeleteUserTest extends BaseTest {
    public DeleteUserTest() throws MalformedURLException {
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
    public void testCreateCustomer(){
        AdminDeleteUser createCustomer = new AdminDeleteUser(driver);
        createCustomer.openDeleteUser();
        createCustomer.sighIn();
        Assert.assertEquals(createCustomer.createUser("number6@user.com", "Password"), "×\n" + "Changes saved successfully");
    }

    @Test
    public void testDeleteUser(){
        AdminDeleteUser adminDeleteUser = new AdminDeleteUser(driver);
        //adminDeleteUser.openDeleteUser();
        //adminDeleteUser.sighIn();
        Assert.assertEquals(adminDeleteUser.deleteUser(), "×\n" + "Changes saved successfully");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}

