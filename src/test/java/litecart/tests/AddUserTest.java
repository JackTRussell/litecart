package litecart.tests;

import litecart.pages.AddUser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
    public void testAddName() throws InterruptedException {
        AddUser addUser = new AddUser(driver);
        addUser.createUser();

        /*alertText = addUser.getAlertText();
        Assert.assertEquals(alertText,"×" + "\n" +"You must provide a username");*/


    }
}
