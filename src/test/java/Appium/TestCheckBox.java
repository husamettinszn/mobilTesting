package Appium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class TestCheckBox extends  Base{
    @Test
    public void test() throws MalformedURLException, InterruptedException {

        AndroidDriver driver = lunchAndroid();

        driver.findElementByXPath("(//*[@class='android.widget.TextView'])[3]").click();
        driver.findElementByXPath("//*[@text='Preference']").click();
        driver.findElementByXPath("//*[@text='3. Preference dependencies']").click();

        WebElement wifiSettings = driver.findElementByXPath("(//*[@class='android.widget.RelativeLayout'])[2]");
        WebElement tik = driver.findElementById("android:id/checkbox");

        if(!(tik.isSelected())) {
            tik.click();
        }
        wifiSettings.click();
        driver.findElementByXPath("//*[@class='android.widget.EditText']").sendKeys("Hello World");
        driver.findElementById("android:id/button1").click();

        driver.quit();

    }


}
