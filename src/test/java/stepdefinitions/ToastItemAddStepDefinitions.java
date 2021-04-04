package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.android.ApiDemosPage;
import pages.android.ToastItemAddPage;
import pages.android.ViewPage;
import utilities.Driver;

public class ToastItemAddStepDefinitions {

    ApiDemosPage apiDemosPage = new ApiDemosPage();
    ViewPage viewPage = new ViewPage();
    ToastItemAddPage toastItemAddPage = new ToastItemAddPage();

    @Given("kullanici pop-up menuyu tiklar")

    public void kullanici_pop_up_menuyu_tiklar() throws InterruptedException {
        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Popup Menu\"))");
        viewPage.popupMenu.click();
    }

    @Given("kullanici make pop-up tiklar ve pop-up acildi mi onaylar")
    public void kullanici_make_pop_up_tiklar_ve_pop_up_acildi_mi_onaylar() {
       toastItemAddPage.makeAPopup.click();

        Assert.assertTrue(toastItemAddPage.addButton.isDisplayed());
        System.out.println("Popup acildi");
    }

    @Given("kullanici add i tiklar")
    public void kullanici_add_i_tiklar() {
       toastItemAddPage.addButton.click();
    }

    @Then("kullanici tost mesajini {string} onaylar")
    public void kullanici_tost_mesajini_onaylar(String string) {

        System.out.println(toastItemAddPage.toastMessage.getAttribute("name"));
        Assert.assertEquals(string, toastItemAddPage.toastMessage.getAttribute("name"));
    }

}
