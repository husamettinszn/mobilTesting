package Ecommerce01;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.an.E;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Ecommerce01WebView {

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

        Thread.sleep(1000);

        WebElement urun1 = driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']");

        List<WebElement> items = driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']");
        items.get(0).click();

        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\"Jordan Lift Off\"))");
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(UiSelector().text(\"Jordan Lift Off\"))");
        // text in locasyonunu yazarken UiSelector.text(\"\") yazariz

        List<WebElement> items1 = driver.findElementsById("com.androidsample.generalstore:id/productName");

        for (int i=0; i<items1.size(); i++){
            String producktName = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
            if (producktName.equals("Jordan Lift Off")){
                driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(i).click();
                break;

            }
        }

        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        Thread.sleep(2000);

        TouchAction action = new TouchAction(driver);

        List<WebElement> checkBox = driver.findElementsByAndroidUIAutomator("UiSelector().text(\"Send me e-mails on discounts related to selected products in future\").checked(false)");
        if (checkBox.size()>0) {


            action.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkBox.get(0)))).perform();
        }

        WebElement terms = driver.findElementById("com.androidsample.generalstore:id/termsButton");
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(terms))).perform();

        WebElement closeButton = driver.findElementById("android:id/button1");

        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(closeButton))).perform();

        WebElement visitButton = driver.findElementById("com.androidsample.generalstore:id/btnProceed");

        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(visitButton))).perform();

    }
}
