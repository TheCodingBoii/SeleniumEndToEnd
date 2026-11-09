package Pages;

import ActionDriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductItemPage {

    WebDriver driver;
    private ActionDriver actionDriver;

    public ProductItemPage(WebDriver driver){
        this.driver=driver;
        this.actionDriver=new ActionDriver(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class='inventory_item_name ']")
    public List<WebElement> productCount_ele;

    @FindBy(xpath = "//*[@class='inventory_item_name ']")
    public List<WebElement> productCount_ele2;

    @FindBy(id = "add-to-cart")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//Select[@class='product_sort_container']")
    public WebElement dropdownSort_ele;

    public void ProductItemActions(String expectedProduct){

        int productItemCount =productCount_ele.size();
        System.out.println("Product Count : "+productItemCount);


        for(WebElement element:productCount_ele){
            String productName= element.getText();
            System.out.println(productName);

        }
        for(WebElement element1:productCount_ele2){
            String productName= element1.getText();
            if(productName.equals(expectedProduct)){
                element1.click();
                addToCartBtn.click();
                break;
            }

        }





    }

    public void dropDownSortAction(){

        actionDriver.selectByValue(dropdownSort_ele,"za");
    }


}
