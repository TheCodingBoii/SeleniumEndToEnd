package Pages;

import ActionDriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseItemPage {

    WebDriver driver;
    private ActionDriver actionDriver;

    public PurchaseItemPage(WebDriver driver){
        this.driver=driver;
        this.actionDriver=new ActionDriver(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    public WebElement userName_ele;
    @FindBy(id = "password")
    public WebElement password_ele;
    @FindBy(id = "login-button")
    public WebElement loginButton_ele;

    public void PurchaseItemActions(String username,String password){
        actionDriver.click(userName_ele);
        userName_ele.sendKeys(username);

        actionDriver.click(password_ele);
        password_ele.sendKeys(password);

        actionDriver.click(loginButton_ele);


    }
}
