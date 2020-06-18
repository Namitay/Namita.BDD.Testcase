import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.CheckoutPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShoppingCartPage;

public class MyStepdefs extends MyTestRunner {
   // WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public ShoppingCartPage shoppingcartpage;
    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @Before
    public void start() {

       // WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
               //WebDriverWait wait = new WebDriverWait(driver,30);      Explicit wait
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();


        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        shoppingcartpage = new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);

    }

    @After
    public void stop(Scenario scenario) {
        // if(scenario.isFailed()) {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshotBytes, "image/png");
        // }
        //driver.quit();
    }


    @Given("I am in homepage")
    public void iAmInHomepage() {
        homePage.navigateToUrl();
    }

    @When("I click on login link from nav bar")
    public void iClickOnLoginLinkFromNavBar() {
        homePage.clickLoginLink();
    }

    @Then("I should be navigated to login page")
    public void iShouldBeNavigatedToLoginPage() {
        System.out.println(homePage.getPageTitle());
    }

    @When("I enter login details")
    public void iEnterLoginDetails(io.cucumber.datatable.DataTable dataTable)
    {

        loginPage.enterEmail(dataTable.cell(1,0));
        loginPage.enterPassword(dataTable.cell(1,1));
    }

    @And("I click on login button")
    public void iClickOnLoginButton()
    {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully()
    {
        System.out.println(homePage.getPageTitle());
    }

    @When("I add item in to the cart")
    public void iAddItemInToTheCart() {
        loginPage.clickAddToCartFirst();
    }

    @And("I add another item to the cart")
    public void iAddAnotherItemToTheCart() {
        loginPage.clickAddToCartSecond();
    }

    @And("I go the cart")
    public void iGoTheCart() throws InterruptedException {
        Thread.sleep(10000);
        homePage.clickShoppingCartLink();
    }

    @And("I click on terms of service")
    public void iClickOnTermsOfService() {
        shoppingcartpage.ClickTermOfServiceCheckBox();
    }

    @And("I checkout as a existing user")
    public void iCheckoutAsAExistingUser() {
        shoppingcartpage.ClickCheckoutButton();
    }

    @And("I click on first continue")
    public void iClickOnFirstContinue() {
        checkoutPage.ClickFirstContinueButton();
    }
    @And("I click on second continue")
    public void iClickOnSecondContinue() throws InterruptedException {
        Thread.sleep(3000);
      checkoutPage.ClickSecondContinueButton();
    }

    @And("I click on continue third again")
    public void iClickOnContinueThirdAgain() throws InterruptedException {
        Thread.sleep(3000);
        checkoutPage.ClickThirdContinueButton();
    }

    @And("I click on continue fourth time")
    public void iClickOnContinueFourthTime() throws InterruptedException {
        Thread.sleep(3000);
        checkoutPage.ClickFourthContinueButton();
    }

    @And("I click on confirm")
    public void iClickOnConfirm() throws InterruptedException {
        Thread.sleep(3000);
        checkoutPage.ClickConfirmButton();
    }

    @Then("I should see the order confirmation message")
    public void iShouldSeeTheOrderConfirmationMessage() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println(checkoutPage.verifyConfirmationMegssage());
    }


}
