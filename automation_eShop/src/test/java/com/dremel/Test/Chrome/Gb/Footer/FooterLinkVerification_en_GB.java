package com.dremel.Test.Chrome.Gb.Footer;

import com.dremel.Pages.Constants;
import com.dremel.Pages.LandingPage;
import groovy.util.logging.Log4j;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 *
 * @author Andrija Miljkovic
 * 
 * Footer links verification for Great Britain
 */
public class FooterLinkVerification_en_GB {
        
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
    public void FooterLinkVerificationGb() throws InterruptedException{
        try {
        DOMConfigurator.configure("log4j.xml");
        Log.info("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- ");
        Log.info("GB Links verification - Started");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openGb();
        if(!landingPage.getPressOfficeHyperlink().equals(Constants.PressOfficeHyperlinkGb)){
            Log.warn(Constants.PressOfficeHyperlinkGb + " not shown");
        }
        Log.info("Press link ok");
        if(!landingPage.getTermsAndConditionsHyperlink().equals(Constants.TermsAndConditionsHyperlinkGb)){
            Log.warn(Constants.TermsAndConditionsHyperlinkGb + " not shown");
        }
        Log.info("T&C link ok");
        if(!landingPage.getPrivacyStatemenHyperlink().equals(Constants.PrivacyStatementHyperlinkGb)){
            Log.warn(Constants.PrivacyStatementHyperlinkGb + " not shown");
        }
        Log.info("Privacy statement link ok");
        if(!landingPage.getWarrantyHyperlink().equals(Constants.WarrantyHyperlinkGb)){
            Log.warn(Constants.WarrantyHyperlinkGb + " not shown");
        }
        Log.info("Warranty link ok");
        if(!landingPage.getDremelEuropeHyperlink().equals(Constants.DremelEuropeHyperlinkGb)){
            Log.warn(Constants.DremelEuropeHyperlinkGb + " not shown");
        }
        Log.info("Dremel Europe link ok");
        if(!landingPage.getSitemapHyperlink().equals(Constants.SitemapHyperlinkGb)){
            Log.warn(Constants.SitemapHyperlinkGb + " not shown");
        }
        Log.info("Sitemap link ok");
        Log.info("GB Links verification - Ended SUCCESSFULLY");
        } catch (WebDriverException e) {
            Log.error("Failed with message: " + e.getMessage().substring(0, e.getMessage().indexOf("\n")));
        }
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    
}
