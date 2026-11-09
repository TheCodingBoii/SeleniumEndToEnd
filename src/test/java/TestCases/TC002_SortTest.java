package TestCases;

import Base.BaseClass;
import Pages.LoginPage;
import Pages.ProductItemPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002_SortTest extends BaseClass {

    LoginPage loginPage;
    ProductItemPage productItemPage;
    private static final Logger logger = LogManager.getLogger(TC002_SortTest.class);


    @BeforeMethod
    public void beforeSort(){
        this.loginPage =new LoginPage(driver);
        this.productItemPage = new ProductItemPage(driver);

    }
    @Test
    public void sortTest(){

        logger.debug("debug TC002_SortTest");
        logger.info("***Starting TC002_SortTest***");
        loginPage.LoginPageActions(getAdminUsername(),getAdminPassword());
        productItemPage.dropDownSortAction();

        logger.info("Verifying Product are sort based on the option selected in the sort feature");


        String firstItem =productItemPage.productCount_ele2.get(0).getText();
        String lastItem =productItemPage.productCount_ele2.get(productItemPage.productCount_ele2.size()-1).getText();

        logger.info("Verifying the first product name to check sorted functionality is working as expected ");
        Assert.assertEquals(
                firstItem,
                "Test.allTheThings() T-Shirt (Red)"
        );

        logger.info("Verifying the last product name to check sorted functionality is working as expected ");

        Assert.assertEquals(
                lastItem,
                "Sauce Labs Backpack"
        );


    }
}
