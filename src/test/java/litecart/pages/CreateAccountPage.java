package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='box-create-account']//div[6]/div[1]//input")
    private WebElement createEmail;

    @FindBy(xpath = "//*[@id='box-create-account']//div[7]/div[1]//input")
    private WebElement createPassword;

    @FindBy(name = "confirmed_password")
    private WebElement confirmPassword;

    @FindBy(name = "create_account")
    private WebElement submitButton;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    public String createUser(String email_adress, String password_key) {
        wait = new WebDriverWait(driver, 3);
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        createEmail.sendKeys(email_adress);
        createPassword.sendKeys(password_key);
        confirmPassword.sendKeys(password_key);
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();

    }

    public String emptyUser() {
        wait = new WebDriverWait(driver, 15);
        submitButton.click();
        return driver.getCurrentUrl();
    }

    public CreateAccountPage createUserByEnter(String email_adress, String password_key) {
        wait = new WebDriverWait(driver, 15);
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        createEmail.sendKeys(email_adress);
        createPassword.sendKeys(password_key);
        confirmPassword.sendKeys(password_key);
        confirmPassword.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
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
    }

