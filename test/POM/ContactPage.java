/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
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
    /***** LOCATORS GETTERS *****/
    
    public WebElement getSubjectHeadingDrowDown() {
        return driver.findElement(By.id("id_contact"));
    }
    
    public WebElement getSubjectHeadingPopUp1() {
        return driver.findElement(By.xpath("//p[@id='desc_contact2']"));
    }
    
    public WebElement getSubjectHeadingPopUp2() {
        return driver.findElement(By.xpath("//p[@id='desc_contact1']"));
    }
    
    public WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }
    
    public WebElement getOrderRefDropDown() {
        return driver.findElement(By.xpath("//select[@name='id_order']"));
    }
    
    public WebElement getAttachFileField() {
        return driver.findElement(By.xpath("//input[@id='fileUpload']"));
    }
    
    public WebElement getMessageTextArea() {
        return driver.findElement(By.id("message"));
    }
    
    public WebElement getSuccessMessage() { 
        return driver.findElement(By.xpath("//p[@class='alert alert-success']"));
    }
    
    public WebElement getSumbitButton() {
        return driver.findElement(By.id("submitMessage"));
    }
    //--------------------------------------------------------------------------
    /***** ERROR MESSAGES *****/
    
    public WebElement getEmailInvalidError() {
        return driver.findElement(By.xpath("//li[normalize-space()='Invalid email address.']"));
    }
    
    public WebElement getBlankMessageError() {
        return driver.findElement(By.xpath("//li[normalize-space()='The message cannot be blank.']"));
    }
    
    public WebElement getSubjectHeadingUnselectedError() {
        return driver.findElement(By.xpath("//li[normalize-space()='Please select a subject from the list provided.']"));
    }
}
