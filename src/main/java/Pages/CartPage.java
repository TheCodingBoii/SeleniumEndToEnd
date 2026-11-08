package Pages;

import ActionDriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExtentReport.ExtentReportUtility;

import java.util.List;

public class CartPage {
    WebDriver driver;
    private ActionDriver actionDriver;

    public  CartPage(WebDriver driver){
        this.driver=driver;
        this.actionDriver= new ActionDriver(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id='shopping_cart_container']/a")
    public WebElement cartButton;

    @FindBy (xpath = "//div[@class='cart_item_label']//a/div")
    public List<WebElement> cartItem_ele;

    @FindBy(id = "checkout")
    public WebElement checkOut_ele;

    @FindBy(className = "title")
    WebElement checkoutPageTitle;

    public void cartPageAction(String itemTitle){
        String attributeValue =cartButton.getAttribute("aria-label");
        System.out.println(attributeValue);

        if(!attributeValue.contains("empty")){
            cartButton.click();
        }
        ExtentReportUtility.captureScreenshotAsBase64_ReportOnly_StepInfo(driver,"Product in Cart Page");

        for(WebElement crtItem:cartItem_ele){
            String item =crtItem.getText();
            if(item.contains(itemTitle)){
                clickCheckoutButton();
            }
        }






    }
    public void clickCheckoutButton() {

        checkOut_ele.click();
    }

    public String getCheckoutPageTitle() {

        return checkoutPageTitle.getText();
    }
}
