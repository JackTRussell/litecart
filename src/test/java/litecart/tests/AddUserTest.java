package litecart.tests;

import litecart.pages.CreateAccountPage;
import litecart.pages.MainPage;
import litecart.util.Dataproviders;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AddUserTest extends BaseTest {

    public AddUserTest() throws MalformedURLException {
    }
    //@BeforeTest
   /* @Parameters("browser")
    public void setup(String browser) throws Exception{
        if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
    }*/

    @BeforeClass
    public void setup() throws MalformedURLException {
        setupBrowser();
        MainPage logIn = new MainPage(driver);
        logIn.openAddUser();
    }

    @Test(dataProvider = "loginData", dataProviderClass = Dataproviders.class)
    public void testAddName(String email_adress, String password_key) {
        MainPage signIn = new MainPage(driver);
        //signIn.openAddUser();
        signIn.createAccount();
        CreateAccountPage addUser = new CreateAccountPage(driver);
        addUser.createUser(email_adress, password_key);
        signIn.logOut();

    }
    @Test(dataProvider = "loginData", dataProviderClass = Dataproviders.class)
    public void testLoginLogout(String email_adress, String password_key){
        MainPage inOut = new MainPage(driver);
        inOut.openAddUser();
        Assert.assertEquals(inOut.logIn(email_adress, password_key), "×\n" + "You are now logged in as Username UserLastname.");
        Assert.assertEquals(inOut.logOut(), "×\n" + "You are now logged out.");

    }

     @Test
     public void testInvalidUser(){
        MainPage invalidUser = new MainPage(driver);
        //invalidUser.openAddUser();
        Assert.assertEquals(invalidUser.logIn("trdt@fhd.com", "jgjfdyt"), "×\n" +"Wrong password or the account does not exist");
     }

    @Test(dataProvider = "loginData", dataProviderClass = Dataproviders.class)
    public void testSameUser(String email_adress, String password_key){
        MainPage sameUser = new MainPage(driver);
        sameUser.createAccount();
        CreateAccountPage createUser = new CreateAccountPage(driver);
        //sameUser.openAddUser();
        Assert.assertEquals(createUser.createUser(email_adress, password_key), "×\n" + "The email address already exists in our customer database. Please login or select a different email address.");
    }

    @Test
    public void testCreateEmptyUser(){
        MainPage emptyUser = new MainPage(driver);
        //emptyUser.openAddUser();
        emptyUser.createAccount();
        CreateAccountPage createUser = new CreateAccountPage(driver);
        Assert.assertEquals(createUser.emptyUser(), "http://localhost:1234/litecart/en/create_account");
    }

    @Test
    public void testLoginEmptyUser(){
        MainPage  emptyUser = new MainPage(driver);
        emptyUser.openAddUser();
        Assert.assertEquals(emptyUser.logInEmpty(), "http://localhost:1234/litecart/en/");
    }

    @Test
    public void testCreateUserWithInvalidEmail(){
        MainPage signIn = new MainPage(driver);
        //signIn.openAddUser();
        signIn.createAccount();
        CreateAccountPage addUser = new CreateAccountPage(driver);
        Assert.assertEquals(addUser.createUserWithInvalidEmail("qwerty", "Password"),"http://localhost:1234/litecart/en/create_account");
    }

    @Test
    public void testCreateByEnter(){
        MainPage signIn = new MainPage(driver);
        //signIn.openAddUser();
        signIn.createAccount();
        CreateAccountPage addUser = new CreateAccountPage(driver);
        //assertEquals(addUser.createUserByEnter("number8@user.com", "password"), "Your customer account has been created successfully");
        addUser.createUserByEnter("number7@user.com", "password");
        signIn.logOut();

    }


   @AfterClass
    public void close() {
        driver.quit();
    }
    }


