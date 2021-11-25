package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    private final WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void GotoSignIn(){
        driver.findElement(By.cssSelector(".user-info a[title='Log in to your customer account']")).click();
    }
}
