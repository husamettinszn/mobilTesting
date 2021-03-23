import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

public class A_Base {

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
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Husamettin\\IdeaProjects\\mobilTesting\\src\\Apps\\GestureTool (1).apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "false");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@text='Add gesture']")).click();
        //driver.findElementByXPath("//*[@text='Add gesture']").click();

    }
/*
    @Test
    public void testq() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
//        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Husamettin\\DownloadsGestureTool(1).apk");
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(5000);

        // xPath ile

        //driver.findElement(By.xpath("//*[@text='Add gesture']")).click();
        driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();

}

 */
}
