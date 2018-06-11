package litecart.tests;


import litecart.pages.AdminDeleteUser;
import litecart.util.Dataproviders;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AdminCustomerTest extends BaseTest {
    public AdminCustomerTest() throws MalformedURLException {
    }

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void init(@Optional("chrome") String browser){
        setupBrowser(browser);
    }

    @BeforeMethod
    public void openPage(){
        AdminDeleteUser logIn = new AdminDeleteUser(driver);
        logIn.openDeleteUser().sighIn();
    }


    @Test(dataProvider = "createCustomer", dataProviderClass = Dataproviders.class)
    public void testCreateCustomer(String email_data, String domain, String password_key){
        AdminDeleteUser createCustomer = new AdminDeleteUser(driver);
        int rn = (int) (Math.random()*100);
        Assert.assertEquals(createCustomer.createUser(email_data+rn+domain, password_key), "×\n" +"Changes saved successfully");
    }

    @Test
    public void testDeleteUser(){
        AdminDeleteUser adminDeleteUser = new AdminDeleteUser(driver);
        Assert.assertEquals(adminDeleteUser.deleteUser(), "×\n" + "Changes saved successfully");
    }

    @Test
    public void testDisableUser(){
        AdminDeleteUser disableCustomer = new AdminDeleteUser(driver);
        int rn = (int) (Math.random()*100);
        disableCustomer.createUser("number"+rn+"@admin.com", "Password");
        Assert.assertEquals(disableCustomer.disableUser(), true);
    }

    @AfterMethod
    public void logOut(){
        AdminDeleteUser logOut = new AdminDeleteUser(driver);
        logOut.logOut();
    }


    @AfterClass
    public void close() {
        driver.quit();
    }
}

