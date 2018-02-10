package com.dremel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andrija Miljkovic
 */
public class LandingPage extends Page{
    
    // MAIN CLASS CONSTRUCTOR
    public LandingPage(WebDriver driver) {
        super(driver);
    }
    
    // ELEMENTS
    
    // DREMEL� 3000 BUY NOW BUTTON (GB,DE)
    @FindBy (id = "7736-buy-now")
    WebElement Dremel3000BuyNow;
    
    // DREMEL� Glue Gun 930 BUY NOW BUTTON (GB,DE)
    @FindBy (id = "7894-buy-now")
    WebElement GlueGun930BuyNow;
    
    // DREMEL� Glue Gun 910 BUY NOW BUTTON (DE)
    @FindBy (id = "7893-buy-now")
    WebElement GlueGun910BuyNow;
    
    
    // DREMEL� Glue Gun 940 BUY NOW BUTTON (GB,DE)
    @FindBy (id = "7895-buy-now")
    WebElement GlueGun940BuyNow;
       
    // METHODS
    
    // OPEN FIRST PAGE (LANDING PAGE)
    
    public void openGb(){
        driver.get(Constants.LandingPageGb);
    }   
    
    
    // Confirming header for Cookie manager
    
    public void confirmCookieManager(){
        fluentWait(OkCookieManagerHeader).click();
    }
    
    
    // BUY NOW ON LANDING PAGE
    
    public void clickDremel3000BuyNow() throws InterruptedException{
        Thread.sleep(Constants.SmallWaitingTime);
        scroll_element_into_view(Dremel3000BuyNow);
        new Actions(driver).moveToElement(fluentWait(Dremel3000BuyNow)).click().build().perform();
    }
    
    public void clickGlueGun930BuyNow() throws InterruptedException{
        Thread.sleep(Constants.SmallWaitingTime);
        scroll_element_into_view(GlueGun930BuyNow);
        new Actions(driver).moveToElement(fluentWait(GlueGun930BuyNow)).click().build().perform();
    }            
}
