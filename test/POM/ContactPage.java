/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import Base.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contact page class.
 * @author Artūras
 */
public class ContactPage {
    
    protected WebDriver driver;
    //--------------------------------------------------------------------------
    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }
    //--------------------------------------------------------------------------
    /**
     * Attaches file to "Contact Us" form.
     * @param filePath - path to the file
     */
    public void attachFile(String filePath) {
        getAttachFileField().sendKeys(filePath);     
    }
    //--------------------------------------------------------------------------
    /***** SELECTORS GETTERS *****/
    
    public WebElement getSubjectHeadingDrowDown() {
        return Utilities.waitForElementPresence(driver, By.xpath("//select[@id='id_contact']"), 5);
    }
    
    public WebElement getSubjectHeadingPopUp1() {
        return Utilities.waitForElementPresence(driver, By.xpath("//p[@id='desc_contact2']"), 5);
    }
    
    public WebElement getSubjectHeadingPopUp2() {
        return Utilities.waitForElementPresence(driver, By.xpath("//p[@id='desc_contact1']"), 5);
    }
    
    public WebElement getEmailField() {
        return Utilities.waitToBeClickable(driver, By.id("email"), 5);
    }
    
    public WebElement getOrderRefDropDown() {
        return Utilities.waitForElementPresence(driver, By.xpath("//select[@name='id_order']"), 5);
    }
    
    public WebElement getAttachFileField() {
        return Utilities.waitForElementPresence(driver, By.xpath("//input[@id='fileUpload']"), 5);
    }
    
    public WebElement getMessageTextArea() {
        return Utilities.waitToBeClickable(driver, By.id("message"), 5);
    }
    
    public WebElement getSuccessMessage() { 
        return Utilities.waitForElementPresence(driver, By.xpath("//p[@class='alert alert-success']"), 5);
    }
    
    public WebElement getSumbitButton() {
        return Utilities.waitToBeClickable(driver, By.id("submitMessage"), 5);
    }
    //--------------------------------------------------------------------------
    /***** ERROR MESSAGES *****/
    
    public WebElement getEmailInvalidError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[normalize-space()='Invalid email address.']"), 5);
    }
    
    public WebElement getBlankMessageError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[normalize-space()='The message cannot be blank.']"), 5);
    }
    
    public WebElement getSubjectHeadingUnselectedError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[normalize-space()='Please select a subject from the list provided.']"), 5);
    }
}
