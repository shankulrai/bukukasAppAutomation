package com.bukukas.utlis;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory
{
    public AndroidDriver<?> createDriverInstance( String platformname, String devicename, String platformversion, String apppackage, String appactivity) throws MalformedURLException, MalformedURLException {
        AndroidDriver<?> driver = null;
        if(platformname.equalsIgnoreCase("Android"))
        {
            System.out.println(platformname+devicename+platformversion+apppackage+appactivity);
            //initiation of Appium Driver
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformversion);
            cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apppackage);
            cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appactivity);
            cap.setCapability("disableWindowAnimation", "true" );
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
            DriverManager.setDriver(driver);
            DriverManager.setImplicitWait(DriverManager.getDriver());

        }else if(platformname.equalsIgnoreCase("iOS"))
        {

        }else{

        }

        return driver;

    }
}
