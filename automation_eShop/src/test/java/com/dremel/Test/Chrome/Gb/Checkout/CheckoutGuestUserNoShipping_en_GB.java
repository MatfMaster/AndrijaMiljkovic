package com.dremel.Test.Chrome.Gb.Checkout;

import com.dremel.Pages.Checkout.CheckoutPageGb;
import com.dremel.Pages.Constants;
import com.dremel.Pages.Content.ContentGb;
import com.dremel.Pages.LandingPage;
import com.dremel.Pages.Page;
import com.dremel.Pages.PaymentMethods.Adyen;
import com.dremel.Pages.ProductPages.Dremel3000;
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

/**
 *
 * @author Andrija Miljkovic
 * 
 * Great Britain
 * Checkout Test / No shipping  / Guest / Dremel 3000
 * 
 */
public class CheckoutGuestUserNoShipping_en_GB {
    
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
    public void CheckoutGuestUserNoShipping_en_GB() throws InterruptedException, IOException{
        try{
        DOMConfigurator.configure("log4j.xml");
        Log.info("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- ");
        Log.info("GB Checkout | Guest | No shipping - Started");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openGb();
        landingPage.confirmCookieManager();
        landingPage.clickDremel3000BuyNow();
        Dremel3000 dremel3000 = new Dremel3000(driver);
        dremel3000.addToCartDremel3000();
        dremel3000.order();
        CheckoutPageGb checkoutPage = new CheckoutPageGb(driver);
        checkoutPage.fillInSteps123Guest();
        if (!checkoutPage.currentUrl().equals(Constants.Step3PageOrderConfirmationGb)){
            Log.warn("Order Confirmation step of checkout not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
            assertTrue(false);
        }
        if (!checkoutPage.page.getText().contains(ContentGb.NoShipping)) {
            Log.warn(ContentGb.NoShipping + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
            assertTrue(false);
        }
        checkoutPage.confirmStep3();
        Adyen adyen = new Adyen(driver);
        adyen.creditCardPaySingleCard();             
        Log.info("GB Checkout | Guest | No shipping - Ended SUCCESSFULLY");
        } catch (WebDriverException e) {
            Log.error("Failed with message: " + e.getMessage().substring(0, e.getMessage().indexOf("\n")));
            new Page(driver).takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
            assertTrue(false);
        }
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
}
