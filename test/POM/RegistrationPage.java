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
    public void setFirstNameField(String name) {
        WebElement nF = this.getCustomerFirstNameField();
        nF.clear();
        nF.sendKeys(name);
    }
    
    public void setLastNameField(String surname) {
        WebElement lnF = this.getCustomerLastNameField();
        lnF.clear();
        lnF.sendKeys(surname);
    }
    
    public void setPasswordField(String password) {
        WebElement pF = this.getPasswordField();
        pF.clear();
        pF.sendKeys(password);
    }
    
    public void setAdressField(String adress) {
        WebElement aF = this.getAdressField();
        aF.clear();
        aF.sendKeys(adress);
    }
    
    public void setCityField(String city) {
        WebElement cF = this.getCityField();
        cF.clear();
        cF.sendKeys(city);
    }
    
    public void setZipCodeField(String postalCode) {
        WebElement pF = this.getZipCodeField();
        pF.clear();
        pF.sendKeys(postalCode);
    }
    
    public void setMobilePhoneField(String mobilePhone) {
        WebElement mF = this.getMobilePhoneField();
        mF.clear();
        mF.sendKeys(mobilePhone);
    }
    
    public void setAdressAliasField(String alias) {
        WebElement aF = this.getAdressAlias();
        aF.clear();
        aF.sendKeys(alias);
    }
    
    public void setDate(String day, String month, String year) {
        Select selectDay = new Select(this.getBirthDropdownDay());
        Select selectMonth = new Select(this.getBirthDropdownMonth());
        Select selectYear = new Select(this.getBirthDropdownYear());
        
        selectDay.selectByValue(day);
        selectMonth.selectByValue(month);
        selectYear.selectByValue(year);
    }
    
    public void setState(String state) {
        Select selectState = new Select(this.getStateDropDown());
        selectState.selectByVisibleText(state);
    }
    
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
