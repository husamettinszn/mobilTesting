package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class WiewPage {

    public  WiewPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Tabs']")
    public List<WebElement> tabs;

    @AndroidFindBy(xpath = "//*[@text='WebView']")
    public WebElement webViev;
}
