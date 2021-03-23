package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {
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
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(3000);

        WebElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        WebElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        WebElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        WebElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        WebElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        WebElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        WebElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        WebElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        WebElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        WebElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");

        WebElement add = driver.findElementById("com.google.android.calculator:id/op_add");
        WebElement equal = driver.findElementById("com.google.android.calculator:id/eq");

        // 35 + 87 = 122 islemini yap ve dogrula
        num3.click();
        num5.click();
        add.click();
        num8.click();
        num7.click();

        Thread.sleep(1000);
        WebElement proResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        String exp = "122";
        equal.click();

        Thread.sleep(1000);
        WebElement actualResult = driver.findElementById("com.google.android.calculator:id/result_final");

        Thread.sleep(1000);
        Assert.assertEquals(exp, actualResult.getText());

    }
}
