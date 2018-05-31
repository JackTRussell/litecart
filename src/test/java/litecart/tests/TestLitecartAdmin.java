package litecart.tests;

import litecart.pages.AdminPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestLitecartAdmin extends BaseTest{


    public TestLitecartAdmin() throws MalformedURLException {
    }

    @BeforeClass
    public void setup() throws Exception {
        setupBrowser("Chrome");
    }

    @BeforeMethod
    public void openAdminPage(){
        open();
    }

    @Test
    public void testCanLoginAsAdmin(){
        AdminPage adminPage = new AdminPage(driver);
        adminPage.login("admin", "admin");

    }

    @Test
    public void testCanSuccessfulLogout(){
        AdminPage adminPage = new AdminPage(driver);
        adminPage.login("admin", "admin").logout();
    }



    @Test
    public void testCheckAlertMessageForEmptyUserData() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        String alertText;

        alertText = adminPage.getAlertText();
        Assert.assertEquals(alertText,"×" + "\n" +"You must provide a username");


    }

    public void open(){
        driver.get("http://localhost/Litecart/admin");
    }

    @AfterClass
    public void close(){
        closeBrowser();
    }
}
