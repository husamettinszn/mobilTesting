package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.android.ViewPage;
import utilities.Driver;

public class UiScrollableStepDefinitions {

    ViewPage viewPage = new ViewPage();

    @Given("kullanici textswitcher secenegini secer")
    public void kullanici_textswitcher_secenegini_secer() {

        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextSwitcher\"))");
        viewPage.textSwitcher.click();
    }

    @Given("kullanici next butonuna iki kez tiklar")
    public void kullanici_next_butonuna_iki_kez_tiklar() {
        viewPage.nextButton.click();
        viewPage.nextButton.click();

    }

    @Then("kullanici sayinin iki oldugunu dogrular")
    public void kullanici_sayinin_iki_oldugunu_dogrular() {

        System.out.println(viewPage.sayi.getText());
        Assert.assertEquals("2", viewPage.sayi.getText());
        System.out.println("Sonuc test edildi");

    }

}
