package litecart.tests;


import litecart.pages.AdminDeleteUser;
import litecart.util.Dataproviders;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import static java.lang.System.currentTimeMillis;

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


    @Test
    public void testCreateCustomer(){
        String email_data = "user_mail";
        String domain = "@admin.com";
        String password_key = "P@$$w0rd";
        AdminDeleteUser createCustomer = new AdminDeleteUser(driver);
        int i;
        for (i=0; i<5; i++){
        long rn = (int) currentTimeMillis();
        Assert.assertEquals(createCustomer.createUser(email_data+rn+domain, password_key), String.format("×\nChanges saved successfully"));
        }
    }

    @Test
    public void testDeleteUser(){
        AdminDeleteUser adminDeleteUser = new AdminDeleteUser(driver);
        Assert.assertEquals(adminDeleteUser.deleteUser(), "×\n" + "Changes saved successfully");
    }

    @Test
    public void testDisableUser(){
        AdminDeleteUser disableCustomer = new AdminDeleteUser(driver);
        long rn = (int) currentTimeMillis();
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

