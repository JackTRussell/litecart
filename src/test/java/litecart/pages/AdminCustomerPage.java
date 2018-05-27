package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminCustomerPage extends BasePage {
    public AdminCustomerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"box-login\"]/form/div[1]/div[1]/div/input")
    private WebElement name;

    @FindBy (xpath = "//*[@id=\"box-login\"]/form/div[1]/div[2]/div/input")
    private WebElement password;

    @FindBy (xpath = "//*[@id=\"box-login\"]/form/div[2]/button")
    private WebElement login;

    @FindBy (xpath = ".//*[@id='main']//td[4]/a")
    private WebElement customer;

    @FindBy (css = ".fa.fa-pencil")
    private WebElement edit;

    @FindBy (name = "delete")
    private WebElement delete;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    public AdminCustomerPage openDeleteUser() {
        driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");
        return this;
    }

    public AdminCustomerPage sighIn() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(name));
        name.sendKeys("admin");
        password.sendKeys("admin");
        login.click();
        return this;
    }

    public String deleteUser() {
        while (customer != null) {
            wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(edit));
            edit.click();
            delete.click();
            driver.switchTo().alert().accept();
            wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(alertMessage));

        }

        return alertMessage.getText();
    }
}
