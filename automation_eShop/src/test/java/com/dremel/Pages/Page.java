package com.dremel.Pages;

import com.google.common.base.Function;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author Andrija Miljkovic
 */
public class Page {
    
    public WebDriver driver;
    
    // MAIN CLASS CONSTRUCTOR
    public Page (WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver, this);
    }
    
    // FLUENT WAIT
    public WebElement fluentWait(final WebElement locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(90, TimeUnit.SECONDS)
            .pollingEvery(2, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(
            new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return locator;
            }
        }
    );
    return foo;
};
    
    // ELEMENTS HEADER
    
    // Products on Header
    @FindBy (id = "header-products")
    WebElement productsHeader;
    
    // Inspiration on Header
    @FindBy (id = "header-inspiration")
    WebElement inspirationHeader;
    
    // Support on Header
    @FindBy (id = "header-support")
    WebElement supportHeader;
    
    // Search Input on Header
    @FindBy (id = "header-search-input")
    WebElement searchInputHeader;
    
    // User Profile on Header
    @FindBy (id = "header-user-profile")
    WebElement userProfileHeader;
    
    // ShoppingCart on Header
    @FindBy (id = "header-basket")
    WebElement shoppingCartHeader;
    
    // Order on Shopping Cart
    @FindBy (id = "shoppingcart-flyout-orders")
    WebElement OrderShoppingCart;
            
    // Continue Shopping on Shopping Cart
    @FindBy (id = "shoppingcart-flyout-close")
    WebElement ContinueShoppingCart;  
    
    // OK button Cookie manager
    @FindBy (id = "header-cookie-manager-agree")
    WebElement OkCookieManagerHeader;
    
    // ELEMENTS FOOTER
    
    // PressOffice on Footer
    @FindBy (id = "press-office-footer-link")
    WebElement pressOfficeFooter;
    
    // Terms and Conditions on Footer
    @FindBy (id = "terms-and-conditions-footer-link")
    WebElement termsAndConditionsFooter;
    
    // Privacy Statement on Footer
    @FindBy (id = "privacy-statement-footer-link")
    WebElement privacyStatementFooter;
    
    // Warranty on Footer
    @FindBy (id = "warranty-footer-link")
    WebElement warrantyFooter;
    
    // Dremel Europe on Footer
    @FindBy (id = "dremel-europe-footer-link")
    WebElement dremelEuropeFooter;
    
    // Sitemap on Footer
    @FindBy (id = "sitemap-footer-link")
    WebElement sitemapFooter;
    
    // Cookie Settings on Footer
    @FindBy (id = "cookie-settings-footer-link")
    WebElement cookieSettingsFooter;
    
    // Tools on page found by class
//    @FindBy (xpath = "//*[contains(@id, '-buy-now')]")
//    List<WebElement> productsNumber;
    @FindBy (css = ".btn.add-to-card-button")
    List<WebElement> productsNumber;   
    
    //PAGE
    @FindBy (tagName = "html")
    public WebElement page;
    
    //METHODS:
    
    public void order(){
        fluentWait(OrderShoppingCart).click();
    }
    
    public void continueShopping(){
        fluentWait(ContinueShoppingCart).click();
    }
    
    public String currentUrl(){
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    // FOOTER HYPERLINK METHODS
    
    public String getPressOfficeHyperlink(){
        return fluentWait(pressOfficeFooter).getAttribute("href");        
    }
    
    public String getTermsAndConditionsHyperlink(){
        return fluentWait(termsAndConditionsFooter).getAttribute("href");        
    }
    
    public String getPrivacyStatemenHyperlink(){
        return fluentWait(privacyStatementFooter).getAttribute("href");        
    }
    
    public String getWarrantyHyperlink(){
        return fluentWait(warrantyFooter).getAttribute("href");        
    }
    
    public String getDremelEuropeHyperlink(){
        return fluentWait(dremelEuropeFooter).getAttribute("href");        
    }
    
    public String getSitemapHyperlink(){
        return fluentWait(sitemapFooter).getAttribute("href");        
    }
    
    public void takeScreenshot(String fileName) throws IOException{
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk-mm-ss");
        Date date = new Date();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(Constants.defaultPathScreenshot+fileName+"-"+dateFormat.format(date)+".png"));
    }
    
    // FLOATING HEADER HANDLER
    public void scroll_element_into_view(WebElement element) {
    int Y = (element.getLocation().getY() - 200);
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("javascript:window.scrollTo(0," + Y + ");");}
}
