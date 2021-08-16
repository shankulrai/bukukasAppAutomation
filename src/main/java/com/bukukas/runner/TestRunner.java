package com.bukukas.runner;


import com.bukukas.utlis.Constants;
import com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner;
import cucumber.api.CucumberOptions;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@CucumberOptions(features = {
        "src/main/resources/feature" }, glue = {
        "com.bukukas.steps" }, tags = {
        "@app" })
public class TestRunner extends ExtendedTestNGRunner {
    public static Properties configProperty;


    @BeforeSuite
    public void beforeSuite()
    {
        try {
            FileInputStream config = new FileInputStream(new File(System.getProperty("user.dir")+ Constants.configFilePath));
            configProperty = new Properties();
            configProperty.load(config);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
