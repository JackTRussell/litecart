package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"default-menu\"]/ul[2]/li/a/i")
    private WebElement signIn;

    @FindBy(linkText = "New customers click here")
    private WebElement createNewAccount;

    @FindBy(linkText = "Logout")
    private WebElement logout;
    @FindBy(css = ".fa.fa-user")
    private WebElement userName;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    @FindBy(xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[1]/form/div[1]/div/input")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[1]/form/div[2]/div/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[1]/form/div[3]/button")
    private WebElement signInButton;

    public MainPage openAddUser() {
        driver.get("http://localhost/litecart/en/");
        return this;
    }
    public MainPage sighIn() {
        wait = new WebDriverWait(driver, 3);
        signIn.click();
        signInButton.click();
        return this;
    }

    public String logOut() {
        wait = new WebDriverWait(driver, 10);
        userName.click();
        logout.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();
    }

    public String logIn(String email_adress, String password_key) {
        wait = new WebDriverWait(driver, 10);
        signIn.click();
        email.clear();
        email.sendKeys(email_adress);
        password.sendKeys(password_key);
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();
    }

}
