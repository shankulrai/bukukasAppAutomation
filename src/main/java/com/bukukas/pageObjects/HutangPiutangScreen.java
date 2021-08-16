package com.bukukas.pageObjects;

import com.bukukas.steps.BaseSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HutangPiutangScreen extends BaseSteps
{
    AppiumDriver driver;

    public HutangPiutangScreen(AppiumDriver driver)
    {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//android.widget.EditText[@content-desc='Jumlah']")
    WebElement rpTextField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Kontak Firstname1 Lastname1']/android.view.ViewGroup")
    WebElement pillahDariBukuButton;

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.TextView")
    List<WebElement> selectContactFromList;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='Catatan']")
    WebElement enterCommnetField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Simpan Transaksi']/android.widget.TextView")
    WebElement simpanTranasksButton;



    public void clicOnSimpanTranasksButton()
    {
        clickOnElemnt(simpanTranasksButton);
    }

    public void setEnterCommnetField(String data)
    {
        enterTextInField(enterCommnetField,data);
    }

    public void enterInRPField(String data)
    {
        enterTextInField(rpTextField,data);
    }

    public void  clickOnpillahDariBukuButton()
    {
        clickOnElemnt(pillahDariBukuButton);
    }

    public void setSelectContactFromList() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElemnt(selectContactFromList.get(4));
    }


}
