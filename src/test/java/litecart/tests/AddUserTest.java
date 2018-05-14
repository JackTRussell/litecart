package litecart.tests;

import litecart.pages.AddUser;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AddUserTest extends BaseTest {

    /*public class userDataProvider{
        @DataProvider (name = "validUsersDataProvider")
        public Object [][] validUsersDataProvider(){
            return new Object [][]
            {["qwerty987@ter.com"] ["password"]}
        }
    }*/

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
        Assert.assertEquals(addUser.createUser("qwerty987456@edrtfy.vh", "12345678"),"×\n" + "Your customer account has been created.");
        addUser.logOut();

    }
    @Test
    public void testLoginLogout(){
        AddUser inOut = new AddUser(driver);
        Assert.assertEquals(inOut.logIn("qwerty987456@edrtfy.vh", "12345678"), "×\n" + "You are now logged in as Username UserLastname.");
        Assert.assertEquals(inOut.logOut(), "×\n" + "You are now logged out.");

    }

     @Test
     public void testInvalidUser(){
        AddUser invalidUser = new AddUser(driver);
        Assert.assertEquals(invalidUser.logIn("trdt@fhd.com", "jgjfdyt"), "×\n" +"Wrong password or the account does not exist");
     }

    @Test
    public void testSameUser(){
        AddUser sameUser = new AddUser(driver);
        Assert.assertEquals(sameUser.createUser("qwerty987456@edrtfy.vh", "Pa$$w0rd"), "×\n" + "The email address already exists in our customer database. Please login or select a different email address.");
    }



    @AfterClass
    public void close() {
        closeBrowser();
    }
    }


