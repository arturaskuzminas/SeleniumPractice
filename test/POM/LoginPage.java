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
 * Login page class.
 * 
 * @author Artūras
 */
public class LoginPage {

    protected WebDriver driver;
    //--------------------------------------------------------------------------
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //--------------------------------------------------------------------------
    /**
     * Method cleans email and password text boxes, sets given email and password
     * and clicks "Sign in" button".
     * @param email - email value
     * @param password - password value
     */
    public void signInWith(String email, String password) {
        getEmailField().clear();
        getPasswordField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }
    
    /**
     * Method cleans email text box and sets given value to it.
     * @param mail - email value
     */
    public void setEmailField(String mail) {
        WebElement email = this.getEmailField();
        email.clear();
        email.sendKeys(mail);
    }
    
    /**
     * Method cleans password text box and sets given value to it.
     * @param pass - password value
     */
    public void setPasswordField(String pass) {
        WebElement password = this.getPasswordField();
        password.clear();
        password.sendKeys(pass);
    }
    
    public void setRegEmailField(String mail) {
        WebElement email = this.getRegEmailField();
        email.clear();
        email.sendKeys(mail);
    }
    //--------------------------------------------------------------------------
    /***** SELECTORS GETTERS *****/
    
    public WebElement getRegEmailField() {
        return Utilities.waitToBeClickable(driver, By.id("email_create"), 5);
    }
    
    public WebElement getRegEmailButton() {
        return Utilities.waitToBeClickable(driver, By.id("SubmitCreate"), 5);
    }
    
    public WebElement getEmailField() {
        return Utilities.waitToBeClickable(driver, By.id("email"), 5); 
    }

    public WebElement getPasswordField() {
        return Utilities.waitToBeClickable(driver, By.id("passwd"), 5);
    }

    public WebElement getLoginButton() {
        return Utilities.waitToBeClickable(driver, By.xpath("//span[normalize-space()='Sign in']"), 5);
    }

    public WebElement getSignInForm() {
        return driver.findElement(By.id("login_form"));
    }
    //--------------------------------------------------------------------------
    /***** ERRORS *****/
    
    public WebElement getEmailRequiredError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An email address required.\")]"), 5);
    }

    public WebElement getEmailInvalidError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 5);
    }

    public WebElement getAuthenticationFailedError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Authentication failed.\")]"), 5);
    }

    public WebElement getPasswordRequiredError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Password is required.\")]"), 5);
    }

    public WebElement getInvalidPasswordError() {
        return Utilities.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid password\")]"), 5);
    }
    //--------------------------------------------------------------------------
    /***** HIGHLIGHTED ERRORS *****/
    
    public WebElement getEmailHighlightedRed() {
        return Utilities.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]//input[@id=\"email\"]"), 5);
    }

    public WebElement getEmailHighlightedGreen() {
        return Utilities.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]//input[@id=\"email\"]"), 5);
    }
}
