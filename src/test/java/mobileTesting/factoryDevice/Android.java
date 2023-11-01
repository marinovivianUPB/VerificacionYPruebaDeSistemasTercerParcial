package mobileTesting.factoryDevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Android implements IDevice{
    @Override
    public AppiumDriver create(String appPackage, String appActivity) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","UPB2023_Android11");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("appPackage",appPackage);
        capabilities.setCapability("appActivity",appActivity);
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("autoGrantPermissions", "true");

        AndroidDriver device = null;
        try {
            device = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        device.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return device;
    }
}