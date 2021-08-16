package com.bukukas.pageObjects;

import com.bukukas.steps.BaseSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseSteps
{
    AppiumDriver driver;

    public HomePage(AppiumDriver driver)
    {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

  @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Lainnya Tab']")
    WebElement lainnyaTab;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Hutang Tab']")
     WebElement hutangTab;

    @FindBy(xpath="//android.widget.Button[@content-desc='Tambah Hutang Piutang']/android.view.ViewGroup/android.widget.TextView")
    WebElement tambahHutangButton;

    public WebElement getLainnyaTab()
    {
        return lainnyaTab;
    }

    public void clickOnHutangTab()
    {
        clickOnElemnt(hutangTab);
    }

    public void clickOnlainnyaTab()
    {
        clickOnElemnt(lainnyaTab);
    }

    public void clickOntambahHutangButton()
    {
        clickOnElemnt(tambahHutangButton);
    }


}
