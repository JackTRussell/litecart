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

    @FindBy (css =".logotype")
    public WebElement logo;

    @FindBy (css = ".fa.fa-home")
    private WebElement homeButton;

    @FindBy (xpath = "//*[@id='default-menu']/ul[1]/li[2]/a")
    private WebElement ruberDuckDropdown;

    @FindBy (xpath = "//*[@id='default-menu']/ul[1]/li[3]/a")
    private WebElement manufacturersDropdown;

    @FindBy (xpath = "//*[@id='default-menu']/ul[1]/li[2]/ul/li/a")
    private WebElement category;

    @FindBy (xpath = "//*[@id='default-menu']/ul[1]/li[3]/ul/li/a")
    private WebElement corpMenu;

    @FindBy(css = ".fa.fa-user")
    private WebElement signIn;

    @FindBy (css = ".details")
    private WebElement cartMenu;

    @FindBy(linkText = "New customers click here")
    private WebElement createNewAccount;

    @FindBy(linkText = "Logout")
    private WebElement logout;

    @FindBy(css = ".fa.fa-user")
    private WebElement userName;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement signInButton;

    public MainPage openAddUser() {
        driver.get("http://localhost:1234/litecart/en/");
        return this;
    }

    public MainPage createAccount() {
        wait = new WebDriverWait(driver, 5);
        signIn.click();
        wait.until(ExpectedConditions.visibilityOf(createNewAccount));
        createNewAccount.click();
        return this;
    };

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

    public String logInEmpty(){
        signIn.click();
        signInButton.click();
        return driver.getCurrentUrl();
    }

    public String getMenuElement(){
        ruberDuckDropdown.click();
        return category.getText();
    }

    public String homeButton(){
        homeButton.click();
        return driver.getCurrentUrl();
    }

    public String manufactures(){
        manufacturersDropdown.click();
        return corpMenu.getText();
    }

    public String shoppingCart(){
        cartMenu.click();
        return driver.getCurrentUrl();
    }

    public Boolean logotype(){
        return logo.isDisplayed();
    }

}
