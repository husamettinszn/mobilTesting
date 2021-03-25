package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class WebAppChrome2 {
    @Test
    public void etsy() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        //desiredCapabilities.setCapability(  "platformName", "Android");


        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\Husamettin\\IdeaProjects\\mobilTesting\\driver\\chromedriver.exe");

        //desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(2000);

        driver.get("https://etsy.com");
        System.out.println("Suanki Durum: "+ driver.getContext());

        Set context = driver.getContextHandles();
        for (Object contextName : context) {
            System.out.println(contextName);
            Thread.sleep(2000);

            if (contextName.toString().contains("CHROMIUM")){
                driver.context((String) contextName);
            }
        }

        System.out.println("Son Durum: "+driver.getContext());
        Thread.sleep(2000);

        WebElement accept = driver.findElementByXPath("//*[@class='android.view.View']");
        Thread.sleep(2000);
        accept.click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@class='android.view.View']").click();

    }
}
