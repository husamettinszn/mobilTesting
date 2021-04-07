package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class ReusableMethodsH {

    AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();

    WebElement degisken = driver.findElementByXPath("");
}
