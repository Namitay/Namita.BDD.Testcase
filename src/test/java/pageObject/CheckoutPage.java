package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//select[@id='billing-address-select']")
    public WebElement AddTextBox;

    @FindBy(xpath = "(//input[@title='Continue'])[1]")
    public WebElement firstcontinueButton;

    @FindBy(xpath = "(//input[@type='button'])[4]")
    public WebElement secondContinueButton;

    @FindBy(xpath = "(//input[@value='Continue'])[4]")
    public WebElement thirdContinueButton;


    @FindBy(xpath = "(//input[@value='Continue'])[5]")
    public WebElement fourthContinueButton;
    @FindBy(xpath = "(//input[@type='button'])[7]")
    public WebElement confirmButton;

    @FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
    public WebElement confirmationMessage;

    public void ClickFirstContinueButton()
    {
        firstcontinueButton.click();
    }

    public void ClickSecondContinueButton() {

        secondContinueButton.click();
    }


    public void ClickThirdContinueButton()
    {
        thirdContinueButton.click();
    }

    public void ClickFourthContinueButton()
    {
        fourthContinueButton .click();
    }
    public void ClickConfirmButton()
    {
        confirmButton.click();
    }
    public String verifyConfirmationMegssage()
    {

        return  confirmationMessage.getText();
    }

}
