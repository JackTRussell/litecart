package litecart.tests;


import litecart.pages.AdminDeleteUser;
import litecart.util.Dataproviders;
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
        AdminDeleteUser openAdminPage = new AdminDeleteUser(driver);
        openAdminPage.openDeleteUser().sighIn();
    }

    @Test(dataProvider = "createCustomer", dataProviderClass = Dataproviders.class)
    public void testCreateCustomer(String email_data, String password_key){
        AdminDeleteUser createCustomer = new AdminDeleteUser(driver);
        //createCustomer.openDeleteUser();
        //createCustomer.sighIn();
        Assert.assertEquals(createCustomer.createUser(email_data, password_key), "×\n" + "Changes saved successfully");
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

