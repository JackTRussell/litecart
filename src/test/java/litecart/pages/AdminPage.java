package litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".alert.alert-danger")
    private WebElement alertText;


    @FindBy(name = "username" )
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;




    public String getAlertText() {
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(alertText));
        return alertText.getText();
    }


    public MainAdminPage login(String username, String password){
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        return new MainAdminPage(driver);
    }
}
