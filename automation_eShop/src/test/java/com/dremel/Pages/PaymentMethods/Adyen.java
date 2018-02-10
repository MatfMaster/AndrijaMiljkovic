package com.dremel.Pages.PaymentMethods;

import com.dremel.Pages.Constants;
import com.dremel.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Andrija Miljkovic
 * 
 */
public class Adyen extends Page{
    
    public Adyen(WebDriver driver) {
        super(driver);
    }
    
    // ELEMENTS
    
    // Credit card payment method icon (Card icon)
    @FindBy (id = "credit-cart-payment-method")
    WebElement CreditCardPaymentMethod;
    
    // Card number field
    @FindBy (id = "card.cardNumber")
    public WebElement CardNumberField;
    
    // Card holder name field
    @FindBy (id = "card.cardHolderName")
    WebElement CardHolderNameField;
    
    // Card expiry date MONTH field
    @FindBy (id = "card.expiryMonth")
    WebElement CardExpiryMonthField;
    
    // Card expiry date YEAR field
    @FindBy (id = "card.expiryYear")
    WebElement CardExpiryYearField;
    
    // CVC field
    @FindBy (id = "card.cvcCode")
    WebElement CvcCardField;
    
    // METHODS
    
    // Paying with Credit Card on Adyen page
    public void creditCardPaySingleCard() throws InterruptedException{       
        new WebDriverWait(driver, Constants.PriceChangeUrlWaitingTime).until(ExpectedConditions.elementToBeClickable(fluentWait(CardNumberField))).click();
        fluentWait(CardNumberField).clear();
        fluentWait(CardNumberField).sendKeys(Constants.CreditCardNumber);
        fluentWait(CardHolderNameField).click();
        fluentWait(CardHolderNameField).clear();
        fluentWait(CardHolderNameField).sendKeys("Thanks for watching!");
        new Select(fluentWait(CardExpiryMonthField)).selectByVisibleText(Constants.CardExpiryMonth);
        new Select(fluentWait(CardExpiryYearField)).selectByVisibleText(Constants.CardExpiryYear);
        fluentWait(CvcCardField).click();
        fluentWait(CvcCardField).clear();
        fluentWait(CvcCardField).sendKeys(Constants.CvcCard);
 
        Thread.sleep(Constants.SmallWaitingTime);       
    }
    
}
