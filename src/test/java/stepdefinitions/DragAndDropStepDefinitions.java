package stepdefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.touch.TouchActions;
import pages.android.ApiDemosPage;
import pages.android.DragAndDropPage;
import pages.android.WiewPage;
import utilities.Driver;

public class DragAndDropStepDefinitions {

    ApiDemosPage apiDemosPage = new ApiDemosPage();
    DragAndDropPage dragAndDropHome = new DragAndDropPage();
    WiewPage wiewPage = new WiewPage();

    @Given("kullanici wiev sayfasina gider")
    public void kullanici_wiev_sayfasina_gider() {
        wiewPage.wievs.click();
    }

    @Given("kullanici drag and drop sayfasina gider")
    public void kullanici_drag_and_drop_sayfasina_gider() {
        dragAndDropHome.dragAndDrop.click();
    }

    @Given("kullanici ilk butonu alip ikinci butona koyar")
    public void kullanici_ilk_butonu_alip_ikinci_butona_koyar() {
        TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
        touchAction.longPress(ElementOption.element(dragAndDropHome.ball1)).
                moveTo(ElementOption.element(dragAndDropHome.ball2)).release().perform();

    }

    @Then("text onaylar")
    public void text_onaylar() throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertTrue(dragAndDropHome.message.isDisplayed());

    }


}
