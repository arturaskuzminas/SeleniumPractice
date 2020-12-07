/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Cases;

import POM.AccountPage;
import POM.ContactPage;
import POM.LoginPage;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Artūras
 */
public class ContactUsTest {
    
    protected WebDriver driver;   
    private TestBase base;
    private LoginPage loginPage;
    private AccountPage accPage;
    private ContactPage contactPage;    
    ResourceBundle resources;
    //--------------------------------------------------------------------------
    @BeforeClass
    public void setUp() {
        base = new TestBase();
        resources = ResourceBundle.getBundle("Properties.GlobalVariables");
        
        base.openChrome(resources.getString("loginPageURL"));
        driver = base.getDriver();
        
        loginPage = new LoginPage(driver);
        accPage = new AccountPage(driver);
        contactPage = new ContactPage(driver);
        loginPage.signInWith("kaunaskaunietis2@gmail.com", "Testas123"); 
        accPage.getContactUsMenuTab().click();
    }
    
    //--------------------------------------------------------------------------
    @Test (priority = 1)
    public void assertContactPageLocators() {
        Assert.assertTrue(contactPage.getSubjectHeadingDrowDown().isEnabled());
        Assert.assertTrue(contactPage.getEmailField().isDisplayed());
        Assert.assertTrue(contactPage.getOrderRefDropDown().isEnabled());
        Assert.assertTrue(contactPage.getAttachFileField().isEnabled());
        Assert.assertTrue(contactPage.getMessageTextArea().isEnabled());
        Assert.assertTrue(contactPage.getSumbitButton().isEnabled());
    }
    
    @Test (priority = 2)
    public void errorMessagesTest() {
        contactPage.getEmailField().clear();
        contactPage.getEmailField().sendKeys("asdadasd");
        contactPage.getSumbitButton().click();
        Assert.assertTrue(contactPage.getEmailInvalidError().isDisplayed());
        
        contactPage.getEmailField().clear();
        contactPage.getEmailField().sendKeys("asdadasd@email.com");
        contactPage.getSumbitButton().click();
        Assert.assertTrue(contactPage.getBlankMessageError().isDisplayed());
        
        contactPage.getMessageTextArea().sendKeys("Hi, I have some problems with my account.");
        contactPage.getSumbitButton().click();
        Assert.assertTrue(contactPage.getSubjectHeadingUnselectedError().isDisplayed());
    }
    
    @Test (priority = 3)
    public void validMessageTest() { 
        Select dropdownSubject = new Select(contactPage.getSubjectHeadingDrowDown());
        dropdownSubject.selectByIndex(1);       
        Assert.assertTrue(contactPage.getSubjectHeadingPopUp1().isDisplayed());
        dropdownSubject.selectByIndex(2);
        Assert.assertTrue(contactPage.getSubjectHeadingPopUp2().isDisplayed());
        
        Select dropdownOrder = new Select(contactPage.getOrderRefDropDown());
        dropdownOrder.selectByIndex(2);   

        contactPage.attachFile("C:\\example.txt");
        contactPage.getMessageTextArea().sendKeys("Hi, I love your page");
        contactPage.getSumbitButton().click();
        
        Assert.assertTrue(contactPage.getSuccessMessage().isDisplayed());
    }
    //--------------------------------------------------------------------------
    @AfterClass
    public void closeAll() {
        driver.quit();
    }
}
