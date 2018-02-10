package com.dremel.Pages.Checkout;

import com.dremel.Pages.Constants;
import com.dremel.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andrija Miljkovic
 */
public class CheckoutPage extends Page{
    
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    
    // ELEMENTS - STEP 1
    
    // Card item quantity field (STEP 1)
    @FindBy (id = "cart-item-quantity-field-")
    WebElement QuantityFieldCardItem;
    
    // Enter address (STEP 1)
    @FindBy (id = "submit")
    WebElement EnterAddressButtonCheckout;
    
    // Continue shopping button (STEP 1)
    @FindBy (id = "continue-shopping")
    WebElement ContinueShoppingCheckout;
 
    // ELEMENTS - STEP 2
    
    // I already have an account radio button (STEP 2)
    @FindBy (id = "with-account-radio-option")
    WebElement IalreadyHaveAccountRadioButtonCheckout;
    
    // Without account checkout radio button (STEP 2)
    @FindBy (id = "without-account-guest-radio-option")
    WebElement WithoutAccountCheckoutRadioButtonCheckout;
    
    // Mr radio button for unregistered user (STEP 2)
    @FindBy (id = "title-mr-radio-billing-field")
    WebElement MrRadioButtonUnregisteredCheckout;
    
    // Mrs radio button for unregistered user (STEP 2)
    @FindBy (id = "title-mrs-radio-billing-field")
    WebElement MrsRadioButtonUnregisteredCheckout;
    
    // First name for unregistered user (STEP 2)
    @FindBy (id = "first-name-billing-field")
    WebElement FirstNameFieldUnregisteredCheckout;
    
    // Last name for unregistered user (STEP 2)
    @FindBy (id = "last-name-billing-field")
    WebElement LastNameFieldUnregisteredCheckout;
    
    // Adress for unregistered user (STEP 2)
    @FindBy (id = "address-1-billing-field")
    WebElement AddressFieldUnregisteredCheckout;
    
    // Second line for unregistered user (STEP 2)
    @FindBy (id = "address-2-billing-field")
    WebElement SecondLineAddressFieldUnregisteredCheckout;
    
    // Town / City for unregistered user (STEP 2)
    @FindBy (id = "city-billing-field")
    WebElement TownFieldUnregisteredCheckout;
    
    // Postal code for unregistered user (STEP 2)
    @FindBy (id = "zip-billing-field")
    WebElement PostalCodeFieldUnregisteredCheckout;
    
    // Country for unregistered user (STEP 2)
    @FindBy (id = "country-billing-field")
    WebElement CountryFieldUnregisteredCheckout;
    
    // Telephone for unregistered user (STEP 2)
    @FindBy (id = "telephone-billing-field")
    WebElement TelephoneFieldUnregisteredCheckout;
    
    // Specify Different delivery address checkbox for unregistered user (STEP 2)
    @FindBy (id = "expand-delivery-address-fields")
    WebElement SpecifyDifferentDeliveryAddressUnregisteredCheckout;
    
    // Account data for unregistered user (STEP 2)
    @FindBy (id = "email-account-data-field")
    WebElement AccountDataFieldUnregisteredCheckout;
    
    // Express shipping checkbox for unregistered user (STEP 2)
    @FindBy (id = "express-delivery-checkbox")
    WebElement ExpressCheckboxUnregisteredCheckout;
    
    // Continue for unregistered user (STEP 2)
    @FindBy (id = "submit")
    public WebElement ContinueButtonUnregisteredCheckout;
    
    // STEP 3
    
    // Edit Billing address Step 2 from Step 3 (STEP 3)
    @FindBy (id = "edit-checkout-step-2")
    WebElement EditBillingAddressCheckout;
    
    // Edit Delivery address Step 2 from Step 3 (STEP 3)
    @FindBy (id = "edit-delivery-address-checkout-step-2")
    WebElement EditDeliveryAddressCheckout;
    
    // Edit Shipping option Step 2 from Step 3 (STEP 3)
    @FindBy (id = "edit-delivery-method")
    WebElement EditShippingOptionCheckout;
    
    // Data protection guidelines checkbox (STEP 3)
    @FindBy (id = "data-protection-confirmation-field")
    WebElement DataProtectionGuidelinesCheckbox;
    
    // Terms and conditions checkbox (STEP 3)
    @FindBy (id = "terms-and-conditions-field")
    WebElement TermsAndConditionsCheckbox;
    
    // Additional product information checkbox (STEP 3)
    @FindBy (id = "last-checkbox-field-optional")
    WebElement AdditionalProductInformationCheckbox;
    
    // Go To Payment Page button (STEP 3)
    @FindBy (id = "submit-bottom")
    WebElement GoToPaymentPageButton;
    
    // METHODS:
    
    public void checkOnExpressField() throws InterruptedException{
        Thread.sleep(Constants.SmallWaitingTime);
        fluentWait(ExpressCheckboxUnregisteredCheckout).click();
        Thread.sleep(Constants.SmallWaitingTime);
    }
    
    // Fill in all the fields on step 1 (just click on this time)
    public void fillInStep1() throws InterruptedException{
        Thread.sleep(Constants.SmallWaitingTime);
        new Actions(driver).moveToElement(fluentWait(EnterAddressButtonCheckout)).click().build().perform();
//        fluentWait(EnterAddressButtonCheckout).click();
    }    
    
    // Confirmation of Step 2 and moving to step 3
    public void confirmStep2() throws InterruptedException{
        Thread.sleep(Constants.SmallWaitingTime);
//        fluentWait(ContinueButtonUnregisteredCheckout).click();
        scroll_element_into_view(ContinueButtonUnregisteredCheckout);
        new Actions(driver).moveToElement(fluentWait(ContinueButtonUnregisteredCheckout)).click().build().perform();
    }
    
    // Confirmation of Step 3 and moving to step 4
    public void confirmStep3(){
        fluentWait(GoToPaymentPageButton).click();
    }          
}
