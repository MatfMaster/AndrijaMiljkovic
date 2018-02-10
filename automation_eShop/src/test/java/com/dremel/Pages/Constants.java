package com.dremel.Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Andrija Miljkvic
 */
public class Constants {
    
    /**
     *
     */
    //public static String url;
    
 
     
   public static String INSTANCE_NAME;
 
    /***************************************************/    
  
    // PAGES
    public static String LandingPageGb;
    public static String Step1PageGb = INSTANCE_NAME + "/gb/en/checkout/step1/-/cart/cartSummary";
    public static String urlfooterpress;
    public static String urlfooterterms;
    public static String urlfooterprivacy;
    public static String urlfooterwarranty;
    public static String urlfootereurope;
    public static String urlfootersitemap;  
    
    public Constants(){
        try {
            String filePath = "/Downloads/Master rad/Automation/com.mycompany.app_my-app_jar_1.0-SNAPSHOT/config.properties";
		Properties prop = new Properties();
                InputStream inputStream = new FileInputStream(filePath);
                
                // Loading the properties.
			prop.load(inputStream);
 
			// Getting properties
			INSTANCE_NAME = prop.getProperty("urleshop");                      
                        LandingPageGb = INSTANCE_NAME + "/gb/en/products";
                        
			urlfooterpress = prop.getProperty("urlfooterpress");
			urlfooterterms = prop.getProperty("urlfooterterms");
			urlfooterprivacy = prop.getProperty("urlfooterprivacy");
			urlfooterwarranty = prop.getProperty("urlfooterwarranty");
			urlfootereurope = prop.getProperty("urlfootereurope");
			urlfootersitemap = prop.getProperty("urlfootersitemap");
                       
        } catch (IOException ex) {
            Logger.getLogger(Constants.class.getName()).log(Level.SEVERE, null, ex);            
        } 
    }
    /****************************************************
    *                                                   *
    *   SELECTING FOR WHICH INSTANCE TEST WILL WORK     *
    *                                                   *
    ****************************************************/
    
    
    // S INSTANCE
        //public static final String INSTANCE_NAME = "https://testshop.dremeleurope.com";
    
    // Q INSTANCE
        //public static final String INSTANCE_NAME = "https://testshop.dremeleurope.com";
    
    // P INSTANCE
    
    public static String Step2PageGb = INSTANCE_NAME + "/gb/en/checkout/step2";
    public static String PriceChangePageGb = INSTANCE_NAME + "/gb/en/checkout/step1/-/cart/cartSummary";
    public static String Step3PageOrderConfirmationGb = INSTANCE_NAME + "/gb/en/checkout/order-confirmation?orderConfirmation"; 
    
    // USER DATA
    
    public static String NameGuest = RandomStringUtils.randomAlphabetic(7).toLowerCase();
    public static String LastnameGuest = RandomStringUtils.randomAlphabetic(9).toLowerCase();
    public static String AddressGuest = RandomStringUtils.randomAlphabetic(9).toLowerCase() + RandomStringUtils.randomNumeric(3);
    public static String SecondLineAddress = RandomStringUtils.randomNumeric(3);
    public static String TownGuest = RandomStringUtils.randomAlphabetic(6).toLowerCase();
    public static String TelephoneGuest = RandomStringUtils.randomNumeric(9);
    public static String PostalCodeGuestGb = "aa12 3" + RandomStringUtils.randomAlphabetic(2).toLowerCase();
    public static String AccountDataGuest = "example@alas.matf.bg.ac.rs";
    
    // CREDIT CARD DATA
    
    public static String CreditCardName = "Visa";
    public static String CreditCardNumber = "4111111111111111";
    public static String CardExpiryMonth = "08";
    public static String CardExpiryYear = "2018";
    public static String CvcCard = "737";
    
    
    // Sleep timeouts
    
    public static int AdyenLoadingTime = 16000;
    public static int FillInStep123LoadingTime = 8000;
    public static int SmallWaitingTime = 2800;
    public static int PriceChangeUrlWaitingTime = 20;
    public static int ValidationUrlWaitingTime = 30;
    
    // FOOTER HYPERLINKS
    
    public static String PressOfficeHyperlinkGb = urlfooterpress;
    public static String TermsAndConditionsHyperlinkGb = urlfooterterms;
    public static String PrivacyStatementHyperlinkGb = urlfooterprivacy;
    public static String WarrantyHyperlinkGb = urlfooterwarranty;
    public static String DremelEuropeHyperlinkGb = urlfootereurope;
    public static String SitemapHyperlinkGb = urlfootersitemap;
    
    // PATH FOR SCREENSHOTS
    
    public static String defaultPathScreenshot = "/Downloads/Master rad/Automation/screenshots";
                                        
    // SELECTING WEBDRIVER FOR BROWSER            
                                                       
    public ChromeDriver selectDriver(){
        System.setProperty("webdriver.chrome.driver","/Downloads/chromedriver");    
        WebDriver driver = new ChromeDriver();
        return (ChromeDriver) driver;
    }
}
