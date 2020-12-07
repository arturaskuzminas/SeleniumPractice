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
    //--------------------------------------------------------------------------
    /***** LOCATORS GETTERS *****/
    
    public WebElement getEmailField() {
        return driver.findElement(By.id("email")); 
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("passwd"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//span[normalize-space()='Sign in']"));
    }

    public WebElement getSignInForm() {
        return driver.findElement(By.id("login_form"));
    }
    //--------------------------------------------------------------------------
    /***** ERRORS *****/
    
    public WebElement getEmailRequiredError() {
        return driver.findElement(By.xpath("//li[contains(text(), \"An email address required.\")]"));
    }

    public WebElement getEmailInvalidError() {
        return driver.findElement(By.xpath("//li[contains(text(), \"Invalid email address.\")]"));
    }

    public WebElement getAuthenticationFailedError() {
        return driver.findElement(By.xpath("//li[contains(text(), \"Authentication failed.\")]"));
    }

    public WebElement getPasswordRequiredError() {
        return driver.findElement(By.xpath("//li[contains(text(), \"Password is required.\")]"));
    }

    public WebElement getInvalidPasswordError() {
        return driver.findElement(By.xpath("//li[contains(text(), \"Invalid password\")]"));
    }
    //--------------------------------------------------------------------------
    /***** HIGHLIGHTED ERRORS *****/
    
    public WebElement getEmailHighlightedRed() {
        return driver.findElement(By.xpath("//div[@class=\"form-group form-error\"]//input[@id=\"email\"]"));
    }

    public WebElement getEmailHighlightedGreen() {
        return driver.findElement(By.xpath("//div[@class=\"form-group form-ok\"]//input[@id=\"email\"]"));
    }
}
