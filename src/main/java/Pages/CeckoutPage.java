package Pages;

import ActionDriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CeckoutPage {
    WebDriver driver;
    private ActionDriver actionDriver;

    public  CeckoutPage(WebDriver driver){
        this.driver=driver;
        this.actionDriver= new ActionDriver(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="first-name")
    public WebElement firstName_ele;

    @FindBy(id="last-name")
    public WebElement lastName_ele;

    @FindBy(id="postal-code")
    public WebElement zipCode_ele;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id="finish")
    public WebElement finishBtn;

    @FindBy(className = "complete-header")
    public WebElement orderSuccText_ele;



    public void CheckoutAction(){
        actionDriver.sendKeysWithActions(firstName_ele,"Kamal");
        actionDriver.sendKeysWithActions(lastName_ele,"Vimal");
        actionDriver.sendKeysWithActions(zipCode_ele,"2100");
        actionDriver.click(continueBtn);
        actionDriver.click(finishBtn);
    }

    public String OrderSuccessText(){
        return orderSuccText_ele.getText();
    }
}
