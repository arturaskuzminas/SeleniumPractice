/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Cases;

import POM.AccountPage;
import POM.LoginPage;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Artūras
 */
public class LoginTest {

    protected WebDriver driver;
    private TestBase base;
    private LoginPage loginPage;
    private AccountPage accPage;
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
    }
    //--------------------------------------------------------------------------
    @Test(priority = 1)
    public void assertSignInLocators() {
        Assert.assertTrue(loginPage.getSignInForm().isDisplayed());
        Assert.assertTrue(loginPage.getEmailField().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
        Assert.assertTrue(loginPage.getLoginButton().isEnabled());
    }
    //--------------------------------------------------------------------------
    @Test(priority = 2)
    public void invalidCredentials() {
        // Teisingi/tikri prisijungimo duomenys
        // email: kaunaskaunietis2@gmail.com
        // password: Testas123 

        loginPage.signInWith("bjbbbhb@email.com", "nnininiin");
        Assert.assertTrue(loginPage.getAuthenticationFailedError().isDisplayed());

        loginPage.signInWith("kaunaskaunietis2@gmail.com", "idk");
        Assert.assertTrue(loginPage.getAuthenticationFailedError().isDisplayed());

        loginPage.signInWith("adom@email.com", "Testas123");
        Assert.assertTrue(loginPage.getAuthenticationFailedError().isDisplayed());
    }
    //--------------------------------------------------------------------------
    @Test(priority = 3)
    public void withoutCredentials() {
        loginPage.signInWith("", "data");
        Assert.assertTrue(loginPage.getEmailRequiredError().isDisplayed());

        loginPage.signInWith("bad@email.com", "");
        Assert.assertTrue(loginPage.getPasswordRequiredError().isDisplayed());

        loginPage.signInWith("", "");
        Assert.assertTrue(loginPage.getEmailRequiredError().isDisplayed());
    }
    //--------------------------------------------------------------------------
    @Test(priority = 4)
    public void emailFormat() {
        loginPage.setEmailField("email");
	loginPage.getPasswordField().click();
        Assert.assertTrue(loginPage.getEmailHighlightedRed().isDisplayed());
        
        loginPage.setEmailField("email@email");
	loginPage.getPasswordField().click();
        Assert.assertTrue(loginPage.getEmailHighlightedRed().isDisplayed());
        
        loginPage.setEmailField("email@email.email");
	loginPage.getPasswordField().click();
        Assert.assertTrue(loginPage.getEmailHighlightedGreen().isDisplayed());
    }
    //--------------------------------------------------------------------------
    @Test(priority = 5)
    public void validCredentials() {
        loginPage.signInWith("kaunaskaunietis2@gmail.com", "Testas123");
        Assert.assertTrue(accPage.getWelcomeMessage().isDisplayed());
    }
    //--------------------------------------------------------------------------
    @AfterClass
    public void closeAll() {
        base.quitChrome();
    }
}
