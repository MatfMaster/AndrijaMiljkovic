package com.dremel.Pages.ProductPages;

import com.dremel.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andrija Miljkovic
 */
public class GlueGun extends Page{
    
    // MAIN CLASS CONSTRUCTOR
    public GlueGun (WebDriver driver) {
        super(driver);
    }
       
    // ELEMENTS
    
    // DREMEL Glue Gun 930 (930-18 Hobby) Add to cart
    @FindBy (id = "F0130930JB-add-to-cart")
    WebElement GlueGun930AddToCartGB;
    
    // METHODS
    
    public void addToCartGlueGun930Gb(){
        scroll_element_into_view(GlueGun930AddToCartGB);
        fluentWait(GlueGun930AddToCartGB).click();
    }
}
