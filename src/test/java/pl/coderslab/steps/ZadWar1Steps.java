package pl.coderslab.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.*;

import java.util.concurrent.TimeUnit;

public class ZadWar1Steps {
    WebDriver driver;
    Homepage homePage;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    AddressesPage addressesPage;
    NewAddressPage newAddressPage;

    @Given("User is on MyStore homepage")
    public void userIsOnMyStoreHomepage() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/");
        homePage = new Homepage(driver);
        homePage.GotoSignIn();
    }

    @When("user logs in using email:{string} and password:{string}")
    public void logIn(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @And("user proceeds to addresses page")
    public void proceedToAddresses() {
        yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goToAddresses();
    }

    @And("user goes to add new address page")
    public void proceedToAddNewAddress() {
        addressesPage = new AddressesPage(driver);
        addressesPage.goToAddNewAddress();
    }

    @And("user fills out following address details alias:{string}, address:{string}, city:{string}, postal code:{string}, phone number:{string}")
    public void fillNewAddressForm(String alias, String address, String city, String postcode, String phone) {
        newAddressPage = new NewAddressPage(driver);
        newAddressPage.AddNewAddress(alias, address, city, postcode, phone);
    }

    @Then("new address is added to the account: {string}{string}{string}{string}{string}")
    public void newAddressAdded(String alias, String address, String city, String postcode, String phone) {
        addressesPage.checkNewAddressSuccess(alias, address, city, postcode, phone);
    }

    @And("new address named {string} is deleted")
    public void newAddressDeleted(String alias) {
        addressesPage.deleteLastAddress(alias);
        driver.quit();
    }
}
