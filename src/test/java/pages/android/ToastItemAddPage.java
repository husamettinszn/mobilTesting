package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class ToastItemAddPage {
    public ToastItemAddPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE A POPUP!']")
    public WebElement makeAPopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add']")
    public WebElement addButton;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public WebElement toastMessage;

}
