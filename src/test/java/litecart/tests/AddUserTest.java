package litecart.tests;

import litecart.pages.AddUser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AddUserTest extends BaseTest{

    public AddUserTest() throws MalformedURLException {
    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        setupBrowser();
    }

    @Test
    public void testAddName() {
        AddUser addUser = new AddUser(driver);
        addUser.openAddUser();
        //addUser.createUser();

        Assert.assertEquals(addUser.createUser(),"×\n" + "Your customer account has been created.");
    }
    @AfterClass
    public void close() {
        closeBrowser();
    }
    }

