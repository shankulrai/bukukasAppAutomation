package com.bukukas.pageObjects;

import com.bukukas.steps.BaseSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HutangPage extends BaseSteps
{
    AppiumDriver driver;

    public HutangPage(AppiumDriver driver)
    {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//android.widget.Button[@content-desc='Tambah Hutang Piutang']/android.view.ViewGroup/android.widget.TextView")
    WebElement amountDisplay;

    public WebElement getAmountDisplay()
    {
        return amountDisplay;
    }
}
