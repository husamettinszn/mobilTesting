package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class ApiDemosPage {

    public ApiDemosPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)), this);

    }
    @AndroidFindBy(xpath = "//*[@text='Preference']")
    public WebElement prefecence;

    @AndroidFindBy(xpath = "//*[@text='Views']")
    public WebElement wievs;

}
