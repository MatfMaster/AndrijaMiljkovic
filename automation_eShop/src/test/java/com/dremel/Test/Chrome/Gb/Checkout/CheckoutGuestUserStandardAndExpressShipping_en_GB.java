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

/**
 *
 * @author Andrija Miljkovic
 * 
 * Great Britain
 * Checkout Test / Standard and Express shipping / Guest / Glue Gun
 * 
 */
public class CheckoutGuestUserStandardAndExpressShipping_en_GB {
    
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
    public void CheckoutGuestUserStandardAndExpressShipping_en_GB() throws InterruptedException, IOException{
        try {
        DOMConfigurator.configure("log4j.xml");
        Log.info("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- ");
        Log.info("GB Checkout | Guest | Standard and Express shipping - Started");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openGb();
        landingPage.confirmCookieManager();
        landingPage.clickGlueGun930BuyNow();
        GlueGun glueGun = new GlueGun(driver);
        glueGun.addToCartGlueGun930Gb();
        glueGun.order();
        CheckoutPageGb checkoutPage = new CheckoutPageGb(driver);
        checkoutPage.fillInSteps123GuestWithExpress();
        if (!checkoutPage.currentUrl().equals(Constants.Step3PageOrderConfirmationGb)){
            Log.warn("Order Confirmation step of checkout not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
            assertTrue(false);
        }
        if (!checkoutPage.page.getText().contains(ContentGb.StandardAndExpressShipping)) {
            Log.warn(ContentGb.StandardAndExpressShipping + " not shown");
            landingPage.takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
            assertTrue(false);
        }
        checkoutPage.confirmStep3();
        Adyen adyen = new Adyen(driver);
        adyen.creditCardPaySingleCard();
        Log.info("GB Checkout | Guest | Standard and express shipping - Ended SUCCESSFULLY");
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
