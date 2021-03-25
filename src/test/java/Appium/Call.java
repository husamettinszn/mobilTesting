package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Call {
    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        //desiredCapabilities.setCapability(  "platformName", "Android");


        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //desiredCapabilities.setCapability("automationName", "UiAutomator");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Husamettin\\IdeaProjects\\mobilTesting\\src\\Apps\\Calculator (1).apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        desiredCapabilities.setCapability("appPackage", "com.android.dialer");
        desiredCapabilities.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(3000);
        WebElement tasten = driver.findElementByXPath("(//*[@class='android.widget.ImageButton'])[2]");
        tasten.click();
        WebElement num1 = driver.findElementById("com.android.dialer:id/dialpad_key_voicemail");
        WebElement num5 = driver.findElementById("com.android.dialer:id/five");

        WebElement call = driver.findElementById("com.android.dialer:id/dialpad_floating_action_button");

        num1.click();
        num1.click();
        num5.click();
        call.click();

        Thread.sleep(3000);

        WebElement close = driver.findElementById("com.android.dialer:id/incall_end_call");

        close.click();

        driver.quit();

}
}
