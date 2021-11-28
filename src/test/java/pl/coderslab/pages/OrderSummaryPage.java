package pl.coderslab.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class OrderSummaryPage {
    private final WebDriver driver;
    public String orderRef;
    public String orderPrice;

    @FindBy(css = "a.account")
    private WebElement accPanelBtn;
    @FindBy(css = "tr.font-weight-bold > td:nth-child(2)")
    private WebElement orderTotal;
    @FindBy(css = "#order-details > ul > li:nth-child(1)")
    private WebElement orderReference;

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void takeScreenshot() throws IOException {
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scr, new File("C:\\CodersLab\\CL-end-project\\order-confirmation.png"));
    }

    public void goToYourAccount() {
        accPanelBtn.click();
    }

    public void setOrderPrice() {
        orderPrice = orderTotal.getText();
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderRef() {
        String fulltxt = orderReference.getText();
        orderRef = fulltxt.substring(18);
    }

    public String getOrderRef() {
        return orderRef;
    }
}
