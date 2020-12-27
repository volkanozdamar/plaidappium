package Steps;

import Pages.Toolbar;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class changetheme{

    AndroidDriver driver;
    Toolbar toolbar ;

    @Before
    public void setUp() throws Exception{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "io.plaidapp");
        caps.setCapability("appActivity","io.plaidapp.Launcher");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        toolbar = new Toolbar(driver);
    }


    @Given("Change Theme")
    public void changeTheme() {
        toolbar.ChangeTheme();
    }
}
