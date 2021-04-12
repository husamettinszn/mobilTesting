package Ecommerce01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Ecommerce01Positive {

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
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Husamettin\\IdeaProjects\\mobilTesting\\src\\Apps\\General-Store (1).apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(5000);

        //driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Germany\"))").click();
        //driver.findElementByXPath("//*[@text='Germany']").click(); boyle de tiklanabilir
        driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Betül");
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();


    }
}
