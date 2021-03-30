package Appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en_scouse.An;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import utilities.Driver;

import java.awt.*;
import java.net.MalformedURLException;
import java.time.Duration;

public class Scrolling extends Base{

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = lunchAndroid();

        driver.findElementByXPath("(//*[@class='android.widget.TextView'])[3]").click();
        driver.findElementByXPath("//*[@text='Animation']").click();

        Dimension dimension = driver.manage().window().getSize();

        int start_x = (int) (dimension.width*0.5);
        int start_y = (int) (dimension.height*0.8);

        int end_x = (int) (dimension.width*0.5);
        int end_y = (int) (dimension.height*0.4);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(start_x, start_y)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                moveTo(PointOption.point(end_x, end_y)).release().perform();
    }
}
