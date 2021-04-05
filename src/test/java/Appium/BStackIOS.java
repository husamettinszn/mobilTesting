package Appium;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BStackIOS {

    @Test
            public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "hsamettins1");
        caps.setCapability("browserstack.key", "x4Sp7dwpcTqBs2deAj1B");

        // Set URL of the application under test
        caps.setCapability("app", "bs://8587a9cccb8f356199a0fdab9cbce4195af591a1");

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("os_version", "12");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java iOS");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        /* Write your Custom code here */
        driver.findElementById("Text Button").click();

        IOSElement title = driver.findElementById("Text Output");
        Assert.assertTrue(title.isDisplayed());

        driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"Text Input\"]").sendKeys("IOS");

        Thread.sleep(3000);

        driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"UI Elements\"])[1]").click();

        driver.findElementById("Alert Button").click();

        IOSElement alert = driver.findElementById("This is a native alert.");

        Assert.assertTrue(alert.isDisplayed());

        driver.findElementById("OK").click();

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
