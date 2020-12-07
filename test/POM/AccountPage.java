/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import org.openqa.selenium.*;

/**
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
        return driver.findElement(By.className("info-account"));
    }
    
    public WebElement getContactUsMenuTab() {
        return driver.findElement(By.id("contact-link"));
    }
}
