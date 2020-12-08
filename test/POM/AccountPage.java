/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import Base.Utilities;
import org.openqa.selenium.*;

/**
 * Account page class.
 * 
 * @author Artūras
 */
public class AccountPage {

    protected WebDriver driver;
    //--------------------------------------------------------------------------
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    //--------------------------------------------------------------------------
    /***** LOCATORS GETTERS *****/
    
    public WebElement getWelcomeMessage() {
        return Utilities.waitForElementPresence(driver, By.className("info-account"), 5);
    }
    
    public WebElement getContactUsMenuTab() {
        return Utilities.waitToBeClickable(driver, By.id("contact-link"), 5);
    }
    
    public WebElement getMyStoreLogo() {
        return Utilities.waitToBeClickable(driver, By.xpath("//img[@alt='My Store']"), 5);
    }
}
