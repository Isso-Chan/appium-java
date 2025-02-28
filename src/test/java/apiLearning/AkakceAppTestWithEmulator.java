package apiLearning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AkakceAppTestWithEmulator {

    public static void main(String[] args) {

        AppiumDriver appiumDriver;

        try {
            // Set DesiredCapabilities to send to Appium Server
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "Genymotion");
            caps.setCapability("appPackage", "com.akakce.akakce");
            caps.setCapability("appActivity", "com.akakce.akakce.ui.splash.SplashActivity");
            caps.setCapability("automationName", "uiautomator2");
            caps.setCapability("autoGrantPermissions", true); // Allows permissions automatically
            caps.setCapability("dontStopAppOnReset", true);  // Prevents app from closing during tests
            caps.setCapability("fullReset", false);
            caps.setCapability("noReset", true);


            // Set up Appium server URL to connect to (Appium Server which has already started manually in cmd command before)
            URL appiumServer = new URL("http://localhost:4723");
            appiumDriver = new AndroidDriver(appiumServer, caps);
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Step 1: Click on "Üye olmadan devam et" if visible
            try {
                WebElement guestButton = appiumDriver.findElement(By.id("com.akakce.akakce:id/continueWithoutRegister"));
                guestButton.click();
                System.out.println("Üye olmadan devam et clicked.");
            } catch (Exception e) {
                System.out.println("Login screen not displayed, continuing...");
            }

            // Step 2: Search for "Laptop"
            WebElement searchBox = appiumDriver.findElement(By.id("com.akakce.akakce:id/searchTextView"));
            searchBox.click();

            // Type "Laptop" and press Enter
            WebElement inputTextField = appiumDriver.findElement(
                    AppiumBy.id("com.akakce.akakce:id/searchTextView"));

            // Type each character individually (
            Actions actions = new Actions(appiumDriver);
            actions.moveToElement(inputTextField)
                    .click()
                    .sendKeys("Laptop")
                    .perform();

            actions.sendKeys(Keys.ENTER).perform();
            System.out.println("Searched for Laptop.");

            // Step 3: Click on "Filtrele" (Filter)
            WebElement filterButton = appiumDriver.findElement(AppiumBy.id("com.akakce.akakce:id/filterText"));
            filterButton.click();
            System.out.println("Filter button clicked.");

            // Step 4: Select "Bilgisayar, Donanım" category
            WebElement categoryOption = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Bilgisayar, Donanım']"));
            categoryOption.click();
            System.out.println("Selected 'Bilgisayar, Donanım' category.");

            // Step 5: Click "Ürünleri Gör" (See Products)
            WebElement seeProductsButton = appiumDriver.findElement(AppiumBy.id("com.akakce.akakce:id/applyFilterTextView"));
            seeProductsButton.click();
            System.out.println("Clicked 'Ürünleri Gör'.");

            // Step 6: Choose "En Yüksek Fiyat" (Highest Price) sorting option
            WebElement sortButton = appiumDriver.findElement(AppiumBy.id("com.akakce.akakce:id/selectedSortText"));
            sortButton.click();
            WebElement highPriceOption = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/sort_name\" and @text=\"En Yüksek Fiyat\"]"));
            highPriceOption.click();
            System.out.println("Sorted by En Yüksek Fiyat.");

            // Step 7: click on 10th element on the list
            int productsVisible = 0, productsScrolled = 0;
            List<WebElement> productList = List.of();
            int count = 0;
            loop:
            while (productsScrolled < 10) {
                // Re-fetch the list of product elements
                productList = appiumDriver.findElements(
                        AppiumBy.id("com.akakce.akakce:id/cellContainer")
                );
                for (WebElement webElement : productList) {
                    productsScrolled++;
                    if (productsScrolled == 9) {
                        webElement.click();
                        break loop;
                    }
                }

                // Print total products found
                System.out.println("Total Products scrolled: " + productsScrolled);

                // Scroll down and reload product list
                appiumDriver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"
                ));
            }

            // Step 8: Click "Ürüne Git" (Go to Product)
            WebElement goToProductButton = appiumDriver.findElement(By.id("com.akakce.akakce:id/detailBtnTextView"));
            goToProductButton.click();
            System.out.println("Clicked 'Ürüne Git'.");

            // Step 9: Verify "Satıcıya Git" (Go to Seller) button is displayed
            WebElement goToSellerButton = appiumDriver.findElement(AppiumBy.className("android.view.View"));
            if (goToSellerButton.isDisplayed()) {
                System.out.println("Verification Passed: 'Satıcıya Git' button is visible.");
            } else {
                System.out.println("Verification Failed: 'Satıcıya Git' button is NOT visible.");
            }

            // Close driver
            appiumDriver.quit();


        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception as needed
        }
    }
}
