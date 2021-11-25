package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private final WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasField;

    @FindBy(name = "address1")
    private WebElement addressField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(name = "postcode")
    private WebElement postcodeField;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(css = "button.btn[type='submit']")
    private WebElement addNewAddressButton;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AddNewAddress(String alias, String address, String city, String postcode, String phone){
        aliasField.clear();
        aliasField.sendKeys(alias);
        addressField.clear();
        addressField.sendKeys(address);
        cityField.clear();
        cityField.sendKeys(city);
        postcodeField.clear();
        postcodeField.sendKeys(postcode);
        driver.findElement(By.cssSelector("select.form-control")).click();
        driver.findElement(By.cssSelector("select.form-control option[value='17']")).click();
        phoneField.clear();
        phoneField.sendKeys(phone);
        addNewAddressButton.click();
    }
}
