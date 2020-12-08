/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Cases;

import Base.TestBase;
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
    /*
    Actions performed (navigation, object initialization) before tests.
    */
    @BeforeClass
    public void setUp() {
        resources = ResourceBundle.getBundle("Properties.GlobalVariables");
        
        base = new TestBase();
        base.openChrome(resources.getString("loginPageURL"));
        driver = base.getDriver();
        
        loginPage = new LoginPage(driver);
        accPage = new AccountPage(driver);
    }
    //--------------------------------------------------------------------------
    /*
    Checks whether 'Login' page 'Sign in' form locators are visible and enabled 
    before executing tests.
    */
    @Test(priority = 1)
    public void assertSignInLocators() {
        Assert.assertTrue(loginPage.getSignInForm().isDisplayed());
        Assert.assertTrue(loginPage.getEmailField().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
        Assert.assertTrue(loginPage.getLoginButton().isEnabled());
    }
    //--------------------------------------------------------------------------
    /*
    1) Check error behaviour with invalid email and invalid password.
    2) Check error behaviour with valid email and invalid password.
    3) Check error behaviour with invalid email and valid password.
    */
    @Test(priority = 2)
    public void invalidCredentials() {
        // True login data
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
    /*
    1) Check error behaviour with blank email field and filled password field.
    2) Check error behaviour with filled email field and blank password field.
    3) Check error behaviour with blank email field and blank password field.
    */
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
    /*
    1) Check email field highlight behaviour with invalid password.
    2) Check email field highlight behaviour with invalid password (added @email).
    3) Check email field highlight behaviour with correct email.
    */
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
    /*
    Check login form behaviour with correct login details.
    */
    @Test(priority = 5)
    public void validCredentials() {
        loginPage.signInWith("kaunaskaunietis2@gmail.com", "Testas123");
        Assert.assertTrue(accPage.getWelcomeMessage().isDisplayed());
    }
    //--------------------------------------------------------------------------
    /*
    Tests end.
    */
    @AfterClass
    public void closeAll() {
        base.quitChrome();
    }
}
