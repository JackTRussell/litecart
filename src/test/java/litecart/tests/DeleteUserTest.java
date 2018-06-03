package litecart.tests;


import litecart.pages.AdminDeleteUser;
import litecart.util.Dataproviders;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class DeleteUserTest extends BaseTest {
    public DeleteUserTest() throws MalformedURLException {
    }

    @BeforeClass
    public void setup() throws Exception {
        setupBrowser("Chrome");
        AdminDeleteUser openAdminPage = new AdminDeleteUser(driver);
        openAdminPage.openDeleteUser().sighIn();
    }

    @Test(dataProvider = "createCustomer", dataProviderClass = Dataproviders.class)
    public void testCreateCustomer(String email_data, String domain, String password_key){
        AdminDeleteUser createCustomer = new AdminDeleteUser(driver);
        //createCustomer.openDeleteUser();
        //createCustomer.sighIn();
        int rn = (int) (Math.random()*100);
        Assert.assertEquals(createCustomer.createUser(email_data+rn+domain, password_key), "×\n" + "Changes saved successfully");
    }

    @Test
    public void testDeleteUser(){
        AdminDeleteUser adminDeleteUser = new AdminDeleteUser(driver);
        //adminDeleteUser.openDeleteUser();
        //adminDeleteUser.sighIn();
        Assert.assertEquals(adminDeleteUser.deleteUser(), "×\n" + "Changes saved successfully");
    }

    @Test
    public void testDisableUser(){
        AdminDeleteUser disableCustomer = new AdminDeleteUser(driver);
        int rn = (int) (Math.random()*100);
        disableCustomer.createUser("number"+rn+"@admin.com", "Password");
        Assert.assertEquals(disableCustomer.disableUser(), true);
    }


    @AfterClass
    public void close() {
        driver.quit();
    }
}

