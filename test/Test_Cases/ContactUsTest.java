/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Cases;

import Base.TestBase;
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

    ResourceBundle resources;
    protected WebDriver driver;
    private TestBase base;
    private LoginPage loginPage;
    private AccountPage accPage;
    private ContactPage contactPage;
    //--------------------------------------------------------------------------
    /*
    Actions performed (navigation, object initialization) before tests.
    */
    @BeforeClass
    public void setUp() {
        resources = ResourceBundle.getBundle("Properties.GlobalVariables");
        
        base = new TestBase();
        base.openChrome(resources.getString("loginPageURL"));
        driver = base.getDriver();

        accPage = new AccountPage(driver);
        contactPage = new ContactPage(driver);
        
        loginPage = new LoginPage(driver);      
        loginPage.signInWith("kaunaskaunietis2@gmail.com", "Testas123");
        
        accPage.getContactUsMenuTab().click();
    }
    //--------------------------------------------------------------------------
    /*
    Checks whether 'Contact Us' page locators are visible and enabled before 
    executing tests.
    */
    @Test(priority = 1)
    public void assertContactPageLocators() {
        Assert.assertTrue(contactPage.getSubjectHeadingDrowDown().isEnabled());
        Assert.assertTrue(contactPage.getEmailField().isDisplayed());
        Assert.assertTrue(contactPage.getOrderRefDropDown().isEnabled());
        Assert.assertTrue(contactPage.getAttachFileField().isEnabled());
        Assert.assertTrue(contactPage.getMessageTextArea().isEnabled());
        Assert.assertTrue(contactPage.getSumbitButton().isEnabled());
    }
    //--------------------------------------------------------------------------
    /*
    1) Check error behaviour with invalid email provided.
    2) Check error behaviour with correct email and blank message field.
    3) Check error behaviour with subject correct email and filled message with 
    unselected subject heading dropdown.
    */
    @Test(priority = 2)
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
    //--------------------------------------------------------------------------
    /*
    1) Check behaviour with correctly filled 'Contact Us' form details.
    */
    @Test(priority = 3)
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
    /*
    Tests end.
    */
    @AfterClass
    public void closeAll() {
        driver.quit();
    }
}
