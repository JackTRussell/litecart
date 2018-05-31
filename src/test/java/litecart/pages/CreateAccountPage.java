package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class CreateAccountPage extends BasePage {
    String email_adress = "tugfbdtc436@gwlr.com";
    String password_key = "Pa$$w0rd";

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"box-create-account\"]/form/div[6]/div[1]/div/input")
    private WebElement createEmail;

    @FindBy(xpath = "//*[@id=\"box-create-account\"]/form/div[7]/div[1]/div/input")
    private WebElement createPassword;

    @FindBy(xpath = "//*[@id=\"box-create-account\"]/form/div[7]/div[2]/div/input")
    private WebElement confirmPassword;

    @FindBy(name = "create_account")
    private WebElement submitButton;

    public CreateAccountPage createUser(String email_adress, String password_key) {
        wait = new WebDriverWait(driver, 3);
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        createEmail.sendKeys(email_adress);
        createPassword.sendKeys(password_key);
        confirmPassword.sendKeys(password_key);
        submitButton.click();
        //wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return this;

    }

    public String emptyUser() {
        wait = new WebDriverWait(driver, 15);
        submitButton.click();
        //wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return driver.getCurrentUrl();
    }

    public CreateAccountPage createUserByEnter(String email_adress, String password_key) {
        wait = new WebDriverWait(driver, 3);
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        createEmail.sendKeys(email_adress);
        createPassword.sendKeys(password_key);
        confirmPassword.sendKeys(password_key);
        confirmPassword.sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return this;

    }

    public String createUserWithInvalidEmail(String email_adress, String password_key) {
        wait = new WebDriverWait(driver, 3);
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        createEmail.sendKeys(email_adress);
        createPassword.sendKeys(password_key);
        confirmPassword.sendKeys(password_key);
        submitButton.click();
        return driver.getCurrentUrl();

    }


    /*public String invalidLogIn() {
        wait = new WebDriverWait(driver, 10);
        signIn.click();
        email.clear();
        email.sendKeys(email_adress + "erty");
        password.sendKeys(password_key + "fgh");
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorAlert));
        return errorAlert.getText();*/


    }

