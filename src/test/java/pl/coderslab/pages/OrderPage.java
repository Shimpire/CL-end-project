package pl.coderslab.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;

    @FindBy(css = "div.address")
    WebElement deliveryAddress;
    @FindBy(name = "confirm-addresses")
    WebElement confAddrBtn;
    @FindBy(css = "input#delivery_option_1")
    WebElement deliveryMethod1;
    @FindBy(css = "input#delivery_option_2")
    WebElement deliveryMethod2;
    @FindBy(name = "confirmDeliveryOption")
    WebElement confirmDeliveryBtn;
    @FindBy(id = "payment-option-1")
    WebElement paymentOption;
    //    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    @FindBy(css = "label.js-terms")
    WebElement tosTickbox;
    @FindBy(css = "div>button[type='submit'].center-block")
    WebElement confOrderBtn;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void confirmAddress() {
        String delAddr = deliveryAddress.getText();
        Assert.assertTrue("delivery recipient name not set up correctly", delAddr.contains("Lily Miles"));
        Assert.assertTrue("delivery address not set up correctly", delAddr.contains("3648 Lake Road"));
        Assert.assertTrue("delivery city not set up correctly", delAddr.contains("Atlantic City"));
        Assert.assertTrue("delivery postcode not set up correctly", delAddr.contains("NJ 08401"));
        Assert.assertTrue("delivery country not set up correctly", delAddr.contains("United Kingdom"));
        Assert.assertTrue("delivery phone number not set up correctly", delAddr.contains("609-348-0799"));
        confAddrBtn.click();
    }

    public void chooseDeliveryMethod() {
        deliveryMethod2.click();
        deliveryMethod1.click();
        confirmDeliveryBtn.click();
    }

    public void choosePaymentOption() {
        paymentOption.click();
        tosTickbox.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(confOrderBtn));
        confOrderBtn.click();
    }

}
