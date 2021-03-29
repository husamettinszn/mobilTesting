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

        List<WebElement> checkBox1 = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").index(0).checked(false)");

        if(checkBox1.size()>0){
            checkBox1.get(0).click();
        }

        Thread.sleep(1000);
        //WebElement checkBox2 = driver.findElementByXPath("(//*[@class='android.widget.CheckBox'])[2]");
        //WebElement checkBox3 = driver.findElementByXPath("(//*[@class='android.widget.CheckBox'])[3]");

        //List<WebElement> checkBox2UnChecked = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").index(1).checked(false)");

        List<WebElement> checkBox2UnChecked = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").index(1).checked(false)");

        Thread.sleep(1000);

        if(checkBox2UnChecked.size()>0){

             checkBox2UnChecked.get(0).click();
         }
/*
        Thread.sleep(1000);
        List<WebElement> checkBox3Checked = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").index(2).checked(false)");

        Thread.sleep(1000);

        if(checkBox3Checked.size()>1) {

             checkBox3Checked.get(0).click();
         }


 */

    }
}
