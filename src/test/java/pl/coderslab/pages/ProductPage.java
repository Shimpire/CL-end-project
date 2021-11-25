package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private final WebDriver driver;

    @FindBy(name = "qty")
    WebElement quantityBox;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseSize(String size){
        driver.findElement(By.cssSelector("select#group_1 option[title='"+size+"']")).click();
    }

    public void chooseQuantity(String prodQuantity){
        quantityBox.click();
        quantityBox.click();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.clear();
        quantityBox.sendKeys(prodQuantity);
        quantityBox.sendKeys(Keys.ENTER);
    }

    public void goToCart(){
        driver.findElement(By.cssSelector("div a.btn-primary")).click();
    }
}
