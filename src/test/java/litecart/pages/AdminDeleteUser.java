package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminDeleteUser  extends BasePage {
    public AdminDeleteUser(WebDriver driver) {
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

    @FindBy (xpath = "//*[contains(text(),(Customers)')]")
    private WebElement customer;

    @FindBy (css = ".fa.fa-pencil")
    private WebElement edit;

    @FindBy (name = "delete")
    private WebElement delete;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    public AdminDeleteUser openDeleteUser() {
        driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");
        return this;
    }

    public AdminDeleteUser sighIn() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(name));
        name.sendKeys("admin");
        password.sendKeys("admin");
        login.click();
        return this;
    }

    public String deleteUser() {
        //for (int i =0; i<38; i++) {
            wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(edit));
            edit.click();
            delete.click();
            driver.switchTo().alert().accept();
       // }
            return alertMessage.getText();


    }
}
