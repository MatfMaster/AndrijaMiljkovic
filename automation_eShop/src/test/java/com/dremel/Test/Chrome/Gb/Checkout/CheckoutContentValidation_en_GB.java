package com.dremel.Test.Chrome.Gb.Checkout;

import com.dremel.Pages.Checkout.CheckoutPageGb;
import com.dremel.Pages.Constants;
import com.dremel.Pages.Content.ContentGb;
import com.dremel.Pages.LandingPage;
import com.dremel.Pages.Page;
import com.dremel.Pages.PaymentMethods.Adyen;
import com.dremel.Pages.ProductPages.GlueGun;
import groovy.util.logging.Log4j;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Andrija Miljkovic
 * 
 * Great Britain
 * Checkout Test / Content Validation
 * 
 */
public class CheckoutContentValidation_en_GB {
    
    WebDriver driver;
    
    private static Logger Log = Logger.getLogger(Log4j.class.getName());
    
    @Before
    public void setUp() throws Exception { 
        Constants c = new Constants();
        driver = c.selectDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
        driver.manage().window().fullscreen();
    }
    
    @Test
    public void CheckoutContentValidation_en_GB() throws InterruptedException, IOException{
        try {
        DOMConfigurator.configure("log4j.xml");
        Log.info("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- ");
        Log.info("GB Checkout | Content validation - Started");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openGb();
        landingPage.confirmCookieManager();
        landingPage.clickGlueGun930BuyNow();
        GlueGun glueGun = new GlueGun(driver);
        glueGun.addToCartGlueGun930Gb();
        glueGun.order();
        if(!glueGun.page.getText().contains(ContentGb.ShoppingCartTitle)){
            Log.warn(ContentGb.ShoppingCartTitle + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!glueGun.page.getText().contains(ContentGb.PleaseCheckYourShoppingCart)){
            Log.warn(ContentGb.PleaseCheckYourShoppingCart + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        CheckoutPageGb checkoutPage = new CheckoutPageGb(driver);
        checkoutPage.fillInStep1();
        checkoutPage.ContinueButtonUnregisteredCheckout.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains(Constants.Step2PageGb));
        if(!checkoutPage.page.getText().contains(ContentGb.InvoiceAddress)){
            Log.warn(ContentGb.InvoiceAddress + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.TitleIsRequired)){
            Log.warn(ContentGb.TitleIsRequired + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.FirstNameIsRequired)){
            Log.warn(ContentGb.FirstNameIsRequired + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.LastNameIsRequired)){
            Log.warn(ContentGb.LastNameIsRequired + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.StreetIsRequired)){
            Log.warn(ContentGb.StreetIsRequired + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.CityIsRequired)){
            Log.warn(ContentGb.CityIsRequired + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.PostalIsRequired)){
            Log.warn(ContentGb.PostalIsRequired + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.DeliveryAddress)){
            Log.warn(ContentGb.DeliveryAddress + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.EmailIsRequired)){
            Log.warn(ContentGb.EmailIsRequired + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.AccountData)){
            Log.warn(ContentGb.AccountData + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.WantToReceiveYourProduct)){
            Log.warn(ContentGb.WantToReceiveYourProduct + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        checkoutPage.fillInStep2Guest();
        checkoutPage.confirmStep2();
        new WebDriverWait(driver, Constants.AdyenLoadingTime).until(ExpectedConditions.urlContains(Constants.Step3PageOrderConfirmationGb));
        if(!checkoutPage.page.getText().contains(ContentGb.BillingAddress)){
            Log.warn(ContentGb.BillingAddress + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.DeliveryAddress)){
            Log.warn(ContentGb.DeliveryAddress + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        if(!checkoutPage.page.getText().contains(ContentGb.ShippingOption)){
            Log.warn(ContentGb.ShippingOption + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
         if(!checkoutPage.page.getText().contains(Constants.NameGuest)){
            Log.warn(Constants.NameGuest + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
        }
        checkoutPage.fillInStep3();
        checkoutPage.confirmStep3();
        Adyen adyen = new Adyen(driver);
        adyen.creditCardPaySingleCard();
        
        Log.info("GB Checkout | Content validation - Ended SUCCESSFULLY");
        } catch (WebDriverException e) {
            new Page(driver).takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
            Log.error("Failed with message: " + e.getMessage().substring(0, e.getMessage().indexOf("\n")));
            assertTrue(false);
        }
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}
