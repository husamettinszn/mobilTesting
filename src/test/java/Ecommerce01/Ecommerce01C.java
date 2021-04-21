package Ecommerce01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Ecommerce01C {
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

        Thread.sleep(1000);

        List<WebElement> productPrices = driver.findElementsById("com.androidsample.generalstore:id/productPrice");

        String ilkAyakkabi= productPrices.get(0).getText();
        System.out.println(ilkAyakkabi);
        String ikinciAyakkabi = productPrices.get(1).getText();
        System.out.println(ikinciAyakkabi);

        double f1 = Double.parseDouble(ilkAyakkabi.substring(1));
        double f2 = Double.parseDouble(ikinciAyakkabi.substring(1));
        double sonuc = f1 + f2;
        String expectedTutar = String.valueOf((sonuc));

        WebElement toplamFiyat = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl");
        String toplamFiyatText = toplamFiyat.getText();
        double topF = Double.parseDouble(toplamFiyatText.substring(1));

        String actualTutar = String.valueOf(topF);

        Assert.assertEquals(expectedTutar,actualTutar, 0.0);
        }

    }
