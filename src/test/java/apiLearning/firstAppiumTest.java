package apiLearning;

import Util.AppiumDriverEx;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class firstAppiumTest {
    public static void main(String[] args) {
        AppiumDriver appiumDriver= AppiumDriverEx.getAppiumDriver();
        WebElement loginLabel = appiumDriver.findElement(By.xpath("//android.view.View[@content-desc='Login']"));
        loginLabel.click();

        WebElement emailField = appiumDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-email\"]"));
        emailField.sendKeys("ismailozcan73@gmail.com");

        WebElement passwordField = appiumDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"input-password\"]"));
        passwordField.sendKeys("password");

        WebElement loginButton = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text=\"LOGIN\"]"));
        loginButton.click();
    }
}
