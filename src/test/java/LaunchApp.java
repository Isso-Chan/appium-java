import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class LaunchApp {
    public static void main(String[] args) {

        // Driver instance
        AppiumDriver appiumDriver;

        try {
            // Set DesiredCapabilities to send to Appium Server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("automationName", "uiautomator2");
            desiredCapabilities.setCapability("udid", "FFY5T18918000295");
            desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
            desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");

            // Set up Appium server URL to connect to (Appium Server which has already started manually before)
            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AppiumDriver(appiumServer, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            WebElement loginLabel = appiumDriver.findElement(By.xpath("//android.view.View[@content-desc='Login']"));
            loginLabel.click();

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception as needed
        }
    }
}
