package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class WebAppChrome {
    @Test
    public void test1() throws MalformedURLException, InterruptedException {
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

        driver.get("https://www.facebook.com");
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

        Thread.sleep(1000);

        WebElement acceptAll = driver.findElementByXPath("//*[@id='accept-cookie-banner-label']");


        Thread.sleep(1000);
        acceptAll.click();

        Thread.sleep(1000);

        WebElement emailTextBox = driver.findElementByXPath("//input[@id='m_login_email']");
        Thread.sleep(1000);

        emailTextBox.sendKeys("husamettinszn@gmail.com");

        WebElement passwordTextBox = driver.findElementByXPath("//*[@class='_56bg _4u9z _27z2 _8qtm']");
        Thread.sleep(1000);

        WebElement logIn = driver.findElementByXPath("//*[@class='_54k8 _52jh _56bs _56b_ _28lf _9cow _56bw _56bu']");
        logIn.click();

        passwordTextBox.sendKeys("hsm123.123");

        Thread.sleep(3000);
        driver.quit();

    }
}
