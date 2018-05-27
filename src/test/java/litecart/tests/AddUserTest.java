package litecart.tests;

import litecart.pages.CreateAccountPage;
import litecart.pages.MainPage;
import litecart.util.Dataproviders;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AddUserTest extends BaseTest {

    public AddUserTest() throws MalformedURLException {
    }
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
    }

    /*@BeforeClass
    public void setup() throws MalformedURLException {
        setupBrowser();
    }*/

    @Test(dataProvider = "loginData", dataProviderClass = Dataproviders.class)
    public void testAddName(String email_adress, String password_key) {
        MainPage signIn = new MainPage(driver);
        signIn.openAddUser();
        CreateAccountPage addUser = new CreateAccountPage(driver);
        Assert.assertEquals(addUser.createUser(email_adress, password_key),"×\n" + "Your customer account has been created.");
        signIn.logOut();

    }
    @Test(dataProvider = "loginData", dataProviderClass = Dataproviders.class)
    public void testLoginLogout(String email_adress, String password_key){
        MainPage inOut = new MainPage(driver);
        Assert.assertEquals(inOut.logIn(email_adress, password_key), "×\n" + "You are now logged in as Username UserLastname.");
        Assert.assertEquals(inOut.logOut(), "×\n" + "You are now logged out.");

    }

     @Test
     public void testInvalidUser(){
        MainPage invalidUser = new MainPage(driver);
        invalidUser.openAddUser();
        Assert.assertEquals(invalidUser.logIn("trdt@fhd.com", "jgjfdyt"), "×\n" +"Wrong password or the account does not exist");
     }

    @Test(dataProvider = "loginData", dataProviderClass = Dataproviders.class)
    public void testSameUser(String email_adress, String password_key){
        MainPage sameUser = new MainPage(driver);
        CreateAccountPage createUser = new CreateAccountPage(driver);
        sameUser.openAddUser();
        Assert.assertEquals(createUser.createUser(email_adress, password_key), "×\n" + "The email address already exists in our customer database. Please login or select a different email address.");
    }



    //@AfterClass
    //public void close() {driver.quit();    }
    }


