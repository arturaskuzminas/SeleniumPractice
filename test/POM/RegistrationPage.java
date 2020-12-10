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
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Artūras
 */
public class RegistrationPage {
    
    protected WebDriver driver;
    //--------------------------------------------------------------------------
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    //--------------------------------------------------------------------------
    /**
     * Sets first name field text.
     * 
     * @param name - name value
     */
    public void setFirstNameField(String name) {
        WebElement nF = this.getCustomerFirstNameField();
        nF.clear();
        nF.sendKeys(name);
    }
    
    /**
     * Sets last name field text.
     * 
     * @param surname - surname value
     */
    public void setLastNameField(String surname) {
        WebElement lnF = this.getCustomerLastNameField();
        lnF.clear();
        lnF.sendKeys(surname);
    }
    
    /**
     * Sets password field text.
     * 
     * @param password - password value
     */
    public void setPasswordField(String password) {
        WebElement pF = this.getPasswordField();
        pF.clear();
        pF.sendKeys(password);
    }
    
    /**
     * Sets adress field text.
     * 
     * @param adress - adress value
     */
    public void setAdressField(String adress) {
        WebElement aF = this.getAdressField();
        aF.clear();
        aF.sendKeys(adress);
    }
    
    /**
     * Sets city field text.
     * 
     * @param city - city value
     */
    public void setCityField(String city) {
        WebElement cF = this.getCityField();
        cF.clear();
        cF.sendKeys(city);
    }
    
    /**
     * Sets zip code field text.
     * 
     * @param postalCode - postalCode value
     */
    public void setZipCodeField(String postalCode) {
        WebElement pF = this.getZipCodeField();
        pF.clear();
        pF.sendKeys(postalCode);
    }
    
    /**
     * Sets mobile phone field text.
     * 
     * @param mobilePhone - mobilePhone value
     */
    public void setMobilePhoneField(String mobilePhone) {
        WebElement mF = this.getMobilePhoneField();
        mF.clear();
        mF.sendKeys(mobilePhone);
    }
    
    /**
     * Sets adress alias field text.
     * 
     * @param alias - alias value
     */
    public void setAdressAliasField(String alias) {
        WebElement aF = this.getAdressAlias();
        aF.clear();
        aF.sendKeys(alias);
    }
    
    /**
     * Chooses date values from dropdown's.
     * @param day - day value
     * @param month - month value
     * @param year - year value
     */
    public void setDate(String day, String month, String year) {
        Select selectDay = new Select(this.getBirthDropdownDay());
        Select selectMonth = new Select(this.getBirthDropdownMonth());
        Select selectYear = new Select(this.getBirthDropdownYear());
        
        selectDay.selectByValue(day);
        selectMonth.selectByValue(month);
        selectYear.selectByValue(year);
    }
    
    /**
     * Chooses state value from dropdown.
     * 
     * @param state - state value
     */
    public void setState(String state) {
        Select selectState = new Select(this.getStateDropDown());
        selectState.selectByVisibleText(state);
    }
    
    /**
     * Chooses country value from dropdown.
     * 
     * @param country - country value
     */
    public void setCountry(String country) {
        Select selectCountry = new Select(this.getCountryDropDown());
        selectCountry.selectByVisibleText(country);
    }
    //--------------------------------------------------------------------------
    /***** SELECTORS GETTERS *****/
    
    public WebElement getTitleMrRadioBox() {
        return Utilities.waitToBeClickable(driver, By.id("id_gender1"), 5);
    }
    
    public WebElement getTitleMrsRadioBox() {
        return Utilities.waitToBeClickable(driver, By.id("id_gender2"), 5);
    }
    
    public WebElement getCustomerFirstNameField() {
        return Utilities.waitToBeClickable(driver, By.id("customer_firstname"), 5);
    }
    
    public WebElement getCustomerLastNameField() {
        return Utilities.waitToBeClickable(driver, By.id("customer_lastname"), 5);
    }
    
    public WebElement getEmailField() {
        return Utilities.waitToBeClickable(driver, By.id("email"), 5);
    }
    
    public WebElement getPasswordField() {
        return Utilities.waitToBeClickable(driver, By.id("passwd"), 5);
    }
    
    public WebElement getBirthDropdownDay() {
        return Utilities.waitForElementPresence(driver, By.id("days"), 5);
    }
    
    public WebElement getBirthDropdownMonth() {
        return Utilities.waitForElementPresence(driver, By.id("months"), 5);
    }
    
    public WebElement getBirthDropdownYear() {
        return Utilities.waitForElementPresence(driver, By.id("years"), 5);
    }
    
    public WebElement getNewsLetterCheckBox() {
        return Utilities.waitForElementPresence(driver, By.id("newsletter"), 5);
    }
    
    public WebElement getSpecialOffersCheckBox() {
        return Utilities.waitForElementPresence(driver, By.id("optin"), 5);
    }
    
    public WebElement getAdressField() {
        return Utilities.waitToBeClickable(driver, By.id("address1"), 5);
    }
    
    public WebElement getCityField() {
        return Utilities.waitToBeClickable(driver, By.id("city"), 5);
    }
    
    public WebElement getZipCodeField() {
        return Utilities.waitToBeClickable(driver, By.id("postcode"), 5);
    }
    
    public WebElement getStateDropDown() {
        return Utilities.waitForElementPresence(driver, By.id("id_state"), 5);
    }
    
    public WebElement getCountryDropDown() {
        return Utilities.waitForElementPresence(driver, By.id("id_country"), 5);
    }
    
    public WebElement getMobilePhoneField() {
        return Utilities.waitToBeClickable(driver, By.id("phone_mobile"), 5);
    }
    
    public WebElement getAdressAlias() {
        return Utilities.waitToBeClickable(driver, By.id("alias"), 5);
    }
    
    public WebElement getSubmitButton() {
        return Utilities.waitToBeClickable(driver, By.id("submitAccount"), 5);
    }
}
