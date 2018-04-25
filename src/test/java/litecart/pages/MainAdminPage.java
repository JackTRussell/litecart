package litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainAdminPage extends BasePage{

    WebDriver driver;

    public MainAdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".fa.fa-sign-out.fa-lg")
    private WebElement logoutButton;

    @FindBy(css = ".fa.fa-database")
    private WebElement databaseButton;

    public void logout(){

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }

}
