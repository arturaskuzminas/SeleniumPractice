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
 * Product page class.
 * 
 * @author Artūras
 */
public class ProductPage {
    
    protected WebDriver driver;
    //--------------------------------------------------------------------------
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    //--------------------------------------------------------------------------
    /**
     * Sets review title text.
     * @param title - title text
     */
    public void setReviewTitleText(String title) {
        getCommentTitleField().clear();
        getCommentTitleField().sendKeys(title);
    }
    
    /**
     * Sets review message.
     * @param message - review message
     */
    public void setReviewContentText(String message) {
        getCommentContentField().clear();
        getCommentContentField().sendKeys(message);
    }
    //--------------------------------------------------------------------------
    /***** SELECTORS GETTERS *****/

    public WebElement getWriteReviewButton() {
        return Utilities.waitToBeClickable(driver, By.xpath("//a[normalize-space()='Write a review']"), 5);
    }
    
    public WebElement getCommentTitleField() {
        return Utilities.waitToBeClickable(driver, By.id("comment_title"), 5);
    }
    
    public WebElement getCommentContentField() {
        return Utilities.waitToBeClickable(driver, By.id("content"), 5);
    }
    
    public WebElement getSubmitMessageButton() {
        return Utilities.waitToBeClickable(driver, By.id("submitNewMessage"), 5);
    }   
    //--------------------------------------------------------------------------
    /***** ERRORS *****/
    
    public WebElement getTitleMissingError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[normalize-space()='Title is incorrect']"), 5);
    }
    
    public WebElement getContentMissingError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[normalize-space()='Comment is incorrect']"), 5);
    }
    
    public WebElement getReviewSuccesMessage() {
        return Utilities.waitForElementPresence(driver, By.xpath("//div[@class='fancybox-inner']"), 5);
    }
}
