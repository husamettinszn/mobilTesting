package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class ViewPage {

    public ViewPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Tabs']")
    public List<WebElement> tabs;

    @AndroidFindBy(xpath = "//*[@text='WebView']")
    public WebElement webViev;

    @AndroidFindBy(xpath = "//*[@text='TextSwitcher']")
    public WebElement textSwitcher;

    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/next")
    public WebElement nextButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    public WebElement sayi;

}
