package pl.coderslab.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
    private final WebDriver driver;

    @FindBy(css = "div.addresses-footer a[data-link-action='add-address']")
    WebElement newAddressLink;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToAddNewAddress() {
        newAddressLink.click();
    }

    public void checkNewAddressSuccess(String alias, String address, String city, String postcode, String phone) {
        WebElement successBanner = driver.findElement(By.cssSelector("article.alert ul li"));
        Assert.assertEquals("Address successfully added!", successBanner.getText());
        WebElement newAddressAlias = driver.findElement(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-6'][last()]//h4"));
        Assert.assertEquals("new alias not found", newAddressAlias.getText(), alias);
        WebElement newAddressBody = driver.findElement(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-6'][last()]//address"));
        String newAddressText = newAddressBody.getText();
        Assert.assertTrue("address not set up correctly", newAddressText.contains(address));
        Assert.assertTrue("city not set up correctly", newAddressText.contains(city));
        Assert.assertTrue("postcode not set up correctly", newAddressText.contains(postcode));
        Assert.assertTrue("phone number not set up correctly", newAddressText.contains(phone));
    }

    public void deleteLastAddress(String alias) {
        WebElement deleteButton = driver.findElement(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-6'][last()]//a[@data-link-action='delete-address']"));
        deleteButton.click();
        WebElement successBanner = driver.findElement(By.cssSelector("article.alert ul li"));
        Assert.assertEquals("Address successfully deleted!", successBanner.getText());
        WebElement lastAddressAlias = driver.findElement(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-6'][last()]//h4"));
        Assert.assertNotEquals("new address not deleted", lastAddressAlias.getText(), alias);
    }
}
