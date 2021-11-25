package pl.coderslab.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class ClothesPage {
    private final WebDriver driver;

    public ClothesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseSweater(){
        List<WebElement> allProducts = driver.findElements(By.tagName("article"));
        int numberOfProducts = allProducts.size();
        for(int i=1; i<=numberOfProducts; i++){
            WebElement productName = driver.findElement(By.xpath("//article["+i+"]//h2/a"));
            if (Objects.equals(productName.getText(), "Hummingbird Printed Sweater")){
                productName.click();
                break;
            }
        }
        Assert.assertTrue("discount not displayed",driver.findElement(By.cssSelector("span.discount")).isDisplayed());
        Assert.assertTrue("discount not 20%",driver.findElement(By.cssSelector("span.discount")).getText().contains("20%"));

    }
}
