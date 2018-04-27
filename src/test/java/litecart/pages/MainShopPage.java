package litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainShopPage extends BasePage{


    public MainShopPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "img[title='My Store']")
    private WebElement logotype;

    @FindBy (css = "[name='query']")
    private  WebElement searchInput;


    @FindBy (partialLinkText = "rubber-ducks-c-1" )
    private WebElement dropDownToggleRubberDucks;

    @FindBy (css = ".manufacturers.dropdown")
    private WebElement manufacturesDropdownToggle;

    @FindBy (css = ".item.active img")
    private WebElement mainImg;

    @FindBy (xpath = "//a[text() = 'Popular Products']")
    private WebElement popularProductsTab;

    @FindBy (xpath = "//a[text() = 'Campaign Products']")
    private WebElement campaignProductsTab;

    @FindBy (xpath = "//a[text() = 'Latest Products']")
    private WebElement latestProductsTab;

    @FindBy (css = "#campaign-products img[alt='Yellow Duck']")
    private WebElement campainProductYellowDuck;

    @FindBy (css = ".featherlight-content")
    private WebElement frameWithDuck;

    @FindBy (css = "[aria-label='Close']")
    private WebElement closeFrame;

    @FindBy (css = "select.form-control[required='required']")
    private WebElement selectDuckSize;

    @FindBy (css = "button[name='add_cart_product']")
    private WebElement addToCartButton;

    @FindBy (id = "cart")
    private WebElement shippingCart;

    @FindBy (css = ".quantity")
    private WebElement quantityProductsInShoppingCart;



    public MainShopPage openMainShopPage(){
        driver.get("http://localhost/Litecart/en/");
        return this;
    }

    public String getQuantityProductsInShoppingCart() throws InterruptedException {
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(shippingCart));
        return quantityProductsInShoppingCart.getText();
    }


    public MainShopPage addYellowDuckToShippingCart() throws InterruptedException {
        campainProductYellowDuck.click();
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(frameWithDuck));
        Select selectSize = new Select(selectDuckSize);
        selectSize.selectByVisibleText("Small");
        addToCartButton.click();
        return this;
    }

    public MainShopPage closeFrame(){
        closeFrame.click();
        return this;
    }













}

