package com.dremel.Pages.Checkout;

import com.dremel.Pages.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Andrija Miljkovic
 */
public class CheckoutPageGb extends CheckoutPage{
    
    public CheckoutPageGb(WebDriver driver) {
        super(driver);
    }
    // Fill in all the fields on step 2
    public void fillInStep2Guest(){        
        fluentWait(MrRadioButtonUnregisteredCheckout).click();
        fluentWait(FirstNameFieldUnregisteredCheckout).click();
        fluentWait(FirstNameFieldUnregisteredCheckout).clear();
        fluentWait(FirstNameFieldUnregisteredCheckout).sendKeys(Constants.NameGuest);
        fluentWait(LastNameFieldUnregisteredCheckout).click();
        fluentWait(LastNameFieldUnregisteredCheckout).clear();
        fluentWait(LastNameFieldUnregisteredCheckout).sendKeys(Constants.LastnameGuest);
        fluentWait(AddressFieldUnregisteredCheckout).click();
        fluentWait(AddressFieldUnregisteredCheckout).clear();
        fluentWait(AddressFieldUnregisteredCheckout).sendKeys(Constants.AddressGuest);
        scroll_element_into_view(TownFieldUnregisteredCheckout);
        fluentWait(TownFieldUnregisteredCheckout).click();
        fluentWait(TownFieldUnregisteredCheckout).clear();
        fluentWait(TownFieldUnregisteredCheckout).sendKeys(Constants.TownGuest);
        fluentWait(PostalCodeFieldUnregisteredCheckout).click();
        fluentWait(PostalCodeFieldUnregisteredCheckout).clear();
        fluentWait(PostalCodeFieldUnregisteredCheckout).sendKeys(Constants.PostalCodeGuestGb);
        fluentWait(TelephoneFieldUnregisteredCheckout).click();
        fluentWait(TelephoneFieldUnregisteredCheckout).clear();
        fluentWait(TelephoneFieldUnregisteredCheckout).sendKeys(Constants.TelephoneGuest);
        fluentWait(AccountDataFieldUnregisteredCheckout).click();
        fluentWait(AccountDataFieldUnregisteredCheckout).clear();
        fluentWait(AccountDataFieldUnregisteredCheckout).sendKeys(Constants.AccountDataGuest);        
    }
 
     // Check all checkboxes on step 3
    public void fillInStep3(){        
        if (!fluentWait(DataProtectionGuidelinesCheckbox).isSelected()){
            fluentWait(DataProtectionGuidelinesCheckbox).click();}
        if (!fluentWait(TermsAndConditionsCheckbox).isSelected()){
            fluentWait(TermsAndConditionsCheckbox).click();}
            }
    
    // Fill in all fields + EXPRESS DELIVERY checkbox on Step 2
    public void fillInStep2withExpress() throws InterruptedException{
        fillInStep2Guest();
        checkOnExpressField();
        }
    
    // Integrated Step 2 and Step 3 with PRICE CHANGE PROTECTION
    public void fillInSteps123Guest() throws InterruptedException{
        fillInStep1();
        fillInStep2Guest();
        confirmStep2();
        try {
           if (new WebDriverWait(driver, Constants.PriceChangeUrlWaitingTime).until(ExpectedConditions.urlToBe(Constants.PriceChangePageGb))){
            fillInStep1();
            confirmStep2();
        } 
        } catch (Exception e) {
        }
        fillInStep3();        
    }
    
        // Integrated Step 2 and Step 3 with PRICE CHANGE PROTECTION + Express delivery
    public void fillInSteps123GuestWithExpress() throws InterruptedException{
        fillInStep1();
        fillInStep2withExpress();
        confirmStep2();
        try {
           if (new WebDriverWait(driver, Constants.PriceChangeUrlWaitingTime).until(ExpectedConditions.urlToBe(Constants.PriceChangePageGb))){
            fillInStep1();
            confirmStep2();
        } 
        } catch (Exception e) {
        }
            fillInStep3();        
    }
    
}
    
  
