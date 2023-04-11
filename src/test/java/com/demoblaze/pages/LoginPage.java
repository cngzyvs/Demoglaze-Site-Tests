package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "login2")
    public WebElement loginHomePage;

    @FindBy(id = "loginusername")
    public WebElement usernameInput;

    @FindBy(id = "loginpassword")
    public WebElement passwordInput;

    @FindBy(css = "[onclick='logIn()']")
    public WebElement submitButton;

    public void login(){

        String userName = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginHomePage.click();
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void login(String username, String password){
        loginHomePage.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
    public void verifyInvalidInputCredentials(String expectedMessage){
        BrowserUtils.waitFor(5);
        Alert alert = Driver.get().switchTo().alert();
        String actualMessage = alert.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
