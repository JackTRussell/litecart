package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class AdminDeleteUser  extends BasePage {
    String mail_adress = "tearsdown@gu.com";
    public AdminDeleteUser(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //@FindBy( name = mail_adress)
    //private WebElement customers;

    @FindBy (name = "username")
    private WebElement name;

    @FindBy (name = "password")
    private WebElement password;

    @FindBy (name = "login")
    private WebElement login;

    @FindBy (css = "i.fa.fa-pencil")
    private WebElement edit;

    @FindBy (name = "delete")
    private WebElement delete;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    public AdminDeleteUser openDeleteUser() {
        driver.get("http://localhost/litecart/admin/login.php");
        return this;
    }

    public AdminDeleteUser sighIn() {
        wait = new WebDriverWait(driver, 3);
        name.sendKeys("admin");
        password.sendKeys("admin");
        login.click();
        return this;
    }

    public String deleteUser() {
        wait = new WebDriverWait(driver, 3);
        edit.click();
        delete.click();
        driver.switchTo().alert().sendKeys(String.valueOf(Keys.ENTER));
        return alertMessage.getText();

    }
}
