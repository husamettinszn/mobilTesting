package stepdefinitions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
   /* @Before
    public void setUo(){

    }

    */
    @After
    public void tearDown(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);

        if (scenario.isFailed()){
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.quitAppiumDriver();
    }

}
