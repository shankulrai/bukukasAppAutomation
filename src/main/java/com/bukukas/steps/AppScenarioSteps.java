package com.bukukas.steps;

import com.bukukas.pageObjects.*;
import com.bukukas.utlis.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.net.MalformedURLException;

public class AppScenarioSteps extends BaseSteps implements En
{
    LoginPage loginPage;
    OtpScreenPage otpScreenPage;
    HomePage homePage;
    HutangPiutangScreen hutangPiutangScreen;
    String amount = "100";
    HutangPage hutangPage;
    @Before
    public void setupLoginSteps(Scenario scenario) throws MalformedURLException {
        // initializing the driver
        initializeTheDriver() ;
        loginPage=new LoginPage(DriverManager.getDriver());
        otpScreenPage=new OtpScreenPage(DriverManager.getDriver());
        homePage=new HomePage(DriverManager.getDriver());
        hutangPiutangScreen=new HutangPiutangScreen(DriverManager.getDriver());

    }

    public AppScenarioSteps(){

        Given("^User is On loginScreen$", () -> {
            //loginPage.waitForSplashScreenToout();
            loginPage.checkSuggestedMobileNumberDialogPresent();
            loginPage.tapOnScreen();


        });

        Given("^check for CountryCode Field and Select \"([^\"]*)\"$", (String countryCode) -> {
            loginPage.checkCountryCodeButtonisDisplayed();
            loginPage.tapOnCountryCodeFlag();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loginPage.clickonCountryCode();

        });

        Given("^Click on the Mobile Number Field and Enter \"([^\"]*)\"$", (String mobileNumber) -> {
            loginPage.enterMobileNumberField(mobileNumber);
            loginPage.tapOnotpButton();

        });

        Then("^Enter the \"([^\"]*)\" for The User mobile$", (String otpValue) -> {
            Assert.assertTrue(otpScreenPage.getOtp1Field().isDisplayed());
            otpScreenPage.enterTheOTPInField(otpValue);


        });

        Then("^Verify that User should successfully login to application$", () -> {
            Assert.assertTrue(homePage.getLainnyaTab().isDisplayed());


        });

        Then("^Naviaget to hutang tab\\.$", () -> {
            homePage.clickOnHutangTab();

        });

        Then("^Tap on the tambah hutang piutang \\.$", () -> {
            homePage.clickOntambahHutangButton();


        });

        Then("^Add Amount in Rp in membri tab$", () -> {

            hutangPiutangScreen.enterInRPField(amount);

        });

        Then("^Tap onto the Pilih dari buku kontak$", () -> {
            hutangPiutangScreen.clickOnpillahDariBukuButton();

        });

        Then("^Pick the existing contact from the list -$", () -> {
            hutangPiutangScreen.setSelectContactFromList();
        });

        Then("^Add notes and select dates$", () -> {
            hutangPiutangScreen.setEnterCommnetField("Test Transaction");

        });

        Then("^Tap on simpan transaksi\\.$", () -> {
            hutangPiutangScreen.clicOnSimpanTranasksButton();


        });

        Then("^Utang pelanggan should be prefilled with the amount entered\\.$", () -> {
            Assert.assertTrue(hutangPage.getAmountDisplay().getText().endsWith(amount));

        });
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {

            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

        }
        System.out.println("test teardown!");
        System.out.println("Closing driver!");
        teardownTheDriver();

    }
}
