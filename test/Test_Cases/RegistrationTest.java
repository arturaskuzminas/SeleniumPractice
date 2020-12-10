/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Cases;

import Base.TestBase;
import POM.AccountPage;
import POM.LoginPage;
import POM.RegistrationPage;
import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Artūras
 */
public class RegistrationTest {
    
    protected WebDriver driver;
    private TestBase base;
    private LoginPage loginPage;
    private RegistrationPage regPage;
    private AccountPage accPage;
    ResourceBundle resources;
    //--------------------------------------------------------------------------
    /*
    Actions performed (navigation, object initialization) before tests.
    */
    @BeforeClass
    public void setUp() throws Exception {
        resources = ResourceBundle.getBundle("Properties.GlobalVariables");
        
        base = new TestBase();
        base.openChrome(resources.getString("loginPageURL"));
        driver = base.getDriver();
        
        loginPage = new LoginPage(driver);
        regPage = new RegistrationPage(driver);
        accPage = new AccountPage(driver);
    }
    //--------------------------------------------------------------------------
    /*
    1) Check behaviour by filling valid values to registration form 
    */
    @Test
    public void validRegistration() {
        loginPage.setRegEmailField("dasdasd@email.com");
        loginPage.getRegEmailButton().click();
        
        regPage.getTitleMrRadioBox().click();
        regPage.setFirstNameField("Jonas");
        regPage.setLastNameField("Jonaitis");
        regPage.getEmailField().click();
        regPage.setPasswordField("Testas12");
        regPage.setDate("3", "5", "1995");
        regPage.getNewsLetterCheckBox().click();
        regPage.getSpecialOffersCheckBox().click();
        regPage.setAdressField("Sabanausko g. 20-20");
        regPage.setCityField("Kaunas");
        regPage.setState("Florida");
        regPage.setZipCodeField("49991");
        regPage.setCountry("United States");
        regPage.setMobilePhoneField("869999999");
        regPage.setAdressAliasField("Alias");
        regPage.getSubmitButton().click();
        Assert.assertTrue(accPage.getWelcomeMessage().isDisplayed());
    }
    //--------------------------------------------------------------------------
    /*
    Tests end.
    */
    @AfterClass
    public void closeAll() throws Exception {
        base.quitChrome();
    }
}
