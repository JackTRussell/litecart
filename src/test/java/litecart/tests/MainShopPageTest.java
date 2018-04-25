package litecart.tests;

import litecart.pages.MainShopPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MainShopPageTest extends BaseTest{

    public MainShopPageTest() throws MalformedURLException {
    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        setupBrowser();
    }

    @Test
    public void testAddYellowCardToShoppingCart() throws InterruptedException {
       Assert.assertEquals(
               new MainShopPage(driver)
                .openMainShopPage()
                .addYellowDuckToShippingCart().
                       closeFrame().
                       getQuantityProductsInShoppingCart(), "1");


    }
}
