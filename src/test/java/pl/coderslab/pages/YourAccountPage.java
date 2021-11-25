package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    private final WebDriver driver;

    @FindBy(id = "addresses-link")
    private WebElement AddressesLink;

    @FindBy(css = "li.category:first-child a")
    private WebElement ClothesLink;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToAddresses() {
        AddressesLink.click();
    }

    public void goToClothes() {
        ClothesLink.click();
    }
}

