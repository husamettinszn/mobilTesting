package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class SpinnerPage {

    public SpinnerPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)), this);
    }
    @AndroidFindBy(xpath = "//*[@text='Spinner']")
    public WebElement spinner;

    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/spinner1")
    public WebElement colorDropdown;

    @AndroidFindBy(xpath = "//*[@text='blue']")
    public WebElement blue;

    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/spinner2")
    public WebElement planetDropdown;

    @AndroidFindBy(xpath = "//*[@text='Mars']")
    public WebElement Mars;

}
