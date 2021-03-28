package Appium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

public class UiSelectorPrac extends Base{

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = lunchAndroid();
        driver.findElementByXPath("//*[@text='API Demos']").click();
        driver.findElementByXPath("//*[@text='Preference']").click();
        driver.findElementByXPath("//*[@text='7. Fragment']").click();

        List<WebElement> checkBox1 = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checked(false)");

        if(checkBox.size()>0){
            checkBox.get(0).click();
        }

        


    }
}
