/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import Base.Utilities;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Shop page class.
 * 
 * @author Artūras
 */
public class ShopPage {

    protected WebDriver driver;
    //--------------------------------------------------------------------------
    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }
    //--------------------------------------------------------------------------
    /**
     * Checks whether results in Shop page match search query.
     * @param searchQuery - text to search for
     * @return true | false
     */
    public boolean isFoundProductListMatchQuery(String searchQuery) {
        List<WebElement> itemNames = driver.findElements(getItemName());
        for (WebElement element : itemNames) {
            if (element.getText().toLowerCase().contains(searchQuery.toLowerCase())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private By getItemName() {
        return By.cssSelector(".product-container");
    }
    //--------------------------------------------------------------------------
    /***** LOCATORS GETTERS *****/
    
    public WebElement getMyStoreLogo() {
        return Utilities.waitToBeClickable(driver, By.xpath("//img[@alt='My Store']"), 5);
    }
    
    public WebElement getNoResultsFoundError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//p[@class='alert alert-warning']"), 5);
    }
}
