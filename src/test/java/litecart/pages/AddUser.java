package litecart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUser extends BasePage{
    String email_adress = "tearsdown@gu.com";
    String password_key = "Pa$$w0rd";
    public AddUser(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".fa.fa-user")
    private WebElement signIn;

    @FindBy (linkText = "New customers click here")
    private WebElement createNewAccount;

    @FindBy (linkText = "Logout")
    private WebElement logout;

    @FindBy (name = "firstname")
    private WebElement firstName;


    @FindBy (name = "lastname")
    private WebElement lastName;

    /*@FindBy (name = "country_code")
    private WebElement country;

    @FindBy (name = "zone_code")
    private WebElement zone;*/

    @FindBy (xpath = "//*[@id=\"box-create-account\"]/form/div[6]/div[1]/div/input")
    private WebElement createEmail;

    @FindBy (xpath = "//*[@id=\"box-create-account\"]/form/div[7]/div[1]/div/input")
    private WebElement createPassword;

    @FindBy (xpath = "//*[@id=\"box-create-account\"]/form/div[7]/div[2]/div/input")
    private WebElement confirmPassword;

    @FindBy (name = "create_account")
    private WebElement submitButton;

    @FindBy (css = ".fa.fa-user")
    private WebElement userName;

    @FindBy (css = ".alert.alert-success")
    private WebElement alertMessage;

    @FindBy (xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[1]/form/div[1]/div/input")
    private WebElement email;

    @FindBy (xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[1]/form/div[2]/div/input")
    private WebElement password;

    @FindBy (xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[1]/form/div[3]/button")
    private WebElement signInButton;

    @FindBy (css = ".alert.alert-danger")
    private WebElement errorAlert;

    public AddUser openAddUser(){
        driver.get("http://localhost/litecart/en/");
        return this;
    }

    public String createUser(){

        wait = new WebDriverWait(driver, 3);
        signIn.click();
        createNewAccount.click();
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        //wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(createEmail));
        createEmail.sendKeys(email_adress);
        createPassword.sendKeys(password_key);
        confirmPassword.sendKeys(password_key);
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();

    }
   public String logOut() {
       wait = new WebDriverWait(driver, 10);
       userName.click();
       logout.click();
       return alertMessage.getText();
   }

    public String logIn(){
        wait = new WebDriverWait(driver, 10);
        signIn.click();
        email.sendKeys(email_adress);
        password.sendKeys(password_key);
        signInButton.click();
        return alertMessage.getText();
    }
    public String sameUser(){
        wait = new WebDriverWait(driver, 3);
        signIn.click();
        createNewAccount.click();
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        //((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        //wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(createEmail));
        createEmail.sendKeys(email_adress);
        createPassword.sendKeys(password_key);
        confirmPassword.sendKeys(password_key);
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorAlert));
        return errorAlert.getText();
    }


}
