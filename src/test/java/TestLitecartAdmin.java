import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLitecartAdmin {


    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

    }

    @Test
    public void testCanLoginAsAdmin(){
        open();
        login("admin", "admin");

    }

    @Test
    public void testCanSuccessfulLogout() throws InterruptedException {
        open();
        login("admin", "admin");
        Thread.sleep(2000);
        logout();
    }



    @Test
    public void testCheckAlertMessageForEmptyUserData() throws InterruptedException {
        open();
        String alertText;
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);
        alertText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(alertText,"×" + "\n" +"You must provide a username");


    }





    public void login(String username, String password){
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[type='submit']")).click();


    }

    public void logout(){
        driver.findElement(By.cssSelector(".fa.fa-sign-out.fa-lg")).click();
    }

    public void open(){
        driver.get("http://localhost/litecart/admin");
    }
}
