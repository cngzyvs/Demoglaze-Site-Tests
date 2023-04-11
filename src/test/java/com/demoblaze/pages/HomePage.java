package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id="nameofuser")
    public WebElement welcomeUserName;

    public void verifyWelcomeMessage(){
        BrowserUtils.waitForVisibility(welcomeUserName,4);
        String actualMessage = welcomeUserName.getText();
        String expecterMessage = "Welcome "+ ConfigurationReader.get("username");
        Assert.assertEquals(expecterMessage,actualMessage);
    }

    public void verifyWelcomeMessage(String expectedMessage){
        BrowserUtils.waitForVisibility(welcomeUserName,4);
        String actualMessage = welcomeUserName.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
