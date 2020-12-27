package Pages;

import Base.TestBase;

import Helper.TestHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBySet;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Toolbar{

    private AndroidDriver<AndroidElement> driver;
    WebDriverWait wait ;

    public Toolbar(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 5000);
    }


    @AndroidFindBy(id = "io.plaidapp:id/menu_theme")
    AndroidElement  changethemebutton;

    @AndroidFindBy(className = "android.widget.FrameLayout")
    AndroidElement frame;

    @AndroidFindBy(id = "io.plaidapp:id/menu_filter")
    AndroidElement drawerMenuButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")
    AndroidElement drawerMenuLink1st;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView")
    AndroidElement drawerMenuLink2nd;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView")
    AndroidElement drawerMenuLink3rd;

    @AndroidFindBy(accessibility = "More options")
    AndroidElement hamburgerMenuOptions;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    AndroidElement getHamburgerMenuOptionsText;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout")
    private List<AndroidElement> hamburgerMenuOptionsElements;

    public void ChangeTheme(){
        TestHelper.waitElement(changethemebutton,wait);
        changethemebutton.click();
    }

    public void FrameStyle(){
       String color = frame.getCssValue("color");
       System.out.println(color);
    }
    public void DrawerMenu(){
        TestHelper.waitElement(drawerMenuButton,wait);
        drawerMenuButton.click();
    }
    public String DrawerMenuLink1st(){
        TestHelper.waitElement(drawerMenuLink1st,wait);
        return drawerMenuLink1st.getText();
    }
    public String DrawerMenuLink2nd(){
        TestHelper.waitElement(drawerMenuLink2nd,wait);
        return drawerMenuLink2nd.getText();
    }
    public String DrawerMenuLink3rd(){
        TestHelper.waitElement(drawerMenuLink3rd,wait);
        return drawerMenuLink3rd.getText();
    }

    public void HamburgerMenuOptions(){
        TestHelper.waitElement(hamburgerMenuOptions,wait);
        hamburgerMenuOptions.click();
    }


    public String selectHamburgerMenuOptionsElementText(int index){
        TestHelper.waitListElement(hamburgerMenuOptionsElements,wait,index);
        return hamburgerMenuOptionsElements.get(index).findElement(By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")).getText();
    }

}




