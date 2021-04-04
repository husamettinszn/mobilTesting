package stepdefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.android.ExpandableListPage;
import utilities.Driver;

public class ExpandableStepDefinitions {

    ExpandableListPage expandableListPage = new ExpandableListPage();

    @When("kullanici Expandable List sayfasina tiklar")
    public void kullanici_expandable_list_sayfasina_tiklar() {
    expandableListPage.expanable.click();
    }

    @When("kullanici Custom Adaptoer linkine tiklar")
    public void kullanici_custom_adaptoer_linkine_tiklar() {
       expandableListPage.customerAdapter.click();
    }

    @When("kullanici People Names linkine uzun basar")
    public void kullanici_people_names_linkine_uzun_basar() {
        TouchAction action = new TouchAction(Driver.getAppiumDriver());
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableListPage.peopleNames))).perform();
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(expandableListPage.peopleNames))).perform();


    }

    @When("kullanici Sample action popup ina tiklar")
    public void kullanici_sample_action_popup_ina_tiklar() {
        expandableListPage.simpleAction.click();

    }

    @Then("kullanici toast mesajinin {string} icerdigini verify eder")
    public void kullaniciToastMesajininIcerdiginiVerifyEder(String toast) {
        System.out.println("mesaj : " + expandableListPage.toastMessage.getAttribute("name"));
        Assert.assertTrue(expandableListPage.toastMessage.getAttribute("name").contains(toast));
    }
}
