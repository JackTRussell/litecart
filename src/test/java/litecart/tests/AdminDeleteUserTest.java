package litecart.tests;

import litecart.pages.AdminDeleteUser;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AdminDeleteUserTest extends BaseTest {
    public AdminDeleteUserTest() throws MalformedURLException {
    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        setupBrowser();
    }
    @Test
    public void testDeleteUser(){
        AdminDeleteUser adminDeleteUser = new AdminDeleteUser(driver);
        adminDeleteUser.openDeleteUser();
        adminDeleteUser.sighIn();
        Assert.assertEquals(adminDeleteUser.deleteUser(), "×\n" + "Changes saved successfully.");
    }

    @AfterClass
    public void close() {
        closeBrowser();
    }
}

