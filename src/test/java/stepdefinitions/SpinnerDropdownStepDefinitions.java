package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.android.SpinnerPage;
import pages.android.ViewPage;
import utilities.Driver;

public class SpinnerDropdownStepDefinitions {
    SpinnerPage spinnerPage = new SpinnerPage();

    @When("kullanici Spinner sayfasina gider")
    public void kullanici_spinner_sayfasina_gider() {

        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Spinner\"))");

        spinnerPage.spinner.click();
    }

    @When("kullanici ilk dropdown menusunde {string} secer ve onaylar")
    public void kullanici_ilk_dropdown_menusunde_secer_ve_onaylar(String string) {
        spinnerPage.colorDropdown.click();
        spinnerPage.blue.click();

        Assert.assertTrue(spinnerPage.blue.getText().equals("blue"));
        
    }

    @Then("kullanici ikinci dropdown menusunde {string} secer ve onaylar")
    public void kullanici_ikinci_dropdown_menusunde_secer_ve_onaylar(String string) {
        spinnerPage.planetDropdown.click();
        spinnerPage.Mars.click();

        Assert.assertEquals("Mars", spinnerPage.Mars.getText());

    }

}
