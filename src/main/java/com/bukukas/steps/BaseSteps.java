package com.bukukas.steps;

import com.bukukas.utlis.Constants;
import com.bukukas.utlis.DriverFactory;
import com.bukukas.utlis.DriverManager;
import cucumber.api.Scenario;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.util.Properties;

public class BaseSteps
{
    public WebDriverWait wait;
    public AndroidDriver driver;
    public static Properties configProperty;
    public static AppiumDriverLocalService service;
    public static AppiumServiceBuilder builder;
    public static DesiredCapabilities cap;
    public Scenario scenario;

    public void startServer() {
        // Set Capabilities
        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");


        // Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("0.0.0.0");
        builder.usingPort(4723);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        // Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Successfully started server");

    }

    public void stopServer() {
        service.stop();
    }

    public boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            // If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        System.out.println("isServerRunning:" + isServerRunning);
        return isServerRunning;
    }

    public void initializeTheDriver() throws MalformedURLException {

        try {
            FileInputStream config = new FileInputStream(new File(System.getProperty("user.dir")+ Constants.configFilePath));
            configProperty = new Properties();
            try {
                configProperty.load(config);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        driver = new DriverFactory().createDriverInstance(configProperty.getProperty("platformName"),
                configProperty.getProperty("deviceName"), configProperty.getProperty("platform_version"),
                configProperty.getProperty("appPackage"), configProperty.getProperty("appActivity"));
        System.out.println(configProperty.getProperty("platformName"));
        DriverManager.setDriver(driver);
        DriverManager.setImplicitWait(driver);
    }


    public void checkElementIsDisplayedOnPage(WebElement element)
    {
        //checking for element is Displayed on page
        element.isDisplayed();
        System.out.print(	element.isDisplayed());

    }

    public void checkforInvisibiltyofElement(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), 30);
        wait.until(ExpectedConditions.invisibilityOf(element));

    }


    public void clickOnElemnt(WebElement element)
    {
        // method for clicking a web element
        element.click();
    }

    public void enterTextInField(WebElement element,String text)
    {
        // method for entering text in textField
        element.sendKeys(text);

    }

    public void waitForElementToClickable(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    public String getTextFromElement(WebElement element)
    {
        // getTextFromTheWebElemnt
        String textofElement=element.getText();
        return textofElement;


    }


    protected void teardownTheDriver() {

        try {
            DriverManager.closeDriver(DriverManager.getDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
