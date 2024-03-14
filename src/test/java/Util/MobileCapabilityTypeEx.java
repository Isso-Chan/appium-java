package Util;

import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.CapabilityType;

public interface MobileCapabilityTypeEx extends CapabilityType {

    String APP = "app";
    String APP_ACTIVITY = "appActivity";
    String AUTOMATION_NAME = "automationName";
    String APP_PACKAGE = "appPackage";
    String AUTO_WEBVIEW = "autoWebview";
    String CLEAR_SYSTEM_FILES = "clearSystemFiles";
    String DEVICE_NAME = "deviceName";
    String ENABLE_PERFORMANCE_LOGGING = "enablePerformanceLogging";
    String EVENT_TIMINGS = "eventTimings";
    String FORCE_MJSONWP = "forceMjsonwp";
    String FULL_RESET = "fullReset";
    String LANGUAGE = "language";
    String LOCALE = "locale";
    String NEW_COMMAND_TIMEOUT = "newCommandTimeout";
    String ORIENTATION = "orientation";
    String OTHER_APPS = "otherApps";
    String PLATFORM_NAME = "platformName";
    String PLATFORM_VERSION = "platformVersion";
    String PRINT_PAGE_SOURCE_ON_FIND_FAILURE = "printPageSourceOnFindFailure";
    String UDID = "udid";
}
