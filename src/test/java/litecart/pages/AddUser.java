package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUser extends BasePage{

    public AddUser(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "account.dropdown")
    private WebElement signIn;

    @FindBy (linkText = "http://localhost/litecart/en/create_account")
    private WebElement createNewAccount;

    @FindBy (name = "firstname")
    private WebElement firstName;


    @FindBy (name = "lastname")
    private WebElement lastName;

    @FindBy (name = "country_code")
    private WebElement country;

    @FindBy (name = "zone_code")
    private WebElement state;

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


    public String createUser(){
        signIn.click();
        createNewAccount.click();
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        country.sendKeys("United States");
        email.sendKeys("qwerty@com.com");
        password.sendKeys("Pa$$w0rd");
        confirmPassword.sendKeys("Pa$$w0rd");
        submitButton.click();

        return userName.getText();
    }




}