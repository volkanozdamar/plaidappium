package Steps;

import Pages.Toolbar;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Attachment;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class drawermenu {
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

    @Then("First link must be correct")
    public void firstLinkMustBeCorrect() {
        assertThat("Drawer Menu 1st Link",toolbar.DrawerMenuLink1st(),is("Popular Designer News"));
    }

    @Given("Open Drawer Menu")
    public void openDrawerMenu() {
        toolbar.DrawerMenu();
    }

    @And("Third link must be correct")
    public void thirdLinkMustBeCorrect() {
        assertThat("Drawer Menu 3nd Link",toolbar.DrawerMenuLink3rd(),is("Product Hunt"));
    }

    @And("Second link must be correct")
    public void secondLinkMustBeCorrect() {
        assertThat("Drawer Menu 2nd Link",toolbar.DrawerMenuLink2nd(),is("“Material Design”"));
    }
    @After
    public void TearDown(){
        driver.closeApp();
    }

}
