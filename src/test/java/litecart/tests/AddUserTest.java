package litecart.tests;

import litecart.pages.AddUser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AddUserTest extends BaseTest {

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

    }
    @Test
    public void testLoginLogout(){
        AddUser inOut = new AddUser(driver);
        //addUser.logIn();
        Assert.assertEquals(inOut.logIn(), "×\n" + "You are now logged in as Username UserLastname.");
        //addUser.logOut();
        Assert.assertEquals(inOut.logOut(), "×\n" + "You are now logged out.");
    }

     @Test
     public void testInvalidUser(){
        AddUser invalidUser = new AddUser(driver);
        Assert.assertEquals(invalidUser.invalidLogIn(), "×\n" + " Wrong password or the account does not exist");
     }

    @Test
    public void testSameUser(){
        AddUser sameUser = new AddUser(driver);
        Assert.assertEquals(sameUser.sameUser(), "×\n" + "The email address already exists in our customer database. Please login or select a different email address.");
    }



    @AfterClass
    public void close() {
        closeBrowser();
    }
    }


