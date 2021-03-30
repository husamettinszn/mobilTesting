package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class DragAndDropPage {

    public DragAndDropPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(30)), this);

    }
    @AndroidFindBy(xpath = "//*[@text='Drag and Drop']")
    public WebElement dragAndDrop;

    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_1")
    public WebElement ball1;

    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_2")
    public WebElement ball2;

    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_3")
    public WebElement ball3;

    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/drag_text")
    public WebElement message;
}
