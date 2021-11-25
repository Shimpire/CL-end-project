package pl.coderslab.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ZadWar2Steps {
    WebDriver driver;
    Homepage homePage;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    ClothesPage clothesPage;
    ProductPage productPage;
    CartPage cartPage;
    OrderPage orderPage;
    OrderSummaryPage orderSummaryPage;

    @Given("user is on MyStore main page")
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

    @When("user logs in with email:{string} and password:{string}")
    public void logIn(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @And("user proceeds to Clothes category")
    public void proceedToClothes() {
        yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goToClothes();
    }

    @And("user chooses desired product")
    public void chooseFromProductList() {
        clothesPage = new ClothesPage(driver);
        clothesPage.chooseSweater();
    }

    @And("^user chooses product size: (S|M|L|XL)$")
    public void chooseProdSize(String size) {
        productPage = new ProductPage(driver);
        productPage.chooseSize(size);
    }

    @And("^user puts in quantity of products to order: ([0-9]{0,4})$")
    public void chooseProdQuantity(String prodQuantity) {
        productPage.chooseQuantity(prodQuantity);
    }

    @And("user proceeds to checkout")
    public void proceedToCheckout() {
        productPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.goToCheckout();
    }

    @And("user confirms the selected delivery address is correct")
    public void confirmDeliveryAddress() {
        orderPage = new OrderPage(driver);
        orderPage.confirmAddress();
    }

    @And("user chooses delivery method")
    public void selectDeliveryMethod() {
        orderPage.chooseDeliveryMethod();
    }

    @And("user selects payment option and completes order")
    public void selectPaymentOption() {
        orderPage.choosePaymentOption();
    }

    @Then("order is completed and screenshot taken of confirmation screen")
    public void orderConfirmationScreenshot() throws IOException {
        orderSummaryPage = new OrderSummaryPage(driver);
        orderSummaryPage.takeScreenshot();
    }

    @And("close browser")
    public void tearDown() {
        driver.quit();
    }
}
