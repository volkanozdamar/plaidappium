package Steps;

import Helper.TestHelper;
import Pages.Toolbar;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.qameta.allure.Attachment;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class hamburgermenu {
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

    @Given("Open Hamburger Menu")
    public void openHamburgerMenu() {
        toolbar.HamburgerMenuOptions();
    }
    @Given("Check the element with index {int} is {string}")
    public void check_the_element_with_index_is(Integer int1, String string) {
        assertThat("HamburgerMenuOptions "+int1+1+"st Text",toolbar.selectHamburgerMenuOptionsElementText(int1),is(string));
    }
    @After
    public void TearDown(){
        driver.closeApp();
    }
}
