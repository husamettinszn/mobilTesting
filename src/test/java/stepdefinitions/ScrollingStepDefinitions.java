package stepdefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import pages.android.ViewPage;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class ScrollingStepDefinitions {

    ViewPage wiewPage = new ViewPage();

    @Given("kullanici Tabs sayfasina gider")
    public void kullanici_tabs_sayfasina_gider() {


        List<WebElement> items;

        do {
            items = wiewPage.tabs;

            Dimension dimension = Driver.getAppiumDriver().manage().window().getSize();

            int start_x = (int) (dimension.width * 0.5);
            int start_y = (int) (dimension.height * 0.8);

            int end_x = (int) (dimension.width * 0.5);
            int end_y = (int) (dimension.height * 0.4);

            TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
            touchAction.press(PointOption.point(start_x, start_y)).
                    waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                    moveTo(PointOption.point(end_x, end_y)).release().perform();
        }while (items.size()==0);

        if (items.size()>0){
            items.get(0);
        }
    }

    @And("kullanici webViewsayfasina gider")
    public void kullaniciWebViewsayfasinaGider() {
        AndroidDriver androidDriver = (AndroidDriver) Driver.getAppiumDriver();

        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");

        wiewPage.webViev.click();
    }
}
