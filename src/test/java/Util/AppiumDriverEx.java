package Util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class AppiumDriverEx {

    public static AppiumDriver getAppiumDriver(){
        // Driver instance
        AppiumDriver appiumDriver = null;

        try {
            // Set DesiredCapabilities to send to Appium Server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.UDID, "FFY5T18918000295");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE, "com.wdiodemoapp");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.NEW_COMMAND_TIMEOUT,6);

            // Set up Appium server URL to connect to (Appium Server which has already started manually before)
            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AppiumDriver(appiumServer, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception as needed
        }

        return appiumDriver;
    }
}
