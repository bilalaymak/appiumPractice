package testNGtests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utils.Driver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class practice01 {

    @Test
    public void test01() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"android_11");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:/Users/bilal/IdeaProjects/appiumPractice/apps/apiDemos.apk");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("autoAcceptAlert",true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        //adb shell
        //dumpsys window | grep -E "mCurrentFocus"
        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.findElement(By.xpath("//android.widget.TextView[@text='Support Design Demo: Cheesesquare']")).click();

        assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Support Design Demo: Cheesesquare']")).getText(),
                "Support Design Demo: Cheesesquare");

    }

    @Test
    public void test02(){
        Driver.getAppiumDriver();

       Driver.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[@text='Support Design Demo: Cheesesquare']")).click();
        assertEquals( Driver.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[@text='Support Design Demo: Cheesesquare']")).getText(),
                "Support Design Demo: Cheesesquare");



    }


}
