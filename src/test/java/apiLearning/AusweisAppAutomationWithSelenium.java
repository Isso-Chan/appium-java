package apiLearning;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AusweisAppAutomationWithSelenium {

    public static void main(String[] args) {
        try {
            //open WindowsAppDriver on CMD
            Runtime.getRuntime().exec("cmd /c start cmd.exe " +
                    "/K \"cd C:\\Program Files (x86)\\Windows Application Driver " +
                    "&& " +
                    "WinAppDriver.exe");
//            "WinAppDriver.exe");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        WindowsDriver ausweisApp = null;
        try {
            Thread.sleep(1500);
            //Open Thunderbird App to read mails
            DesiredCapabilities capabilities = new DesiredCapabilities();//
            capabilities.setCapability("app", "C:\\Program Files\\AusweisApp\\AusweisApp.exe");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");
            capabilities.setCapability("udid", "D127C747-BEDB-48F6-AA08-5576714C4BB8");
            WebDriver ausweisApp = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities); //sessionID: "D127C747-BEDB-48F6-AA08-5576714C4BB8"
            ausweisApp.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
