package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.XMLFormatter;


public class AdminDeleteUser extends BasePage {
    public AdminDeleteUser(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement name;

    @FindBy(name = "password")
    private WebElement adminPassword;

    @FindBy(css = ".btn.btn-default")
    private WebElement login;

    @FindBy(xpath = ".//*[@id='main']//td[4]/a")
    private WebElement customer;

    @FindBy(css = ".fa.fa-pencil")
    private WebElement edit;

    @FindBy(name = "delete")
    private WebElement delete;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    @FindBy(xpath = ".//*[@id='main']//li[2]/a")
    private WebElement addCustomer;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "new_password")
    private WebElement password;

    @FindBy(name = "save")
    private WebElement saveButton;

    @FindBy (xpath = "//*[@id='main']//tr[1]/td[1]/input")
    private WebElement checkbox;

    @FindBy (name = "disable")
    private WebElement disableButton;

    @FindBy (xpath = ".//*[@id='main']//tr[@class='semi-transparent']")
    private WebElement disabledRow;

    @FindBy (css = ".fa.fa-sign-out.fa-lg")
    private WebElement logout;

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
        for (int i = 0; i < 5; i++) {
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

    public boolean disableUser(){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();
        disableButton.click();;
        return disabledRow.isDisplayed();
    }

    public AdminDeleteUser logOut(){
        logout.click();
        return this;
    }
}

