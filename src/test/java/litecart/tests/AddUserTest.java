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
        addUser.logOut();
        //addUser.logIn();
        Assert.assertEquals(addUser.logIn(), "×\n" + "You are now logged in as Username UserLastname.");
        //addUser.logOut();
        Assert.assertEquals(addUser.logOut(), "×\n" + "You are now logged out.");
    }
    @AfterClass
    public void close() {
        closeBrowser();
    }
    }

