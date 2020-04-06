package tin.thurein.appium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class AndroidTest extends BaseTest {
	private AndroidDriver<AndroidElement> driver;
    private final String MAIN_ACTIVITY = ".MainActivity";
    private final String PACKAGE = "tin.thurein.appium_test";

	@BeforeClass
    public void setUp() throws IOException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        System.out.println("Set up");
        File appDir = new File(classpathRoot, "../appium-test/apps");
        File app = new File(appDir.getCanonicalPath(), "app-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        // TODO to replace your device name here
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "R58M52JBXEY");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<AndroidElement>(getServiceUrl(), capabilities);
    }

	@AfterClass
    public void tearDown() {
		System.out.println("Tear down");
        driver.quit();
    }

    @Test
    public void testOpensAlert() throws Exception {
    	System.out.println("Open alert");
        driver.startActivity(new Activity(PACKAGE, MAIN_ACTIVITY));

        // Click button that opens a dialog
        String txt = driver.findElement(MobileBy.id("tvHelloWorld")).getText();
        AssertJUnit.assertEquals(txt, "Hello World!");
    }
}
