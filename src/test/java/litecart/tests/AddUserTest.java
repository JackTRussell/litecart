package litecart.tests;

import litecart.pages.AddUser;
import litecart.util.Dataproviders;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AddUserTest extends BaseTest {

    public AddUserTest() throws MalformedURLException {
    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        setupBrowser();
    }

    @Test(dataProvider = "createUser", dataProviderClass = Dataproviders.class)
    public void testAddName(String email_adress, String password_key) {
        AddUser addUser = new AddUser(driver);
        addUser.openAddUser();
        Assert.assertEquals(addUser.createUser(email_adress, password_key),"×\n" + "Your customer account has been created.");
        addUser.logOut();

    }
    @Test(dataProvider = "createUser", dataProviderClass = Dataproviders.class)
    public void testLoginLogout(String email_adress, String password_key){
        AddUser inOut = new AddUser(driver);
        Assert.assertEquals(inOut.logIn(email_adress, password_key), "×\n" + "You are now logged in as Username UserLastname.");
        Assert.assertEquals(inOut.logOut(), "×\n" + "You are now logged out.");

    }

     @Test
     public void testInvalidUser(){
        AddUser invalidUser = new AddUser(driver);
        Assert.assertEquals(invalidUser.logIn("trdt@fhd.com", "jgjfdyt"), "×\n" +"Wrong password or the account does not exist");
     }

    @Test(dataProvider = "createUser", dataProviderClass = Dataproviders.class)
    public void testSameUser(String email_adress, String password_key){
        AddUser sameUser = new AddUser(driver);
        Assert.assertEquals(sameUser.createUser(email_adress, password_key), "×\n" + "The email address already exists in our customer database. Please login or select a different email address.");
    }



    @AfterClass
    public void close() {
        closeBrowser();
    }
    }


