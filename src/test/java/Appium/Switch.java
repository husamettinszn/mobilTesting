package Appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;


public class Switch extends  Base{

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = lunchAndroid();

        driver.findElementByXPath("//*[@text='API Demos']").click();
        driver.findElementByXPath("//*[@text='Preference']").click();
        driver.findElementByXPath("//*[@text='5. Preferences from code']").click();

        TouchAction touchAction = new TouchAction(driver);



        List<WebElement> checkBox1 = driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.CheckBox\").checked(false)");
        if (checkBox1.size()>0){
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkBox1.get(0)))).perform();
        }
        WebElement switchButton = driver.findElementByXPath("//*[@class='android.widget.Switch']");

        if (switchButton.getText().equals("OFF")){
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(switchButton))).perform();
        }

       // touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element())).perform();


    }
}
