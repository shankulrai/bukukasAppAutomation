package com.bukukas.pageObjects;

import com.bukukas.steps.BaseSteps;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPage extends BaseSteps
{
    AppiumDriver driver;

    public LoginPage(AppiumDriver driver)
    {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout")
    WebElement splashScreen;

    @FindBy(xpath="//android.view.ViewGroup[@content-desc='Pilih Daerah']")
    WebElement countryCodeButton;

    @FindBy(xpath="//android.view.ViewGroup[@content-desc='Pilih Daerah India']/android.view.ViewGroup/android.widget.ImageView")
    WebElement selectCountryIndia;

    @FindBy(id="com.beecash.app:id/action_bar_root")
    WebElement rootScreen;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='Nomor telepon']")
    WebElement mobileField;

    @FindBy(xpath ="//android.view.ViewGroup[@content-desc='OTP via SMS']")
    WebElement otpViaSmsButton;

    @FindBy(id="com.google.android.gms:id/cancel")
    WebElement tapOnNoneOfABoveButton;


    public void tapOnScreen()
    {
        clickOnElemnt(rootScreen);
    }

    public void enterMobileNumberField(String data)
    {
        checkElementIsDisplayedOnPage(mobileField);
        enterTextInField(mobileField,data);
    }

    public void tapOnotpButton()
    {
        checkElementIsDisplayedOnPage(otpViaSmsButton);
        clickOnElemnt(otpViaSmsButton);
    }

    public void waitForSplashScreenToout()
    {
        checkforInvisibiltyofElement(splashScreen);
    }


    public void tapOnCountryCodeFlag()
    {
        clickOnElemnt(countryCodeButton);
    }

    public void checkCountryCodeButtonisDisplayed()
    {
        checkElementIsDisplayedOnPage(countryCodeButton);
        waitForElementToClickable(countryCodeButton);

    }

    public void clickonCountryCode()
    {
        waitForElementToClickable(selectCountryIndia);
        clickOnElemnt(selectCountryIndia);


    }

    public void checkSuggestedMobileNumberDialogPresent()
    {
        if(tapOnNoneOfABoveButton.isDisplayed()) {
            clickOnElemnt(tapOnNoneOfABoveButton);

        }
    }



}
