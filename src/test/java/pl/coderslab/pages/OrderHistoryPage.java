package pl.coderslab.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    private final WebDriver driver;

    @FindBy(css = "tr:nth-child(1) > td.text-sm-center.order-actions > a:nth-child(1)")
    private WebElement orderDetailsLink;
    @FindBy(css = "div.col-xs-9 > strong")
    private WebElement lastOrderReference;
    @FindBy(css = "tr.text-xs-right.line-total > td:nth-child(2)")
    private WebElement lastOrderTotal;
    @FindBy(css = "td > span.label-pill")
    private WebElement orderStatus;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToOrderDetails(){
        orderDetailsLink.click();
    }

    public void checkLastOrderDetails(String orderRef, String orderPrice){
        Assert.assertTrue("reference does not match last order",lastOrderReference.getText().contains(orderRef));
        Assert.assertEquals("total price does not match last order",orderPrice,lastOrderTotal.getText());
        Assert.assertEquals("last order status incorrect", "Awaiting check payment", orderStatus.getText());
    }
}
