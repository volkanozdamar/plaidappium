package Tests;

import Pages.Toolbar;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ToolbarTest {
    AndroidDriver driver;
    Toolbar toolbar ;

    @BeforeEach
    public void test() throws Exception{

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "io.plaidapp");
        caps.setCapability("appActivity","io.plaidapp.Launcher");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        toolbar = new Toolbar(driver);


    }

    @Test
    public void changeThemeButton(){
        toolbar.ChangeTheme();
    }
    @Test
    public void drawerMenu(){
        toolbar.DrawerMenu();
        assertThat("Drawer Menu 1st Link",toolbar.DrawerMenuLink1st(),is("Popular Designer News"));
        assertThat("Drawer Menu 2nd Link",toolbar.DrawerMenuLink2nd(),is("“Material Design”"));
        assertThat("Drawer Menu 3nd Link",toolbar.DrawerMenuLink3rd(),is("Product Hunt"));
    }
    @Test
    public void hamburgerMenu(){
        toolbar.HamburgerMenuOptions();
        assertThat("HamburgerMenuOptions 1st Text",toolbar.selectHamburgerMenuOptionsElementText(0),is("Log in to Designer News"));
        assertThat("HamburgerMenuOptions 2nd Text",toolbar.selectHamburgerMenuOptionsElementText(1),is("About"));
    }

    @AfterEach
    public void TearDown(){
        driver.closeApp();
    }
}
