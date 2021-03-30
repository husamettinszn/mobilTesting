package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.android.ApiDemosPage;
import pages.android.HomePage;
import pages.android.PreferencePage;
import pages.android.PreferenceFromCodePage;

public class SwitchStepDefinitions {

    HomePage homePage = new HomePage();
    ApiDemosPage apiDemosPage = new ApiDemosPage();
    PreferencePage prefecencePage = new PreferencePage();
    PreferenceFromCodePage preferenceFromCodePage = new PreferenceFromCodePage();

    @Given("kullanici API Demos sayfasina gider")
    public void kullanici_api_demos_sayfasina_gider() {
        homePage.apiDemos.click();
    }

    @Then("kullanici Preference sayfasina gider")
    public void kullanici_preference_sayfasina_gider() {
        apiDemosPage.prefecence.click();

    }

    @Then("kullanici Preference from code sayfasina gider")
    public void kullanici_preference_from_code_sayfasina_gider() {
        prefecencePage.preferenceFromCode.click();

    }

    @Then("kullanici switch tusuna tiklar")
    public void kullanici_switch_tusuna_tiklar() {
        preferenceFromCodePage.switchPreference.click();

    }

}
