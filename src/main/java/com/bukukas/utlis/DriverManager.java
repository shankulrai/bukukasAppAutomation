package com.bukukas.utlis;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager
{
    static AndroidDriver<?> driver;

    public static AndroidDriver<?> getDriver() {
        return driver;
    }

    public static AndroidDriver<?> setDriver(AndroidDriver<?> dir) {
        return driver = dir;
    }

    public static void setImplicitWait(AndroidDriver<?> driver)
    {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public static void closeDriver(AndroidDriver<?>driver) {
        driver.quit();
    }
}
