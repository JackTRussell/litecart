package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminDeleteUser extends BasePage {
    public AdminDeleteUser(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"box-login\"]/form/div[1]/div[1]/div/input")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"box-login\"]/form/div[1]/div[2]/div/input")
    private WebElement adminPassword;

    @FindBy(xpath = "//*[@id=\"box-login\"]/form/div[2]/button")
    private WebElement login;

    @FindBy(xpath = ".//*[@id='main']//td[contains(text(), 'Customers: 0')]")
    private WebElement customers;

    @FindBy(xpath = ".//*[@id='main']//td[4]/a")
    private WebElement customer;

    @FindBy(css = ".fa.fa-pencil")
    private WebElement edit;

    @FindBy(name = "delete")
    private WebElement delete;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    @FindBy(xpath = ".//*[@id='main']/ul/li[2]/a")
    private WebElement addCustomer;

    @FindBy(xpath = "//*[@id=\"main\"]/form/div/div[1]/div[2]/div[1]/div/input")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"main\"]/form/div/div[1]/div[4]/div[1]/input")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"main\"]/form/div/div[1]/div[4]/div[2]/input")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"main\"]/form/div/div[1]/div[8]/div[2]/div/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"main\"]/form/div/div[1]/p/button[1]")
    private WebElement saveButton;

    public AdminDeleteUser openDeleteUser() {
        driver.get("http://localhost:1234/litecart/admin/?app=customers&doc=customers");
        return this;
    }

    public AdminDeleteUser sighIn() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(name));
        name.sendKeys("admin");
        adminPassword.sendKeys("admin");
        login.click();
        return this;
    }

    public String deleteUser() {
        for (int i = 0; i < 11; i++) {
            wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(edit));
            edit.click();
            delete.click();
            driver.switchTo().alert().accept();
            wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(alertMessage));

        }
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();

    }

    public AdminDeleteUser createUser(String email_adress, String password_key) {
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(addCustomer));
        addCustomer.click();
        firstName.sendKeys("Username");
        lastName.sendKeys("UserLastname");
        email.sendKeys(email_adress);
        password.sendKeys(password_key);
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return this;

    }
}

