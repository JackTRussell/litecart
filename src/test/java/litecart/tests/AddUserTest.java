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
    public void testAddName() {
        AddUser addUser = new AddUser(driver);
        addUser.createUser();

        Assert.assertEquals(addUser.createUser()," Your customer account has been created.");


    }
    public void open(){
        driver.get("http://localhost/litecart/en/");
    }
}