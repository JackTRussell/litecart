package litecart.pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUser extends BasePage{

    public AddUser(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".fa.fa-user")
    private WebElement signIn;

    @FindBy (linkText = "New customers click here")
    private WebElement createNewAccount;

    @FindBy (name = "firstname")
    private WebElement firstName;


    @FindBy (name = "lastname")
    private WebElement lastName;

    @FindBy (name = "country_code")
    private WebElement country;

    @FindBy (name = "zone_code")
    private WebElement zone;

    @FindBy (name = "email")
    private WebElement email;

    @FindBy (name = "password")
    private WebElement password;

    @FindBy (name = "confirm_password")
    private WebElement confirmPassword;

    @FindBy (name = "create_account")
    private WebElement submitButton;

    @FindBy (css = ".fa.fa-user")
    private WebElement userName;

    public AddUser openAddUser(){
        driver.get("http://localhost/litecart/en/");
        return this;
    }

    public String createUser(){
        wait = new WebDriverWait(driver, 3);
        signIn.click();
        wait = new WebDriverWait(driver, 3);
        createNewAccount.click();
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        wait = new WebDriverWait(driver, 15);
        country.clear();
        country.sendKeys("United States");
        zone.sendKeys("Alabama");
        //((JavascriptExecutor)driver).executeScript("scroll(0,250");
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("qwerty@com.com");
        password.sendKeys("Pa$$w0rd");
        confirmPassword.sendKeys("Pa$$w0rd");
        submitButton.click();

        return userName.getText();
    }




}