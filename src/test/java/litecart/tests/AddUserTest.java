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

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void init(@Optional("chrome") String browser){
        setupBrowser(browser);
    }

    @BeforeMethod
    public void openPage(){
        MainPage logIn = new MainPage(driver);
        logIn.openAddUser();
    }

    @Test(dataProvider = "loginData", dataProviderClass = Dataproviders.class)
    public void testAddName(String email_adress, String password_key) {
        MainPage signIn = new MainPage(driver);
        signIn.createAccount();
        CreateAccountPage addUser = new CreateAccountPage(driver);
        int rn = (int) (Math.random()*100);
        addUser.createUser(email_adress+rn, password_key);
        signIn.logOut();
        signIn.openAddUser();
    }
    @Test
    public void testLoginLogout(){
        MainPage inOut = new MainPage(driver);
        inOut.createAccount();
        int rn = (int) (Math.random()*100);
        CreateAccountPage addUser = new CreateAccountPage(driver);
        addUser.createUser("logout"+rn+"@user.com", "Password");
        Assert.assertEquals(inOut.logOut(), "×\n" + "You are now logged out.");
        Assert.assertEquals(inOut.logIn("logout"+rn+"@user.com", "Password"), "×\n" + "You are now logged in as Username UserLastname.");
        inOut.logOut();
        inOut.openAddUser();

    }

     @Test
     public void testInvalidUser(){
        MainPage invalidUser = new MainPage(driver);
        Assert.assertEquals(invalidUser.logIn("trdt@fhd.com", "jgjfdyt"), "×\n" +"Wrong password or the account does not exist");
        invalidUser.openAddUser();
     }

    @Test
    public void testSameUser(){
        MainPage sameUser = new MainPage(driver);
        sameUser.createAccount();
        CreateAccountPage createUser = new CreateAccountPage(driver);
        int rn = (int) (Math.random()*100);
        createUser.createUser("sameuser"+rn+"@user.com", "Password");
        sameUser.logOut();
        sameUser.openAddUser().createAccount();
        //Assert.assertEquals(createUser.createUser("sameuser"+rn+"@user.com", "Password"), "×\n" + "The email address already exists in our customer database. Please login or select a different email address.");
        createUser.createUser("sameuser"+rn+"@user.com", "Password");
        sameUser.openAddUser();
    }

    @Test
    public void testCreateEmptyUser(){
        MainPage emptyUser = new MainPage(driver);
        emptyUser.createAccount();
        CreateAccountPage createUser = new CreateAccountPage(driver);
        Assert.assertEquals(createUser.emptyUser(), "http://localhost:1234/litecart/en/create_account");
        emptyUser.openAddUser();
    }

    @Test
    public void testLoginEmptyUser(){
        MainPage  emptyUser = new MainPage(driver);
        Assert.assertEquals(emptyUser.logInEmpty(), "http://localhost:1234/litecart/en/");
        emptyUser.openAddUser();
    }

    @Test
    public void testCreateUserWithInvalidEmail(){
        MainPage signIn = new MainPage(driver);
        signIn.createAccount();
        CreateAccountPage addUser = new CreateAccountPage(driver);
        Assert.assertEquals(addUser.createUserWithInvalidEmail("qwerty", "Password"),"http://localhost:1234/litecart/en/create_account");
        signIn.openAddUser();
    }

    @Test
    public void testCreateByEnter(){
        MainPage signIn = new MainPage(driver);
        signIn.createAccount();
        CreateAccountPage addUser = new CreateAccountPage(driver);
        int rn = (int) (Math.random()*100);
        //assertEquals(addUser.createUserByEnter("number8@user.com", "password"), "Your customer account has been created successfully");
        addUser.createUserByEnter("number"+rn+"7@user.com", "password");
        signIn.logOut();
        signIn.openAddUser();

    }


   @AfterClass
    public void close() {
        driver.quit();
    }
    }


