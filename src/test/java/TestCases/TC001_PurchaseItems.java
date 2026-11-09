package TestCases;

import Base.BaseClass;
import Pages.CartPage;
import Pages.CeckoutPage;
import Pages.ProductItemPage;
import Pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001_PurchaseItems extends BaseClass {

    LoginPage loginPage;
    ProductItemPage productItemPage;
    CartPage cartPage;
    CeckoutPage ceckoutPage;
    private static final Logger logger = LogManager.getLogger(TC001_PurchaseItems.class);


    @BeforeMethod
    public void purchaceItem(){
        this.loginPage=new LoginPage(driver);
        this.productItemPage= new ProductItemPage(driver);
        this.cartPage= new CartPage(driver);
        this.ceckoutPage = new CeckoutPage(driver);
    }


    @Test
    public void PurchaseItemTest(){

        logger.debug("debug TC001_PurchaseItems");
        logger.info("***Starting TC001_PurchaseItems***");

        logger.info("Verifying Product List page is working as expected");
        logger.info("Verifying User can Log in successfully");
        loginPage.LoginPageActions(getAdminUsername(),getAdminPassword());
        productItemPage.ProductItemActions(prop.getProperty("item_Name"));
        cartPage.cartPageAction(prop.getProperty("item_Name"));

        String actualTitle =cartPage.getCheckoutPageTitle();

        logger.info("Verifying user redirected to the checkout page");
        String expectedTitle = "Checkout: Your Information";

        Assert.assertEquals(
                actualTitle,
                expectedTitle,
                "Checkout page title is incorrect"
        );

        ceckoutPage.CheckoutAction();

        logger.info("Verifying Order has successfully placed");

        String actualText =ceckoutPage.OrderSuccessText();

        String expectedText ="Thank you for your order!";

        Assert.assertEquals(actualText,
                expectedText,
                "Order is not successfull");





    }
}
