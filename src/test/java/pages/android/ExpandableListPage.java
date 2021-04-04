package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class ExpandableListPage {

    public ExpandableListPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Expandable Lists']")
    public WebElement expanable;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1. Custom Adapter']")
    public WebElement customerAdapter;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
    public WebElement peopleNames;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sample action']")
    public WebElement simpleAction;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public  WebElement toastMessage;

}
