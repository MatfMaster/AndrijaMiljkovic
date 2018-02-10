package com.dremel.Pages.ProductPages;

import com.dremel.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andrija Miljkovic
 */
public class Dremel3000 extends Page {
    
    // MAIN CLASS CONSTRUCTOR
    public Dremel3000(WebDriver driver) {
        super(driver);
    }
    
    // ELEMENTS
    
    // DREMEL 3000 4 Star Kit (3000-3/55) Add to cart GB
    @FindBy (id = "F0133000MJ-add-to-cart")
    WebElement Dremel30004StarKitAddToCartGB;
    
    // DREMEL 3000 (3000-15) Add to cart GB
    @FindBy (id = "F0133000JB-add-to-cart")
    WebElement Dremel300015AddToCartGB;
    
    // DREMEL 3000 (3000-1/25 EZ) Add to cart GB
    @FindBy (id = "F0133000JR-add-to-cart")
    WebElement Dremel300025EzAddToCartGB;
    
    // DREMEL 3000 3 Star Kit (3000-05) Add to cart GB
    @FindBy (id = "F0133000ME-add-to-cart")
    WebElement Dremel30003StarKitAddToCartGB;
    
    // DREMEL 3000 5 Star Kit (3000-5/75) Add to cart GB
    @FindBy (id = "F0133000MP-add-to-cart")
    WebElement Dremel30005StarKitAddToCartGB;
    
    // METHODS
    
    public void addToCartDremel3000(){
        fluentWait(Dremel300015AddToCartGB).click();
    }
    
    
    }  
    


