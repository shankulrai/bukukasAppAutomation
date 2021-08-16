package com.bukukas.pageObjects;

import com.bukukas.steps.BaseSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtpScreenPage extends BaseSteps {

    AppiumDriver driver;

    public OtpScreenPage(AppiumDriver driver)
    {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//android.widget.EditText[@content-desc='OTP Digit1']")
     WebElement otp1Field;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='OTP Digit2']")
    WebElement otp2Field;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='OTP Digit3']")
    WebElement otp3Field;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='OTP Digit4']")
    WebElement otp4Field;

    public void enterTheOTPInField(String data)
    {

       enterTextInField(otp1Field,Character.toString(data.charAt(0)));
        enterTextInField(otp2Field,Character.toString(data.charAt(1)));
        enterTextInField(otp3Field,Character.toString(data.charAt(2)));
        enterTextInField(otp4Field,Character.toString(data.charAt(3)));

    }

    public WebElement getOtp1Field()
    {
        return otp1Field;
    }

}
