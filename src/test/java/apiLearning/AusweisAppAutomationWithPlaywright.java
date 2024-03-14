package apiLearning;

import com.microsoft.playwright.*;

import java.util.Collections;
import java.util.List;

public class AusweisAppAutomationWithPlaywright {
    public static void main(String[] args) {
        try {
            // Create a Playwright instance
            Playwright playwright = Playwright.create();

            Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setChromiumSandbox(false) // For Windows, sandbox must be disabled when using remote debugging
                    .setArgs(Collections.singletonList("--remote-debugging-port=4723"))); // Specify the debugging port (e.g., 9222)
            BrowserContext context = browser.newContext();

//            //open WindowsAppDriver on CMD
//            Runtime.getRuntime().exec("cmd /c start cmd.exe " +
//                    "/K \"cd C:\\Program Files (x86)\\Windows Application Driver " +
//                    "&& " +
//                    "WinAppDriver.exe");

            // Create a new page
            Page page = context.newPage();

            // Navigate to the Calculator application
            page.evaluate("window.location.href = 'calculator://'");
            //                capabilities.setCapability("appium:app", "C:\\Program Files\\AusweisApp\\AusweisApp.exe");

            List<Page> pages = context.pages();
            Page page1 = pages.get(1);
//            page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(p-> p.context().pages().size()==2),()-> page.getByText("Rechner öffnen?").click());
            // Pause briefly to ensure the calculator window is fully loaded
//            page.waitForTimeout(3000);

            // Switch to the calculator window
//            Page calculatorPage = context.pages().get(context.pages().size() - 1);

            // Perform interactions with the calculator
            // For example, let's click on the number 1 button
//            calculatorPage.click("name=1"); // Adjust selector according to your calculator app

//            calculatorPage.waitForLoadState();

            // Click on calculator buttons (example: 1 + 2 =)
            page1.click("#num1Button");
            page.click("#plusButton");
            page.click("#num2Button");
            page.click("#equalButton");

            // Extract the result and print it
            ElementHandle resultElement = page.waitForSelector("#CalculatorResults");
            String result = resultElement.innerText();
            System.out.println("Result: " + result);

            // Close the browser
            browser.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
